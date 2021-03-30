package com.example.gsbvisiteandroid.Models;

import java.io.Serializable;

public class Visiteur implements Serializable {
    private String username;
    private String nom;
    private String prenom;
    private String tel;
    private String mail;

    public Visiteur(String username, String nom, String prenom, String tel, String mail) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
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

    @Override
    public String toString()
    {
        return nom  + " " + prenom;
    }
}
