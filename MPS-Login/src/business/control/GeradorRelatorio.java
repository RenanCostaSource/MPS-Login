package business.control;

import business.model.Molecule;
import infra.MoleculeDao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan Costa
 */
public abstract class GeradorRelatorio {
    protected List<Molecule> mols;
    
    public GeradorRelatorio() {
        
        System.out.println("funciona");
        try {
            mols = MoleculeDao.getInstance().findAll();
        } catch (IOException ex) {
            Logger.getLogger(GeradorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeradorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    abstract void GerarRelatorio(); 
}
