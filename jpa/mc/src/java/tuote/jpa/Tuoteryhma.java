package tuote.jpa;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Tuoteryhma implements Serializable {
        
    @Id @GeneratedValue
    private long id;
    
    @OneToMany(mappedBy = "ryhma")
    private List<Tuote> tuotteet;
    
    private String nimi;    

    public Tuoteryhma(String nimi) {
        this.nimi = nimi;
        tuotteet = new LinkedList<>();
    }

    public Tuoteryhma() {
    }   

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }  
}
