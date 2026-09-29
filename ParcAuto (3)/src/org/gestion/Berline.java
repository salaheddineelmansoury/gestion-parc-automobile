package org.gestion;

public class Berline extends Voiture {
    public Berline(String immatriculation, int kilometrage, String carburant, int nbPortes, String transmission) {
        super(immatriculation, kilometrage, carburant, nbPortes, transmission);
    }

    public Berline() {
        super();
    }

    @Override
    public String getType() {
        return "Berline";
    }
}
