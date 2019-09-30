package infra;

import business.model.Molecule;
import java.util.List;

/**
 *
 * @author Renan
 */
public abstract class Dao<T> {
    
    public abstract T find(int i);
    
    public abstract List<T> findAll();
     
    public abstract int create(T t);
    
    public abstract void delete(int id);
    
    public abstract void edit(int i,T t);
     
     
    
}
