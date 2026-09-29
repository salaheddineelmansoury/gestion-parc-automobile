package org.gestion;

public class Camion extends Voiture {
    public Camion(String immatriculation, int kilometrage, String carburant, int nbPortes, String transmission) {
        super(immatriculation, kilometrage, carburant, nbPortes, transmission);
    }

    public Camion() {
        super();
    }

    @Override
    public String getType() {
        return "Camion";
    }
}
