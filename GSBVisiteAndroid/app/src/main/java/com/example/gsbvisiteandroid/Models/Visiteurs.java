package com.example.gsbvisiteandroid.Models;

import java.io.Serializable;
import java.util.List;

public class Visiteurs implements Serializable {
    private List<Visiteur> visiteurs;

    public Visiteur getVisiteur() {
        return visiteur;
    }

    private Visiteur visiteur;

    public Visiteurs(List<Visiteur> list)
    {
        this.visiteurs = list;
    }

    public List<Visiteur> getVisiteurs() {
        return visiteurs;
    }
}
