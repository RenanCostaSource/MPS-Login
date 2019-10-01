package infra;

import business.model.Molecule;
import java.util.List;

/**
 *
 * @author Renan
 */
public class MoleculeMemento extends Memento<List<Molecule>>{
    
    //private List<List<Molecule>> states;
    @Override
    public void addMemento(List<Molecule> mols){
        states.add(mols);
    }
    
    @Override
    public List<Molecule> loadLastMemento(){
        return states.remove(states.size() - 1);
    }
    
}
