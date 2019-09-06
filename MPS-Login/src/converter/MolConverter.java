package converter;

import business.model.Molecule;

/**
 *
 * @author Renan Costa
 * 
 * classe necessita API, apenas para demonstração do padrão Adapter
 * 
 * Recebe o formato MOL(utilizado para representar uma molécula) e transforma em SMILES(tambem utilizado para representar uma molécula, mas aceito por mais APIs)
 */
public class MolConverter {
    
    public static Molecule Convert(String Mol,Molecule molecula){
       // molecula.setSmiles(API.molToSmiles(Mol)); //implementação seria assim com acesso à api
    return molecula;
        
        
    }
   
}
