package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MessagePrive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMP;
    private String textMP;
    private Date dateMP;

    @ManyToOne
    private Personne emetteur;
    @ManyToOne
    private Personne destinataire;


    public MessagePrive(){}

    public MessagePrive(String text){
        // this.idMP = id;
        this.textMP = text;
    }



    /* GETTER SETTER */
    public int getIdMP() {
        return idMP;
    }

    public void setIdMP(int idMP) {
        this.idMP = idMP;
    }

    public String getTextMP() {
        return textMP;
    }

    public void setTextMP(String textMP) {
        this.textMP = textMP;
    }

    public Date getDateMP() {
        return dateMP;
    }

    public void setDateMP(Date dateMP) {
        this.dateMP = dateMP;
    }

    public Personne getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Personne emetteur) {
        this.emetteur = emetteur;
    }

    public Personne getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Personne destinataire) {
        this.destinataire = destinataire;
    }

}
