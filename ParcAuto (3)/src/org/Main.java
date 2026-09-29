package org;

import org.gestion.*;
import org.tools.FileTools;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ParcManager manager = new ParcManager();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choix = -1;

        do {
            printMenu();
            System.out.print("Votre choix : ");
            String line = scan.nextLine();
            try {
                choix = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Choix non valide.");
                continue;
            }

            switch (choix) {
                case 1:
                    ajouterVehiculeInteractive(scan);
                    break;
                case 2:
                    System.out.print("Immatriculation à rechercher : ");
                    String imm = scan.nextLine().trim();
                    Vehicule v = manager.rechercher(imm);
                    if (v != null) System.out.println("Trouvé : " + v);
                    else System.out.println("Aucun véhicule trouvé.");
                    break;
                case 3:
                    System.out.print("Immatriculation à modifier : ");
                    String immMod = scan.nextLine().trim();
                    manager.modifier(immMod, scan);
                    break;
                case 4:
                    System.out.print("Immatriculation à supprimer : ");
                    String immSup = scan.nextLine().trim();
                    boolean ok = manager.supprimer(immSup);
                    System.out.println(ok ? "Supprimé." : "Non trouvé.");
                    break;
                case 5:
                    manager.afficherTous();
                    break;
                case 6:
                    System.out.print("Chemin fichier CSV pour sauvegarder : ");
                    String out = scan.nextLine().trim();
                    try {
                        FileTools.saveCsv(out, manager.getParc());
                        System.out.println("Sauvegarde OK.");
                    } catch (IOException e) {
                        System.out.println("Erreur sauvegarde : " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Chemin fichier CSV à charger : ");
                    String in = scan.nextLine().trim();
                    try {
                        List<Vehicule> list = FileTools.loadCsv(in);
                        manager.setParc(list);
                        System.out.println("Chargement OK, " + list.size() + " véhicules chargés.");
                    } catch (IOException e) {
                        System.out.println("Erreur chargement : " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Au revoir.");
                    break;
                default:
                    System.out.println("Option non prise en charge pour le moment.");
            }

        } while (choix != 0);

        scan.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== GESTION DU PARC AUTOMOBILE ===");
        System.out.println("1. Ajouter un véhicule");
        System.out.println("2. Rechercher un véhicule");
        System.out.println("3. Modifier un véhicule");
        System.out.println("4. Supprimer un véhicule");
        System.out.println("5. Afficher tous les véhicules");
        System.out.println("6. Enregistrer les véhicules (CSV)");
        System.out.println("7. Charger une liste de véhicules (CSV)");
        System.out.println("0. Quitter");
    }

    private static void ajouterVehiculeInteractive(Scanner scan) {
        System.out.println("Type de véhicule :");
        System.out.println("1 - Roadster (moto)");
        System.out.println("2 - Sportive (moto)");
        System.out.println("3 - Custom (moto)");
        System.out.println("4 - Citadine");
        System.out.println("5 - Berline");
        System.out.println("6 - Utilitaire");
        System.out.println("7 - Camion");
        System.out.print("Votre choix : ");
        String t = scan.nextLine().trim();

        System.out.print("Immatriculation : ");
        String imm = scan.nextLine().trim();
        System.out.print("Kilometrage (entier) : ");
        int km = safeInt(scan);
        System.out.print("Carburant : ");
        String carburant = scan.nextLine().trim();

        Vehicule v = null;
        switch (t) {
            case "1":
                System.out.print("Nombre de roues : ");
                int nr1 = safeInt(scan);
                v = new Roadster(imm, km, carburant, nr1);
                break;
            case "2":
                System.out.print("Nombre de roues : ");
                int nr2 = safeInt(scan);
                v = new Sportive(imm, km, carburant, nr2);
                break;
            case "3":
                System.out.print("Nombre de roues : ");
                int nr3 = safeInt(scan);
                v = new Custom(imm, km, carburant, nr3);
                break;
            case "4":
                System.out.print("Nb portes : ");
                int np4 = safeInt(scan);
                System.out.print("Transmission (traction/propulsion) : ");
                String tr4 = scan.nextLine().trim();
                v = new Citadine(imm, km, carburant, np4, tr4);
                break;
            case "5":
                System.out.print("Nb portes : ");
                int np5 = safeInt(scan);
                System.out.print("Transmission (traction/propulsion) : ");
                String tr5 = scan.nextLine().trim();
                v = new Berline(imm, km, carburant, np5, tr5);
                break;
            case "6":
                System.out.print("Nb portes : ");
                int np6 = safeInt(scan);
                System.out.print("Transmission : ");
                String tr6 = scan.nextLine().trim();
                v = new Utilitaire(imm, km, carburant, np6, tr6);
                break;
            case "7":
                System.out.print("Nb portes : ");
                int np7 = safeInt(scan);
                System.out.print("Transmission : ");
                String tr7 = scan.nextLine().trim();
                v = new Camion(imm, km, carburant, np7, tr7);
                break;
            default:
                System.out.println("Type non reconnu.");
                return;
        }
        manager.ajouter(v);
    }

    private static int safeInt(Scanner scan) {
        while (true) {
            String s = scan.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Entier attendu, réessayez : ");
            }
        }
    }
}
