package org.gestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ParcManager {
    private final List<Vehicule> parc;

    public ParcManager() {
        this.parc = new ArrayList<>();
    }

    public void ajouter(Vehicule v) {
        if (rechercher(v.getImmatriculation()) != null) {
            System.out.println("Un véhicule avec cette immatriculation existe déjà.");
            return;
        }
        parc.add(v);
        System.out.println("Véhicule ajouté.");
    }

    public Vehicule rechercher(String immatriculation) {
        for (Vehicule v : parc) {
            if (v.getImmatriculation().equalsIgnoreCase(immatriculation)) {
                return v;
            }
        }
        return null;
    }

    public boolean supprimer(String immatriculation) {
        Iterator<Vehicule> it = parc.iterator();
        while (it.hasNext()) {
            Vehicule v = it.next();
            if (v.getImmatriculation().equalsIgnoreCase(immatriculation)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public void afficherTous() {
        if (parc.isEmpty()) {
            System.out.println("Aucun véhicule dans le parc.");
            return;
        }
        for (Vehicule v : parc) {
            System.out.println(v);
        }
    }

    /**
     * Méthode interactive pour modifier un véhicule.
     * Utilise le scanner fourni (évite de créer plusieurs Scanners sur System.in).
     */
    public void modifier(String immatriculation, Scanner scan) {
        Vehicule v = rechercher(immatriculation);
        if (v == null) {
            System.out.println("Véhicule non trouvé.");
            return;
        }
        System.out.println("Véhicule trouvé : " + v);
        System.out.print("Nouvelle immatriculation (enter pour garder) : ");
        String s = scan.nextLine().trim();
        if (!s.isEmpty()) v.setImmatriculation(s);

        System.out.print("Nouveau kilometrage (enter pour garder) : ");
        String km = scan.nextLine().trim();
        if (!km.isEmpty()) {
            try {
                int k = Integer.parseInt(km);
                v.setKilometrage(k);
            } catch (NumberFormatException e) {
                System.out.println("Valeur de kilometrage non valide, garde l'ancienne.");
            }
        }

        System.out.print("Nouveau carburant (enter pour garder) : ");
        String car = scan.nextLine().trim();
        if (!car.isEmpty()) v.setCarburant(car);

        // si c'est une Moto ou Voiture, proposer champs spécifiques
        if (v instanceof org.gestion.Moto) {
            System.out.print("Nombre de roues (enter pour garder) : ");
            String nr = scan.nextLine().trim();
            if (!nr.isEmpty()) {
                try {
                    ((org.gestion.Moto) v).setNbRoues(Integer.parseInt(nr));
                } catch (NumberFormatException e) {
                    System.out.println("Nombre de roues non valide, garde l'ancien.");
                }
            }
        } else if (v instanceof org.gestion.Voiture) {
            System.out.print("Nombre de portes (enter pour garder) : ");
            String np = scan.nextLine().trim();
            if (!np.isEmpty()) {
                try {
                    ((org.gestion.Voiture) v).setNbPortes(Integer.parseInt(np));
                } catch (NumberFormatException e) {
                    System.out.println("Nombre de portes non valide, garde l'ancien.");
                }
            }
            System.out.print("Transmission (enter pour garder) : ");
            String tr = scan.nextLine().trim();
            if (!tr.isEmpty()) ((org.gestion.Voiture) v).setTransmission(tr);
        }

        System.out.println("Véhicule modifié : " + v);
    }

    // utilitaire pour exporter la liste (utilisé par FileTools)
    public List<Vehicule> getParc() {
        return new ArrayList<>(parc);
    }

    // utilitaire pour charger une liste (remplace le parc actuel)
    public void setParc(List<Vehicule> liste) {
        parc.clear();
        parc.addAll(liste);
    }
}
