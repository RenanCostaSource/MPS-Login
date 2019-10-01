package view;

import business.control.UserControl;
import business.model.Molecule;
import business.model.User;
import exceptions.userSignInException;
import infra.MoleculeDao;
import infra.MoleculeMemento;
import infra.UserMemento;
import infra.UserPersistence;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Renan Costa
 */
public class SystemFacade {
    
    private MoleculeDao dao;
    private MoleculeMemento moleculeMemento;
    private UserMemento userMemento;
    private TreeMap<String,User> usuarios;
    private UserControl users;
    public SystemFacade() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.dao = MoleculeDao.getInstance();
        moleculeMemento.addMemento(dao.findAll());
        
        usuarios = UserPersistence.loadUsers();
        users= new UserControl(usuarios);
        userMemento.addMemento(usuarios);       
    }
    
    //----------------------Molecule Facade----------------------------
    public int createMolecule(Molecule mol){
        int id = dao.create(mol);
        moleculeMemento.addMemento(dao.findAll());
        return id;
    }
    
    public void deleteMolecule(int id){
        dao.delete(id);
        moleculeMemento.addMemento(dao.findAll());
    }
    
    public void editMolecule(int id, Molecule mol){
        dao.edit(id, mol);
         moleculeMemento.addMemento(dao.findAll());
    }
    
    public Molecule getMolecule(int id){
        return dao.find(id);
    }
    public List<Molecule> getAllMolecules(){
        return dao.findAll();
    }
    
    public void redoMolecule(){
    dao.restoreState(moleculeMemento.loadLastMemento());
    
    }
    //-----------------------------------------------------------
    
    
    
    //---------------------User Facade---------------------------
    private void saveUserandMemento(){
        TreeMap<String,User> allUsers = users.listAll();
        userMemento.addMemento(allUsers);
        UserPersistence.saveUsers(allUsers);
    }
    
    public User createUser(String login,String pass) throws userSignInException{
        User novoUsuario = users.addUser(login, pass);
        saveUserandMemento();
        return novoUsuario;
    }
    
    public void deleteUser(String login){
        users.del(login);
        saveUserandMemento();
    }
    
    public void editUser(String login,String pass) throws userSignInException{
        users.del(login);
        User novoUsuario = users.addUser(login, pass);
        saveUserandMemento();
    }
    
    public User getUser(String login){
        return users.list(login);
    }
    
    public TreeMap<String,User> getAllUsers(){
        return users.listAll();
    }
    
    public void redoUser(){
        TreeMap<String,User> lastState = userMemento.loadLastMemento();
        users.restoreState(lastState);
        UserPersistence.saveUsers(lastState);
    }
}
