/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaguardadolibreria.persistencia;

import java.util.List;
import jpaguardadolibreria.entities.Editorial;

/**
 *
 * @author SAMUEL
 */
public class EditorialDAO extends DAO<Editorial>{
  
    /**
     *
     * @param e
     */
    @Override
    public void save(Editorial e) {
        super.save(e);
    }

    /**
     *
     * @param editorial
     * @throws Exception
     */
    @Override
    public void delete(Editorial editorial){
        super.delete(editorial);
    }

    public List<Editorial> getEditorials() throws Exception {
        connect();
        List<Editorial> editorials = em.createQuery("SELECT e FROM Editorial e ORDER BY e.name ASC").getResultList();
        disconnect();
        return editorials;
    }

    public Editorial getEditorialById(int id) throws Exception {
        connect();
        //Author author = (Author) em.createQuery("SELECT a FROM Author a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
        Editorial editorial = em.find(Editorial.class,id);
        disconnect();
        return editorial;
    }
    
    public Editorial getEditorialByName(String name) throws Exception {
        connect();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.name LIKE :name").setParameter("name","%" + name + "%").setMaxResults(1).getSingleResult();
        disconnect();
        return editorial;
    }
    
    @Override
    public void edit(Editorial editorial){
        super.edit(editorial);       
    }
    
}
