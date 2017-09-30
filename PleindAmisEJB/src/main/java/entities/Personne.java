package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Personne {

    @Id
    private String loginPers;
    private String passwdPers;
    private String nomPers;
    private Date lastLogin;

    @OneToMany(mappedBy = "emetteur", cascade = CascadeType.ALL)
    private List<MessagePrive> mpEnvoyes;
    @OneToMany(mappedBy = "destinataire")
    private List<MessagePrive> mpRecus;

    @ManyToMany
    private List<Personne> amis;
    @ManyToMany
    public List<MessageMur> aiment;

    @OneToMany(mappedBy = "emetteur", cascade = CascadeType.ALL)
    private List<MessageMur> mmEnvoyes;
    @OneToMany(mappedBy = "destinataire")
    private List<MessageMur> mmRecus;


    public Personne(){}

    public Personne(String log, String pass, String nom) {
        this.loginPers = log;
        this.passwdPers = pass;
        this.nomPers = nom;

        this.mpRecus = new ArrayList<MessagePrive>();
        this.mpEnvoyes = new ArrayList<MessagePrive>();
        this.mmRecus = new ArrayList<MessageMur>();
        this.mmEnvoyes = new ArrayList<MessageMur>();

        this.amis = new ArrayList<Personne>();

        this.aiment = new ArrayList<MessageMur>();


    }





    /* GETTER SETTER */
    public String getLoginPers() {
        return loginPers;
    }

    public void setLoginPers(String loginPers) {
        this.loginPers = loginPers;
    }

    public String getPasswdPers() {
        return passwdPers;
    }

    public void setPasswdPers(String passwdPers) {
        this.passwdPers = passwdPers;
    }

    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<MessagePrive> getMpRecus() {
        return mpRecus;
    }

    public void setMpRecus(List<MessagePrive> mpRecus) {
        this.mpRecus = mpRecus;
    }

    public List<MessagePrive> getMpEnvoyes() {
        return mpEnvoyes;
    }

    public void setMpEnvoyes(List<MessagePrive> mpEnvoyes) {
        this.mpEnvoyes = mpEnvoyes;
    }

    public List<Personne> getAmis() {
        return amis;
    }

    public void setAmis(List<Personne> amis) {
        this.amis = amis;
    }

    public List<MessageMur> getAiment() {
        return aiment;
    }

    public void setAiment(List<MessageMur> aiment) {
        this.aiment = aiment;
    }

    public List<MessageMur> getMmEnvoyes() {
        return mmEnvoyes;
    }

    public void setMmEnvoyes(List<MessageMur> mmEnvoyes) {
        this.mmEnvoyes = mmEnvoyes;
    }

    public List<MessageMur> getMmRecus() {
        return mmRecus;
    }

    public void setMmRecus(List<MessageMur> mmRecus) {
        this.mmRecus = mmRecus;
    }

}
