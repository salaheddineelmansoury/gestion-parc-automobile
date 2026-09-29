package org.gestion;

public abstract class Moto extends Vehicule {
    private int nbRoues;

    public Moto(String immatriculation, int kilometrage, String carburant, int nbRoues) {
        super(immatriculation, kilometrage, carburant);
        this.nbRoues = nbRoues;
    }

    public Moto() {
        super();
        this.nbRoues = 2;
    }

    public int getNbRoues() {
        return nbRoues;
    }

    public void setNbRoues(int nbRoues) {
        this.nbRoues = nbRoues;
    }

    @Override
    public String toString() {
        return super.toString().replace("]", String.format(", nbRoues=%d]", nbRoues));
    }

    @Override
    public abstract String getType();
}

