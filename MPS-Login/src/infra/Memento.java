package infra;

import business.model.Molecule;
import java.util.List;

/**
 *
 * @author Renan
 */
public abstract class Memento<T> {
    
    
   protected List<T> states;
    
    public abstract void addMemento(T state);
    
    
    public abstract T loadLastMemento();
    
}
