/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaguardadolibreria.services;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaguardadolibreria.entities.Author;
import jpaguardadolibreria.entities.Book;
import jpaguardadolibreria.entities.Editorial;
import jpaguardadolibreria.persistencia.AuthorDAO;
import jpaguardadolibreria.persistencia.BookDAO;
import jpaguardadolibreria.persistencia.EditorialDAO;

/**
 *
 * @author SAMUEL
 */
public class BookService {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    EditorialService es = new EditorialService();
    AuthorService as = new AuthorService();
    BookDAO bookDAO = new BookDAO();
    
    public void setBookISBN(Book b) {
        long isbn;
        do {
            try {
                System.out.println("Ingrese el ISBN del libro");
                isbn = sc.nextLong();
                b.setIsbn(isbn);
                break;

            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Debe ingresar un ISBN valido");
            }
        } while (true);
    }    
    
    public void setBookTitle(Book b) {
        String title;
        do {
            try {
                System.out.println("Ingrese el titulo del libro");
                title = sc.next();
                b.setTitle(title);
                break;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Debe ingresar un titulo valido");
                sc.next();
            }
        } while (true);

    }
    
    public void setBookYear(Book b) {
        int year;
        do {
            try {
                System.out.println("Ingrese el año del libro");
                year = sc.nextInt();
                b.setYear(year);
                break;

            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Debe ingresar un año valido");
            }
        } while (true);
    }

    public void setBookTotal(Book b) {
        int total;
        do {
            try {
                System.out.println("Ingrese la cantidad de libros prestados");
                total = sc.nextInt();
                b.setTotalCopies(total);
                break;

            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Debe ingresar un numero valido");
            }
        } while (true);
    }
    
    public void setBookLent(Book b) {
        int lent;
        do {
            try {
                System.out.println("Ingrese la cantidad de libros prestados");
                lent = sc.nextInt();
                b.setLentCopies(lent);
                break;

            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Debe ingresar un numero valido");
            }
        } while (true);
    }

    public void setBookAvailable(Book b) {
        int available;
        do {
            try {
                System.out.println("Ingrese la cantidad de libros prestados");
                available = sc.nextInt();
                b.setAvailableCopies(available);
                break;

            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Debe ingresar un numero valido");
            }
        } while (true);
    }        

    public void setBookAuthor(Book b) {
        int authorID;
        AuthorDAO aDAO = new AuthorDAO();
        do {
            try {
                System.out.println("Ingrese el ID del autor");
                authorID = sc.nextInt();
                Author author = aDAO.getAuthorById(authorID);
                if(author!=null){
                    b.setAuthor(author);
                    break;
                } else{
                    throw new Exception("El ID del autor no es valido");
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Debe ingresar un autor valido");
            }
        } while (true);
    }    

    public void setBookEditorial(Book b) {
        int editorialID;
        EditorialDAO eDAO = new EditorialDAO();
        do {
            try {
                System.out.println("Ingrese el ID de la editorial");
                editorialID = sc.nextInt();
                Editorial editorial = eDAO.getEditorialById(editorialID);
                if(editorial!=null){
                    b.setEditorial(editorial);
                    break;
                } else{
                    throw new Exception("El ID de la editorial no es valido");
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                System.out.println("Debe ingresar una editorial valido");
            }
        } while (true);
    }
    
    public void createBook(){
        Book b = new Book();
        
        setBookISBN(b);
        setBookTitle(b);
        setBookTotal(b);
        setBookYear(b);
        setBookLent(b);
        setBookAvailable(b);
        setBookAuthor(b);
        setBookEditorial(b);
            
        bookDAO.save(b);
    }

    public Book getBookByISBN() {
        do {
            try {
                System.out.println("Ingrese el ISBN del libro que desea seleccionar");
                Long isbn = sc.nextLong();
                Book b = bookDAO.getBookById(isbn);
                if (b == null) {
                    throw new Exception("El ISBN no esta asociado a ningun libro");
                } else {
                    return b;
                    
                }  
            } catch (Exception ex){
                System.out.println(ex);
                System.out.println(ex.getMessage());
                System.out.println("Debe ingresar un ISBN valido");
                sc.next();
            }
        } while (true);
    }
    
    public void getBooks() throws Exception{
        
        List<Book> books = bookDAO.getBooks();
        
        for(Book b : books){
            System.out.println(b);
        }
       
    }
    
                
    public void editBook() {

        try {
            Book b = getBookByISBN();
            setBookTitle(b);
            setBookTotal(b);
            setBookYear(b);
            setBookLent(b);
            setBookAvailable(b);
            setBookAuthor(b);
            setBookEditorial(b);
            bookDAO.edit(b);
        } catch (Exception e) {

        }

    }

}
