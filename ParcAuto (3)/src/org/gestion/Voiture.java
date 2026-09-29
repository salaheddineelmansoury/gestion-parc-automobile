package org.gestion;

public abstract class Voiture extends Vehicule {
    private int nbPortes;
    private String transmission; // traction ou propulsion

    public Voiture(String immatriculation, int kilometrage, String carburant, int nbPortes, String transmission) {
        super(immatriculation, kilometrage, carburant);
        this.nbPortes = nbPortes;
        this.transmission = transmission;
    }

    public Voiture() {
        super();
        this.nbPortes = 4;
        this.transmission = "traction";
    }

    public int getNbPortes() {
        return nbPortes;
    }

    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return super.toString().replace("]", String.format(", nbPortes=%d, transmission=%s]", nbPortes, transmission));
    }

    @Override
    public abstract String getType();
}
