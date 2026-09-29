package org.gestion;

public class Citadine extends Voiture {
    public Citadine(String immatriculation, int kilometrage, String carburant, int nbPortes, String transmission) {
        super(immatriculation, kilometrage, carburant, nbPortes, transmission);
    }

    public Citadine() {
        super();
    }

    @Override
    public String getType() {
        return "Citadine";
    }
}

