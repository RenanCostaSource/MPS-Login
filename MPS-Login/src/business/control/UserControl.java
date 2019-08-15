
package business.control;

import business.model.User;
import java.util.HashMap;

/**
 *
 * @author Renan Costa
 */
public class UserControl {
    
    private HashMap<String,User> users;

    public UserControl() {
        this.users = new HashMap<>();
    }
   /**
    * 
    *   Adiciona credenciais de novo usuário
    * 
    * @param  login //(max 12 caracteres, não vazio, sem números)
    * 
    * @param  pass  //(max 16 caracteres, min 8 caracteres, apenas letras e números, min 2 números)
    *
    */
    public void addUser(String login, String pass){
        
    }
    
    /**
     * @Método listAll
     * 
     * @return Lista de todos usuários cadastrados
     */
    public HashMap<String,User> listAll(){
        HashMap<String,User> users = this.users;
        
        return users;
    }
    
    /**
     * 
     * @param login
     * @return user //(objeto User com o login igual ao parâmetro)
     */
    public User list(String login){
        User user=users.get(login);
        
        return user;
    }
    
    /**
     * Deleta o usuário com o login igual ao parâmetro
     * @param login 
     */
    public void del(String login){
        users.remove(login);
    }
    
}
