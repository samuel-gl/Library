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
import jpaguardadolibreria.persistencia.AuthorDAO;

/**
 *
 * @author SAMUEL
 */
public class AuthorService {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    AuthorDAO authorDAO = new AuthorDAO();
    
    public void createAuthor(){
        Author a = new Author();
        String name;
        do {
            System.out.println("Ingrese el nombre del autor");
            name = sc.next();
            if(name.equals("")){
                System.out.println("El autor debe tener un nombre");
            } else{
                a.setName(name);
            }
        } while (name.equals(""));
            
        authorDAO.save(a);
    }
    
    public void editAuthor(int id) throws Exception {

        try {
            Author author = authorDAO.getAuthorById(id);
            if (author != null) {
                System.out.println("Ingrese el nuevo nombre del autor");
                String newName = sc.next();
                if (!newName.equals("")) {
                    author.setName(newName);
                } else {
                    throw new Exception("El autor debe tener un nombre");
                }
                authorDAO.edit(author);
            } else {
                throw new Exception("El id ingresado no esta asociado a ningun autor");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    
    public void deleteAuthor(int id){
        try {
            Author author = authorDAO.getAuthorById(id);
            if (author != null) {
                authorDAO.delete(author);
            } else {
                throw new Exception("El id ingresado no esta asociado a ningun autor");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    
    public void getAuthors(){
        try {
            List<Author> authors = authorDAO.getAuthors();
            authors.forEach((au) -> {
                System.out.println(au);
            });
        } catch (Exception ex) {
            Logger.getLogger(AuthorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getAuthorByName(String name){
        try {
            Author a = authorDAO.getAuthorByName(name);
            if (a!=null){
                System.out.println(a);
            }else{
                throw new Exception("No existe ningun autor con el nombre ingresado");
            }
        } catch (Exception ex) {
            System.out.println("Hubo un error al recuperar el autor");
            Logger.getLogger(AuthorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void getAuthorById(int id){
        try {
            Author a = authorDAO.getAuthorById(id);
            if (a!=null){
                System.out.println(a);
            }else{
                throw new Exception("No existe ningun autor con el ID ingresado");
            }
        } catch (Exception ex) {
            Logger.getLogger(AuthorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
