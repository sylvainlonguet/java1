package com.bibliotheque;

public class Livre {
    private String titre;
    private String auteur;
    private boolean disponible;

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
        this.disponible = true;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public boolean estDisponible() {
        return disponible;
    }

    public void emprunter() {
        if (!disponible) {
            throw new IllegalStateException("Le livre est déjà emprunté.");
        }
        disponible = false;
    }

    public void rendre() {
        disponible = true;
    }

    @Override
    public String toString() {
        return titre + " - " + auteur + (disponible ? " (disponible)" : " (emprunté)");
    }
}
