package infra;

import business.model.Molecule;
import business.model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan Costa
 * 
 * factory pattern: create product object(Molecule)
 * utiliza tambem Singleton pattern
 */
public class MoleculeDao extends Dao<Molecule>{
    private static MoleculeDao instancia;
    private final File arquivo = new File ("molecules.dat");
    private List<Molecule> mols;
    
    //apenas a classe pode chamar o construtor
    private MoleculeDao() throws FileNotFoundException, IOException, ClassNotFoundException{
         FileInputStream input = new FileInputStream(arquivo);
        ObjectInputStream objectinput = new ObjectInputStream(input);
        mols= new ArrayList<Molecule>();
        Molecule mol;
        boolean i=true;
        while(i){
        
           mol = (Molecule) objectinput.readObject();
                     if(mol.getNome().equals("F1n4l!@#$%")){//Checa eof
               i=false;
           }else{
                         System.out.println(mol.getNome());
           mols.add(mol);
           }
        }  
            input.close();
            objectinput.close();
    }
    public MoleculeDao(int i){
        mols= new ArrayList<Molecule>();
    }
    
    
    //Instanciar com esse método para ser realmente um singleton
    public static synchronized MoleculeDao getInstance() throws IOException, FileNotFoundException, ClassNotFoundException{
        if (instancia==null){
            instancia= new MoleculeDao();
        }
        return instancia;
    }
  
    @Override
    public Molecule find(int id){
        Molecule mol;
        for(Molecule m:mols){
            if(id==m.getId()){
                mol=m;
                return mol;
            }
        }
        return null;
    }
    
    @Override
    public List<Molecule> findAll(){
        return mols;
    }
    
    @Override
    public int create(Molecule mol){
        Molecule ultima=mols.get(mols.size()-2);
       mol.setId(ultima.getId()+1);
        mols.add(mol);
        toFile();
        return mol.getId();
    }
    @Override
     public void delete(int id){
        for(Molecule m:mols){
            if(id==m.getId()){
                mols.remove(m);
                toFile();
                
            }
        }
    }
       @Override
      public void edit(int id,Molecule mol){
        Molecule orig= find(id);
        mols.set(mols.indexOf(orig), mol);
          toFile();
        
    }
      
      public void restoreState(List<Molecule> molecules){
          mols=molecules;
          toFile();
      }
      
    
      private void toFile(){//mantem arquivo atualizado apos cada operação, não o ideal para sistemas concorrentes
                 int i;  
    int n = mols.size();
    try{            
        FileOutputStream fos = new FileOutputStream(arquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(Molecule m : mols) {
    
           oos.writeObject (m);           
        
}       
        Molecule endFile = new Molecule();
        endFile.setNome("F1n4l!@#$%");//usuario para indicar fim do arquivo
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
