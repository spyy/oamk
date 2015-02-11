package tuotteet;


public class Tuoteryhmä {
    private String nimi;
    private long id;

    public Tuoteryhmä(String nimi) {
        this.nimi = nimi;
        this.id = 0;
    }

    public Tuoteryhmä() {
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
