package com.bibliotheque;

import java.time.LocalDate;

public class Emprunt {
    private Livre livre;
    private Adherent adherent;
    private LocalDate dateEmprunt;

    public Emprunt(Livre livre, Adherent adherent) {
        this.livre = livre;
        this.adherent = adherent;
        this.dateEmprunt = LocalDate.now();
    }

    public Livre getLivre() {
        return livre;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    @Override
    public String toString() {
        return livre.getTitre() + " emprunté par " + adherent.getNomComplet() + " le " + dateEmprunt;
    }
}
