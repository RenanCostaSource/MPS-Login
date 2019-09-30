package view;

import infra.MoleculeDao;
import infra.MoleculeMemento;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Renan Costa
 */
public class MoleculeFacade {
    
    private MoleculeDao dao;
    private MoleculeMemento memento;

    public MoleculeFacade() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.dao = MoleculeDao.getInstance();
        memento.addMemento(dao.findAll());
    }
    
    
    
    
    
    
    
}
