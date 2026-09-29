package org.gestion;

import java.util.Objects;

public abstract class Vehicule {
    private String immatriculation;
    private int kilometrage;
    private String carburant;

    public Vehicule(String immatriculation, int kilometrage, String carburant) {
        this.immatriculation = immatriculation;
        this.kilometrage = kilometrage;
        this.carburant = carburant;
    }

    public Vehicule() {
        this("", 0, "");
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    @Override
    public String toString() {
        return String.format("%s[immatriculation=%s, kilometrage=%d, carburant=%s]",
                getType(), immatriculation, kilometrage, carburant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicule)) return false;
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(immatriculation, vehicule.immatriculation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(immatriculation);
    }

    public abstract String getType();
}
