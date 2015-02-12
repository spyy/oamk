package mcdonalds;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
    {
        @NamedQuery(
            name="Tuoteryhmä.haeKaikki",
            query="select tr from Tuoteryhmä tr"
        )
    }
)
public class Tuoteryhmä implements Serializable {
    @Id @GeneratedValue
    private long tuoteryhmäId;
    private String nimi;

    public long getTuoteryhmäId() {
        return tuoteryhmäId;
    }
    
    @OneToMany(cascade=ALL,fetch=EAGER)
    private List<Tuote> tuotteet;
    
    public Tuoteryhmä(String nimi) {
        this.nimi = nimi;
    }

    public Tuoteryhmä() {
    }

    public List<Tuote> getTuotteet() {
        for (Tuote t: tuotteet) {
            t.getNimi();
        }
        return tuotteet;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public void add(Tuote t) {
        tuotteet.add(t);
    }
}
