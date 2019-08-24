
package view;

import business.control.UserControl;
import exceptions.userSignInException;
import infra.UserPersistence;
import java.io.IOException;



/**
 *
 * @author Renan Costa
 */
public class Main {
     public static void main(String[] args) throws userSignInException, IOException, ClassNotFoundException {
         UserPersistence salvador = new UserPersistence();
         UserControl usuarios = new UserControl();
        usuarios.addUser("betanisa", "pass12qweqwe");
         usuarios.addUser("alfred", "passewqsdef12");
         
         
         salvador.saveUsers(usuarios.listAll());
        salvador.loadUsers();
        
        
     }
}
