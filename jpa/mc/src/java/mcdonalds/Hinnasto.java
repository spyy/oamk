package mcdonalds;

import java.util.Collection;
import java.util.LinkedList;
import tuote.jpa.Tuoteryhma;

public class Hinnasto {
    private Collection<Tuoteryhma> tuoteryhmät;

    public Hinnasto() {
    }

    public Collection<Tuoteryhma> getTuoteryhmät() {
        return tuoteryhmät;
    }

    public void setTuoteryhmät(Collection<Tuoteryhma> tuoteryhmät) {
        this.tuoteryhmät = tuoteryhmät;
    }
    
    public void add(Tuoteryhma tr) {
        if (tuoteryhmät == null) {
            tuoteryhmät = new LinkedList<>();
        }
        tuoteryhmät.add(tr);
    }
}
