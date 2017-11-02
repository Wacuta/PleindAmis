package ejbs;

import entities.Personne;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Maxime Guyot on 28/09/2017.
 */
@Local
public interface Facade {
    public Personne createPersonne(String l, String p, String n);
    public Personne connectPersonne(String l, String p);
    public Personne getPersonne(String l);
    public List<Personne> getAllInscrits();
    public List<Personne> getAmis(String l);
    public List<Personne> getNonAmis(String l);

    public void ecrireMessage(String user, String ami, String message, Boolean prive);
}
