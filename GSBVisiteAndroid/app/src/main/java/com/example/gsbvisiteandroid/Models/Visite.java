package com.example.gsbvisiteandroid.Models;

public class Visite {
    private int id;
    private String dateVisite;
    private String commentaire;
    private String motif_id;
    private String visiteur_id;
    private String praticien_id;

    public int getId() {
        return id;
    }

    public String getDateVisite() {
        return dateVisite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getVisiteur_id() {
        return visiteur_id;
    }

    public String getMotif_id() {
        return motif_id;
    }

    public String getPraticien_id() {
        return praticien_id;
    }

    public Visite(int id, String dateVisite, String commentaire, String motif_id, String visiteur_id, String praticien_id) {
        this.id = id;
        this.dateVisite = dateVisite;
        this.commentaire = commentaire;
        this.motif_id = motif_id;
        this.visiteur_id = visiteur_id;
        this.praticien_id = praticien_id;
    }

    @Override
    public String toString()
    {
        return dateVisite  + " " + commentaire;
    }
}
