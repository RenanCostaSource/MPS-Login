
package view;

import business.control.MoleculeControl;
import business.control.UserControl;
import business.model.Molecule;
import exceptions.userSignInException;
import infra.MoleculeDao;
import infra.UserPersistence;
import java.io.IOException;



/**
 *
 * @author Renan Costa
 */
public class Main {
     public static void main(String[] args) throws userSignInException, IOException, ClassNotFoundException {
         //UserPersistence salvador = new UserPersistence();
       //  UserControl usuarios = new UserControl();
       // usuarios.addUser("betanisa", "pass12qweqwe");
       //  usuarios.addUser("alfred", "passewqsdef12");
         
       Molecule mol=new Molecule();
       mol.setNome("apaga");
       
       MoleculeDao dao = new MoleculeDao(1);
       dao.create(mol);
       dao.delete(0);
        // salvador.saveUsers(usuarios.listAll());
       // salvador.loadUsers();
        
        
     }
}
