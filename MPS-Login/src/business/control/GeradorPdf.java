package business.control;

import business.model.Molecule;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan Costa
 */
public class GeradorPdf extends GeradorRelatorio{
    
    
    
    @Override
    public void GerarRelatorio(){
        Document document = new Document();
        try {
            
            PdfWriter.getInstance(document, new FileOutputStream("Relatorio.pdf"));
            
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(GeradorPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

for(Molecule m:mols){
   Chunk chunk = new Chunk(m.getId()+"\n"+m.getNome()+"\n"+m.getSmiles(), font);
            try {
                document.add(chunk);
            } catch (DocumentException ex) {
                Logger.getLogger(GeradorPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
}
document.close();

    }
}
