package infra;
import business.model.User;
import java.io.*;
import java.util.HashMap;
/**
 *
 * @author Renan Costa
 */
public class UserPersistence {
    private File arquivo;
    
    /**
     * resgata usuários de arquivo 
     * @return users  
     */
    public HashMap<String,User> loadUsers(){
        HashMap<String,User> users = new HashMap<String,User>();
        return users;
    }
    
    /**
     * Salva usuários no arquivo
     * @param users 
     */
    public void saveUsers(HashMap<String,User> users){
        
    }
}
