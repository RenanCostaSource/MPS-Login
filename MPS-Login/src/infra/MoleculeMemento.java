package infra;

import business.model.Molecule;
import java.util.List;

/**
 *
 * @author Renan
 */
public class MoleculeMemento {
    
    private List<List<Molecule>> states;
    
    public void addMemento(List<Molecule> mols){
        states.add(mols);
    }
    
    
    public List<Molecule> loadLastMemento(){
        return states.remove(states.size() - 1);
    }
    
}
