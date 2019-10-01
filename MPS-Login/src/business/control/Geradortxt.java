package business.control;

import business.model.Molecule;
import infra.MoleculeDao;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan Costa
 */
public abstract class Geradortxt extends GeradorRelatorio{
    protected List<Molecule> mols;
    
    public Geradortxt() {
        
     
        try {
            mols = MoleculeDao.getInstance().findAll();
        } catch (IOException ex) {
            Logger.getLogger(Geradortxt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Geradortxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   @Override
    public void GerarRelatorio() throws IOException{
        FileWriter arq = new FileWriter("relatorio.txt");
        PrintWriter writeArq = new PrintWriter(arq);
        
        for(Molecule m:mols){
            writeArq.println(m.getId()+" -- "+m.getNome()+" -- "+ m.getSmiles()+" -- ");                   
        }
        arq.close();
    }
}
