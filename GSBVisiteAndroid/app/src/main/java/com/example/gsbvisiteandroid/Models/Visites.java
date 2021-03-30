package com.example.gsbvisiteandroid.Models;

import java.util.List;

public class Visites {
    private List<Visite> lesVisites;

    public Visites(List<Visite> visites) {
        this.lesVisites = visites;
    }

    public List<Visite> getVisites() {
        return lesVisites;
    }
}
