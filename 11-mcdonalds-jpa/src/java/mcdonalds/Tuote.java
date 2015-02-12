package mcdonalds;

import java.io.Serializable;
import java.math.BigDecimal;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tuote implements Serializable {
    @Id @GeneratedValue
    private long tuoteId;
    
    private String nimi;
    private String annoskoko;
    @Column(precision=10,scale=2)
    private BigDecimal hinta;
    
    @ManyToOne(cascade=ALL,fetch=EAGER)
    private Tuoteryhmä tuoteryhmä;

    public Tuote(String nimi, 
            String annoskoko, 
            BigDecimal hinta,
            Tuoteryhmä tuoteryhmä) {
        this.nimi = nimi;
        this.annoskoko = annoskoko;
        this.hinta = hinta;
        this.tuoteryhmä = tuoteryhmä;
    }

    public Tuote() {
    }

    public long getTuoteId() {
        return tuoteId;
    }

    public void setTuoteId(long tuoteId) {
        this.tuoteId = tuoteId;
    }

    public Tuoteryhmä getTuoteryhmä() {
        return tuoteryhmä;
    }

    public void setTuoteryhmä(Tuoteryhmä tuoteryhmä) {
        this.tuoteryhmä = tuoteryhmä;
    }

    
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getAnnoskoko() {
        return annoskoko;
    }

    public void setAnnoskoko(String annoskoko) {
        this.annoskoko = annoskoko;
    }

    public BigDecimal getHinta() {
        return hinta;
    }

    public void setHinta(BigDecimal hinta) {
        this.hinta = hinta;
    }
    
    
}
