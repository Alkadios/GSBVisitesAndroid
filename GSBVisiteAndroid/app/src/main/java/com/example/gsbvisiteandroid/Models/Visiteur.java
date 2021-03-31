package com.example.gsbvisiteandroid.Models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Visiteur implements Serializable {
    private int id;
    private String username;
    private String nom;
    private String prenom;
    private String tel;
    private String mail;
    private String matricule;
    private String dateEmbauche;

    public List<Visite> getVisites() {
        return visites;
    }

    private List<Visite> visites;

    public Visiteur(int id, String username, String nom, String prenom, String tel, String mail, String matricule, String dateEmbauche) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
    }


    public String getUsername() {
        return username;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public int getId() {
        return id;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public String getMatricule() {
        return matricule;
    }

    @Override
    public String toString()
    {
        return nom  + " " + prenom;
    }
}
