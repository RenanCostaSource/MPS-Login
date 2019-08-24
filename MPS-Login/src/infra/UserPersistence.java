package infra;
import business.model.User;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import sun.misc.IOUtils;
/**
 *
 * @author Renan Costa
 */
public class UserPersistence {
    private File arquivo = new File ("login.txt");
    
    /**
     * resgata usuários de arquivo 
     * @return users  
     */
    public HashMap<String,User> loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException{
        HashMap<String,User> users = new HashMap<String,User>();
        FileInputStream input = new FileInputStream(arquivo);
        ObjectInputStream objectinput = new ObjectInputStream(input);
        User usuario=new User();
        boolean i=true;
        while(i){
           usuario = (User) objectinput.readObject();
                     if(usuario.getLogin().equals("F1n4l!@#$%")){//Checa eof
               i=false;
           }else{
                         
           users.put(usuario.getLogin(),usuario);
           }
        }
          
            
            
            input.close();
            objectinput.close();
        return users;
    }
    
    /**
     * Salva usuários no arquivo
     * @param users 
     */
    public void saveUsers(HashMap<String,User> users){
        int i;
    
    
    int n = users.size();
    try{            
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(Map.Entry<String, User> entry : users.entrySet()) {
    String key = entry.getKey();
    User value = entry.getValue();

    // do what you have to do here
    // In your case, another loop.

        // escreve todos os produtos do registro no arquivo
            System.out.println("gravando: " +value.getLogin()+" "+value.getPass());
           oos.writeObject (value);           
        
}       
        User endFile = new User();
        endFile.setLogin("F1n4l!@#$%");//usuario para indicar fim do arquivo
        oos.writeObject (endFile);  
        // fecha o arquivo
        oos.close();
        fos.close();            
    }
    catch(IOException e)
    {
        System.err.println(e.getMessage());
    }
}    
    }

