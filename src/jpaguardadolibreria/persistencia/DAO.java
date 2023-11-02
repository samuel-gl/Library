/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaguardadolibreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SAMUEL
 * @param <T>
 */
public class DAO<T> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("jpaGuardadoLibreriaPU");
    protected EntityManager em = EMF.createEntityManager();
    
    // Este método nos permite conectar con la base de datos
    // se verifica si la conexión está realizada, en caso que
    // no esté realizada, se realiza en la línea 24.
    protected void connect() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    // Este método nos permite desconectarnos de la base de datos
    // Se verifica si existe una conexión, y de ser el caso, se
    // cierra la conexión y se desconecta el programa con la base de datos.
    protected void disconnect() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    // este método nos permite persistir un objeto en la base de datos.
    // Toma como parámetro el objeto a persistir, vemos que es genérico, por
    // lo que puede aceptar cualquier tipo de objeto (Dirección, Mastoca, Persona)
    protected void save(T object){
        connect();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        disconnect();
    }
    
    // Este método nos permite modificar una tupla de una base de datos.
    // Recibe como parámetro el objeto con los datos cambiados (debe mantener
    // la misma llave primaria) y lo reemplaza por el anterior.
    protected void edit(T object){
        connect();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        disconnect();
    }
    
    // Este método nos permite eliminar un registro de la base de datos.
    // Como parámetro se pasa el objeto a eliminar de la base de datos.
    // Se busca en la base de datos el registro que contenga la misma información
    // que el parámetro recibido, y se elimina.
    protected void delete(T object){
        connect();
        em.getTransaction().begin();
        //
        if (!em.contains(object)) {
            object = em.merge(object);
        }
        //
        em.remove(object);
        em.getTransaction().commit();
        disconnect();
    }

}