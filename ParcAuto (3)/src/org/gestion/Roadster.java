package org.gestion;

public class Roadster extends Moto {
    public Roadster(String immatriculation, int kilometrage, String carburant, int nbRoues) {
        super(immatriculation, kilometrage, carburant, nbRoues);
    }

    public Roadster() {
        super();
    }

    @Override
    public String getType() {
        return "Roadster";
    }
}

