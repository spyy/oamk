package palaute;

import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Singleton
public class SingletonBean {
    
    @PersistenceContext
    EntityManager em;
    
    public void insertEntity(Palaute palaute) {
        this.em.persist(palaute);
    }
    
    public List getEntities() {
        Query query = this.em.createQuery("SELECT p FROM Palaute p");
        return query.getResultList();
    }
    
}
