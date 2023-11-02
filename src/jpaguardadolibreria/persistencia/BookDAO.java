/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaguardadolibreria.persistencia;

import java.util.List;
import jpaguardadolibreria.entities.Book;

/**
 *
 * @author SAMUEL
 */
public class BookDAO extends DAO<Book> {
  
    /**
     *
     * @param e
     */
    @Override
    public void save(Book e) {
        super.save(e);
    }

    @Override
    public void delete(Book book){
        super.delete(book);
    }

    public List<Book> getBooks() throws Exception {
        connect();
        List<Book> books = em.createQuery("SELECT b FROM Book b ORDER BY b.title ASC").getResultList();
        disconnect();
        return books;
    }

    public Book getBookById(long id) throws Exception {
        connect();
        //Author author = (Author) em.createQuery("SELECT a FROM Author a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
        Book book = em.find(Book.class,id);
        disconnect();
        return book;
    }
    
    public Book getBookByName(String name) throws Exception {
        connect();
        Book book = (Book) em.createQuery("SELECT e FROM Book e WHERE e.name LIKE :name").setParameter("name","%" + name + "%").setMaxResults(1).getSingleResult();
        disconnect();
        return book;
    }
    
    @Override
    public void edit(Book book){
        super.edit(book);       
    }
    
    
}
