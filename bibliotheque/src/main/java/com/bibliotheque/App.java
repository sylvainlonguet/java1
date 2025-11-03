package com.bibliotheque;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();
        Scanner sc = new Scanner(System.in);

        // Quelques données de départ
        bibliotheque.ajouterLivre(new Livre("1984", "George Orwell"));
        bibliotheque.ajouterLivre(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry"));
        bibliotheque.ajouterAdherent(new Adherent("Dupont", "Alice"));
        bibliotheque.ajouterAdherent(new Adherent("Martin", "Bob"));

        boolean continuer = true;
        while (continuer) {
            System.out.println("\n--- Menu Bibliothèque ---");
            System.out.println("1. Afficher les livres");
            System.out.println("2. Emprunter un livre");
            System.out.println("3. Rendre un livre");
            System.out.println("4. Afficher les emprunts");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            int choix = Integer.parseInt(sc.nextLine());

            switch (choix) {
                case 1 -> bibliotheque.afficherLivres();
                case 2 -> {
                    System.out.print("Titre du livre : ");
                    String titre = sc.nextLine();
                    System.out.print("Nom complet de l'adhérent : ");
                    String nom = sc.nextLine();
                    bibliotheque.emprunterLivre(titre, nom);
                }
                case 3 -> {
                    System.out.print("Titre du livre à rendre : ");
                    String titre = sc.nextLine();
                    bibliotheque.rendreLivre(titre);
                }
                case 4 -> bibliotheque.afficherEmprunts();
                case 0 -> continuer = false;
                default -> System.out.println("Choix invalide !");
            }
        }

        sc.close();
        System.out.println("Merci d'avoir utilisé la bibliothèque !");
    }
}
