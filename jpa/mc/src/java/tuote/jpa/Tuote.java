package tuote.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tuote implements Serializable {
    
    @Id @GeneratedValue
    private long id;
        
    @ManyToOne
    private Tuoteryhma ryhma;
    
    private String nimi;
    private String koko;
    private String hinta;
                

    public Tuote(String nimi, String koko, String hinta, Tuoteryhma ryhma) {
        this.nimi = nimi;
        this.koko = koko;
        this.hinta = hinta;
        this.ryhma = ryhma;
    }

    public Tuote() {
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }        
      
    public String getKoko() {
        return koko;
    }

    public void setKoko(String koko) {
        this.koko = koko;
    }

    public String getHinta() {
        return hinta;
    }

    public void setHinta(String hinta) {
        this.hinta = hinta;
    }
}
