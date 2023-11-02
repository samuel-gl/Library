/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaguardadolibreria;


import java.util.Scanner;
import jpaguardadolibreria.entities.Book;
import jpaguardadolibreria.services.AuthorService;
import jpaguardadolibreria.services.BookService;
import jpaguardadolibreria.services.EditorialService;

/**
 *
 * @author SAMUEL
 */
public class JpaGuardadoLibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        AuthorService as = new AuthorService();
        EditorialService es = new EditorialService();
        BookService bs = new BookService();
        
        
        bs.getBooks();
        es.getEditorials();
        as.getAuthors();


    }
    
}
