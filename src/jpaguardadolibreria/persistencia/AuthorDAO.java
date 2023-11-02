/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaguardadolibreria.persistencia;

import java.util.List;
import jpaguardadolibreria.entities.Author;

/**
 *
 * @author SAMUEL
 */
public class AuthorDAO extends DAO<Author>{   
    /**
     *
     * @param a
     */

    @Override
    public void save(Author a) {
        super.save(a);
    }

    @Override
    public void delete(Author a){
        super.delete(a);
    }

    public List<Author> getAuthors() throws Exception {
        connect();
        List<Author> authors = em.createQuery("SELECT a FROM Author a ORDER BY a.name ASC").getResultList();
        disconnect();
        return authors;
    }

    public Author getAuthorById(int id) throws Exception {
        connect();
        //Author author = (Author) em.createQuery("SELECT a FROM Author a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
        Author author = em.find(Author.class,id);
        disconnect();
        return author;
    }
    
    public Author getAuthorByName(String name) throws Exception {
        connect();
        Author author = (Author) em.createQuery("SELECT a FROM Author a WHERE a.name LIKE :name").setParameter("name",name).getSingleResult();
        disconnect();
        return author;
    }
    
    @Override
    public void edit(Author a){        
        super.edit(a);
    }
    
}
