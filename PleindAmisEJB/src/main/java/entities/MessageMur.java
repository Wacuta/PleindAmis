package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class MessageMur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMM;
    private String textMM;
    private Date dateMM;

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Personne> aime;

    @ManyToOne
    private Personne emetteur;
    @ManyToOne
    private Personne destinataire;
    // private static int idMessage = 0;

    public MessageMur(){}

    public MessageMur(String text, Personne em, Personne res) {
        this.textMM = text;
        this.emetteur = em;
        this.destinataire = res;
    }



    /* GETTER SETTER */
    public int getIdMM() {
        return idMM;
    }

    public void setIdMM(int idMM) {
        this.idMM = idMM;
    }

    public String getTextMM() {
        return textMM;
    }

    public void setTextMM(String textMM) {
        this.textMM = textMM;
    }

    public Date getDateMM() {
        return dateMM;
    }

    public void setDateMM(Date dateMM) {
        this.dateMM = dateMM;
    }

    public List<Personne> getAime() {
        return aime;
    }

    public void setAime(List<Personne> aime) {
        this.aime = aime;
    }

    public Personne getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Personne destinataire) {
        this.destinataire = destinataire;
    }

    public Personne getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Personne emetteur) {
        this.emetteur = emetteur;
    }

}
