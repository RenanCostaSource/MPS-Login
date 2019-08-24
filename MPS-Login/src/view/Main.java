
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
         UserControl usuarios = new UserControl();
         usuarios.addUser("login", "passewqsdef12");
         usuarios.addUser("logino", "pass12qweqwe");
         UserPersistence salvador = new UserPersistence();
         salvador.saveUsers(usuarios.listAll());
        salvador.loadUsers();
     }
}
