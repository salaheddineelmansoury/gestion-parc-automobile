package org.gestion;

public class Utilitaire extends Voiture {
    public Utilitaire(String immatriculation, int kilometrage, String carburant, int nbPortes, String transmission) {
        super(immatriculation, kilometrage, carburant, nbPortes, transmission);
    }

    public Utilitaire() {
        super();
    }

    @Override
    public String getType() {
        return "Utilitaire";
    }
}

