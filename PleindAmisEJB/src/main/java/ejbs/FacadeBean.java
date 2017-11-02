package ejbs;

import entities.MessageMur;
import entities.MessagePrive;
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
    public Personne createPersonne(String l, String p, String n) {
        if(em.find(Personne.class, l) == null){
            return null;
        } else {
            Personne per = new Personne(l, p, n);
            em.persist(per);
            return per;
        }
    }

    @Override
    public Personne connectPersonne(String l, String p) {
        Personne courant = null;
        try {
            courant = (Personne) em
                    .createQuery("From Personne p where p.loginPers=?1 and p.passwdPers=?2")
                    .setParameter(1, l)
                    .setParameter(2, p)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return courant;
    }

    @Override
    public Personne getPersonne(String l) {
        return em.find(Personne.class, login);
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

    @Override
    public void ecrireMessage(String emet, String dest, String message, Boolean prive) {
        Personne user = getPersonne(emet);
        Personne p = getPersonne(dest);
        if(user != null && p != null) {
            if(prive){
                MessagePrive mp = new MessagePrive(message);
                em.persist(mp);
                user.getMpEnvoyes().add(mp);
                p.getMpRecus().add(mp);
            } else {
                MessageMur mm = new MessageMur(message);
                em.persist(mm);
                user.getMpEnvoyes().add(mm);
                p.getMpRecus().add(mm);
            }
        }
    }
}
