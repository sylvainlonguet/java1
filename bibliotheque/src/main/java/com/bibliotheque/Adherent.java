package com.bibliotheque;

public class Adherent {
    private String nom;
    private String prenom;

    public Adherent(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }

    @Override
    public String toString() {
        return getNomComplet();
    }
}
