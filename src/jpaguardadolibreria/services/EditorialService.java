package jpaguardadolibreria.services;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaguardadolibreria.entities.Editorial;
import jpaguardadolibreria.persistencia.EditorialDAO;

/**
 *
 * @author SAMUEL
 */
public class EditorialService {
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    EditorialDAO editorialDAO = new EditorialDAO();
    
    public void createEditorial(){
        Editorial e = new Editorial();
        String name;
        do {
            System.out.println("Ingrese el nombre de la editorial");
            name = sc.next();
            if(name.equals("")){
                System.out.println("La editorial debe tener un nombre");
            } else{
                e.setName(name);
            }
        } while (name.equals(""));
            
        editorialDAO.save(e);
    }
    
    public void editEditorial(int id) throws Exception {

        try {
            Editorial editorial = editorialDAO.getEditorialById(id);
            if (editorial != null) {
                System.out.println("Ingrese el nuevo nombre de la editorial");
                String newName = sc.next();
                if (!newName.equals("")) {
                    editorial.setName(newName);
                } else {
                    throw new Exception("La editorial debe tener un nombre");
                }
                editorialDAO.edit(editorial);
            } else {
                throw new Exception("El id ingresado no esta asociado a ninguna editorial");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    
    public void deleteEditorial(int id){
        try {
            Editorial editorial = editorialDAO.getEditorialById(id);
            if (editorial != null) {
                editorialDAO.delete(editorial);
            } else {
                throw new Exception("El id ingresado no esta asociado a ningun autor");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    
    public void getEditorials(){
        try {
            List<Editorial> editorials = editorialDAO.getEditorials();
            editorials.forEach((e) -> {
                System.out.println(e);
            });
        } catch (Exception ex) {
            Logger.getLogger(AuthorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getEditorialByName(String name){
        try {
            Editorial e = editorialDAO.getEditorialByName(name);
            if (e!=null){
                System.out.println(e);
            }else{
                throw new Exception("No existe ninguna editorial con el nombre ingresado");
            }
        } catch (Exception ex) {
            System.out.println("Hubo un error al recuperar la editorial");
            Logger.getLogger(AuthorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void getEditorialById(int id){
        try {
            Editorial e = editorialDAO.getEditorialById(id);
            if (e!=null){
                System.out.println(e);
            }else{
                throw new Exception("No existe ninguna editorial con el ID ingresado");
            }
        } catch (Exception ex) {
            Logger.getLogger(AuthorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}