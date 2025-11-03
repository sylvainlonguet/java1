package com.bibliotheque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bibliotheque {
    private List<Livre> livres = new ArrayList<>();
    private List<Adherent> adherents = new ArrayList<>();
    private List<Emprunt> emprunts = new ArrayList<>();

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public void ajouterAdherent(Adherent adherent) {
        adherents.add(adherent);
    }

    public void afficherLivres() {
        System.out.println("\nListe des livres :");
        for (Livre l : livres) {
            System.out.println(" - " + l);
        }
    }

    public void afficherEmprunts() {
        System.out.println("\nEmprunts en cours :");
        for (Emprunt e : emprunts) {
            System.out.println(" - " + e);
        }
    }

    public void emprunterLivre(String titre, String nomAdherent) {
        Optional<Livre> livreOpt = livres.stream()
            .filter(l -> l.getTitre().equalsIgnoreCase(titre))
            .findFirst();

        Optional<Adherent> adherentOpt = adherents.stream()
            .filter(a -> a.getNomComplet().equalsIgnoreCase(nomAdherent))
            .findFirst();

        if (livreOpt.isEmpty()) {
            System.out.println("Livre introuvable.");
            return;
        }
        if (adherentOpt.isEmpty()) {
            System.out.println("Adhérent introuvable.");
            return;
        }

        Livre livre = livreOpt.get();
        Adherent adherent = adherentOpt.get();

        try {
            livre.emprunter();
            emprunts.add(new Emprunt(livre, adherent));
            System.out.println(adherent.getNomComplet() + " a emprunté \"" + livre.getTitre() + "\".");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void rendreLivre(String titre) {
        Optional<Emprunt> empruntOpt = emprunts.stream()
            .filter(e -> e.getLivre().getTitre().equalsIgnoreCase(titre))
            .findFirst();

        if (empruntOpt.isEmpty()) {
            System.out.println("Aucun emprunt trouvé pour ce livre.");
            return;
        }

        Emprunt emprunt = empruntOpt.get();
        emprunt.getLivre().rendre();
        emprunts.remove(emprunt);
        System.out.println("Le livre \"" + emprunt.getLivre().getTitre() + "\" a été rendu.");
    }
}
