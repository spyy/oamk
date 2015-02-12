package mcdonalds;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;
import tuote.jpa.Tuote;
import tuote.jpa.Tuoteryhma;

@Named
@Stateless
public class HinnastonLuoja {
    private Part tiedosto;
    //private Hinnasto hinnasto;
    private Tuoteryhma viimeisinTuoteryhmä;
    
    @PersistenceContext
    EntityManager em;
    
    public Part getTiedosto() {
        return tiedosto;
    }

    public void setTiedosto(Part tiedosto) {
        this.tiedosto = tiedosto;
    }
    
    public String vie() throws IOException {
        ZipInputStream zs = new ZipInputStream(tiedosto.getInputStream());
        ZipEntry ze =zs.getNextEntry();        
        while (ze != null) {
            if (ze.getName().equals("mcdonaldsprices.txt")) {
                lueHinnasto(zs);
            }
            ze = zs.getNextEntry();
        }
        return null;
    }

    private void lueHinnasto(InputStream is) {
        Scanner s = new Scanner(is);
                
        while (s.hasNextLine()) {
            String[] kentät = s.nextLine().split("\t");
            switch (kentät.length) {
                case 1:
                    lisääTuoteryhmä(kentät);
                    break;
                case 3:
                    lisääTuote(kentät);
                    break;
                default:
                    throw new RuntimeException("Error 12N345");
            }
        }
    }

    private void lisääTuoteryhmä(String[] kentät) {
        viimeisinTuoteryhmä = new Tuoteryhma(kentät[0]);
        this.em.persist(viimeisinTuoteryhmä);
    }

    private void lisääTuote(String[] kentät) {
        if (viimeisinTuoteryhmä == null) {
            throw new RuntimeException("Error A2-323-x");
        }
        Tuote tuote = new Tuote(kentät[0], kentät[1], kentät[2], this.viimeisinTuoteryhmä);
        this.em.persist(tuote);
    }
}
