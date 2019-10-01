package infra;

import business.model.Molecule;
import business.model.User;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Renan
 */
public class UserMemento extends Memento<TreeMap<String,User>>{
    
    //private List<List<Molecule>> states;
    @Override
    public void addMemento(TreeMap<String,User> users){
        states.add(users);
    }
    
    @Override
    public TreeMap<String,User> loadLastMemento(){
        TreeMap<String,User> lastState= states.remove(states.size() - 1);
        UserPersistence.saveUsers(lastState);
        return lastState;
    }
    
}
