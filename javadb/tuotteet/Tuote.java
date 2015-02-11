package tuotteet;

import java.math.BigDecimal;

public class Tuote {
    private String nimi;
    private String koko;
    private BigDecimal hinta;
    private long ryhmä;   
    private long id;

    public Tuote(String nimi, String koko, BigDecimal hinta) {
        this.nimi = nimi;
        this.koko = koko;
        this.hinta = hinta;
        this.id = 0;
        this.ryhmä = 0;
    }

    public Tuote() {
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public BigDecimal getHinta() {
        return hinta;
    }

    public void setHinta(BigDecimal hinta) {
        this.hinta = hinta;
    }
    
    public long getRyhmä() {
        return ryhmä;
    }

    public void setRyhmä(long ryhmä) {
        this.ryhmä = ryhmä;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
        
}
