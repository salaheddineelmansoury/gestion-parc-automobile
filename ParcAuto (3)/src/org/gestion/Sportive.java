package org.gestion;

public class Sportive extends Moto {
    public Sportive(String immatriculation, int kilometrage, String carburant, int nbRoues) {
        super(immatriculation, kilometrage, carburant, nbRoues);
    }

    public Sportive() {
        super();
    }

    @Override
    public String getType() {
        return "Sportive";
    }
}

