package business.control;
import business.model.Molecule;

/**
 *
 * @author Renan
 */
public abstract class MoleculeInterpreter {
    
    public Molecule interpreterMolecule(String molString){
      Molecule mol =new Molecule();
      
      String[] splitString = molString.split("\\s+");
      mol.setNome(splitString[0]);
      mol.setSmiles(splitString[1]);
     
      return mol;
    }
    
}
