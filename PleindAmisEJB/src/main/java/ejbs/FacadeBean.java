package ejbs;

import entities.Personne;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Maxime Guyot on 28/09/2017.
 */
@Stateless(name = "FacadeEJB")
public class FacadeBean implements Facade{
    @PersistenceContext(unitName = "monUnite")
    EntityManager em;

    public FacadeBean() {
    }

    @Override
    public String createPersonne(String l, String p, String n) {
        if(em.find(Personne.class, l) == null){
            return null;
        } else {
            Personne per = new Personne(l, p, n);
            em.persist(per);
            return per.getLoginPers();
        }
    }

    @Override
    public Personne connectPersonne(String l, String p) {
        Personne courant = null;
        try {
            courant = (Personne) em
                    .createQuery("From Personne p where loginPers=?1 and passPers=?2")
                    .setParameter(1, l)
                    .setParameter(2, p)
                    .getSingleResult();
        } catch (Exception e) {
        }
        return courant;
    }

    @Override
    public Personne getPersonne(String l) {
        return null;
    }

    @Override
    public List<Personne> getAllInscrits() {
        return null;
    }

    @Override
    public List<Personne> getAmis(String l) {
        return null;
    }

    @Override
    public List<Personne> getNonAmis(String l) {
        return null;
    }
}
