package org.gestion;

public class Custom extends Moto {
    public Custom(String immatriculation, int kilometrage, String carburant, int nbRoues) {
        super(immatriculation, kilometrage, carburant, nbRoues);
    }

    public Custom() {
        super();
    }

    @Override
    public String getType() {
        return "Custom";
    }
}

