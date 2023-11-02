/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.Scanner;
import jpaguardadolibreria.entities.Author;
import jpaguardadolibreria.entities.Book;
import jpaguardadolibreria.entities.Editorial;
import Controller.PersistenceController;

/**
 *
 * @author SAMUEL
 */
public class ServiceController {
    PersistenceController pc = new PersistenceController();
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public void loadBook(Book b){
        
        pc.loadBook(b);
    }
    
    public void loadAuthor(){
        
        Author a = new Author();
        try {
            System.out.println("Ingrese el nombre del autor");
            a.setName(sc.next());
            if (a.getName().equals("")) {
                throw new Exception("debe ingresar el nombre del autor");
            }
            pc.loadAuthor(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }
    
    public void editAuthor(Author author){
        pc.editAuthor(author);
    }
    
    public void editAuthorById(int id){
        Author author = getAuthorById(id);
        System.out.println("Ingrese el nuevo nombre para el autor");
        try {
            String name = sc.next();
            if (!name.equals("")){
                author.setName(name);
                editAuthor(author);
            }
        } catch (Exception e) {
        }
    }
    
    public void deleteAuthorById(int id){
        pc.deleteAuthorById(id);
    }
    
    public Author getAuthorById(int id){
        return pc.getAuthorById(id);
    }
    
    public ArrayList<Author> getAuthors(){
        pc.getAuthors();
        return pc.getAuthors();
    }
    
    public void loadEditorial(Editorial e){
        
        pc.loadEditorial(e);
    }
    
}
