package palaute;


import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.*;


@RequestScoped
@Named
public class RequestBean {
    private String otsikko = "otsikko";
    private String kuvaus = "kuvaus";
      
    @Inject
    private SingletonBean singleton;
    
    public void uusi() {
        Palaute palaute = new Palaute();
        
        palaute.setKuvaus(this.kuvaus);
        palaute.setOtsikko(this.otsikko);
        
        this.singleton.insertEntity(palaute);
        
        this.otsikko = "otsikko";
        this.kuvaus = "kuvaus";
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public String getOtsikko() {
        return this.otsikko;
    }

    public String getKuvaus() {
        return this.kuvaus;
    }
    
    @Produces @Named("palautelista")
    public List<Palaute> palautteet() {
        return this.singleton.getEntities();
    }
    
}
