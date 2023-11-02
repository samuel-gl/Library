/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaguardadolibreria.entities.Author;
import jpaguardadolibreria.entities.Book;
import jpaguardadolibreria.entities.Editorial;
import jpaguardadolibreria.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author SAMUEL
 */
public class PersistenceController {
    AuthorJpaController authorJpa = new AuthorJpaController();
    BookJpaController bookJpa = new BookJpaController();
    EditorialJpaController editorialJpa = new EditorialJpaController();

    public void loadBook(Book b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void loadAuthor(Author a) {
        authorJpa.create(a);
    }
    
    public void deleteAuthorById(int id){
        try {
            authorJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editAuthor(Author author){
        try {
            authorJpa.edit(author);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadEditorial(Editorial e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Author getAuthorById(int id) {
        return authorJpa.findAuthor(id);
    }

    public ArrayList<Author> getAuthors() {
        return new ArrayList<Author> (authorJpa.findAuthorEntities());
    }
}
