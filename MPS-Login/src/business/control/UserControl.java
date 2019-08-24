
package business.control;

import business.model.User;
import exceptions.userSignInException;
import java.util.TreeMap;

/**
 *
 * @author Renan Costa
 */
public class UserControl {
    
    private TreeMap<String,User> users;

    public UserControl(TreeMap usuarios) {
        this.users = usuarios;
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
    public User addUser(String login, String pass) throws userSignInException{
        User usuario=new User();
        if(login.length() <=12){
            if(login.replaceAll("\\D", "").length()==0){//remove todos caracteres que não forem digitos
                
            }else{
            throw new userSignInException("Login name cannot have digits");
            }
        }else{
            throw new userSignInException("Login name exceeds 12 caracters");
        }
        
        if(pass.length() <=16){
            
            if(pass.length() >=8){
            
                 if(pass.replaceAll("\\D", "").length()>=2){//remove todos caracteres que não forem digitos
                usuario.setLogin(login);
                usuario.setPass(pass);
                users.put(login, usuario);
                return usuario;
                }else{
                    throw new userSignInException("Password must contain at least two digits");
                }
                
            }else{
                throw new userSignInException("Password must be at least 8 caracters");
            }
            
        }else{
            throw new userSignInException("Password exceeds 16 caracters");
        }
        
    }
    
    /**
     * @Método listAll
     * 
     * @return Lista de todos usuários cadastrados
     */
    public TreeMap<String,User> listAll(){
        TreeMap<String,User> users = this.users;
        
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
