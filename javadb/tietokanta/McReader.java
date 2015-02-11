package tietokanta;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class McReader {
        
        
    public static void lueHinnasto(Main callback) throws SQLException {
        try 
            (ZipFile zf = new ZipFile("mcdonaldsprices.zip")) 
        {
            Enumeration<? extends ZipEntry> zes = zf.entries();
            while (zes.hasMoreElements()) {
                ZipEntry ze = zes.nextElement();
                System.out.println(ze.getName());
            }
            McReader.lueHinnasto(callback, zf.getInputStream(zf.getEntry("mcdonaldsprices.txt")));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    private static void lueHinnasto(Main callback, InputStream is) throws SQLException {
        Scanner s = new Scanner(is);
        
        long ryhmä = 0;
        
        while (s.hasNextLine()) {
            String line = s.nextLine();            
            String[] kentät = line.split("\t");
            switch (kentät.length) {
                case 1:
                    callback.lisääTuoteryhmä(kentät);
                    break;
                case 3:
                    callback.lisääTuote(kentät);
                    break;
                default:
                    throw new RuntimeException("Error 12N345");
            }
        }
    }
    
}
