package org.tools;

import org.gestion.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Outils simples CSV pour sauvegarder / charger.
 * Format CSV très simple : type;immatriculation;kilometrage;carburant;champSpec1;champSpec2
 */
public class FileTools {

    public static void saveCsv(String path, List<Vehicule> parc) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Vehicule v : parc) {
                String line = toCsvLine(v);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static List<Vehicule> loadCsv(String path) throws IOException {
        List<Vehicule> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String l;
            while ((l = reader.readLine()) != null) {
                Vehicule v = fromCsvLine(l);
                if (v != null) list.add(v);
            }
        }
        return list;
    }

    private static String toCsvLine(Vehicule v) {
        String base = v.getType() + ";" + v.getImmatriculation() + ";" + v.getKilometrage() + ";" + v.getCarburant();
        if (v instanceof org.gestion.Moto) {
            return base + ";" + ((org.gestion.Moto) v).getNbRoues();
        } else if (v instanceof org.gestion.Voiture) {
            return base + ";" + ((org.gestion.Voiture) v).getNbPortes() + ";" + ((org.gestion.Voiture) v).getTransmission();
        } else {
            return base;
        }
    }

    private static Vehicule fromCsvLine(String line) {
        String[] parts = line.split(";");
        if (parts.length < 4) return null;
        String type = parts[0];
        String imm = parts[1];
        int km = Integer.parseInt(parts[2]);
        String car = parts[3];
        try {
            switch (type) {
                case "Roadster":
                    return new org.gestion.Roadster(imm, km, car, Integer.parseInt(parts[4]));
                case "Sportive":
                    return new org.gestion.Sportive(imm, km, car, Integer.parseInt(parts[4]));
                case "Custom":
                    return new org.gestion.Custom(imm, km, car, Integer.parseInt(parts[4]));
                case "Citadine":
                    return new org.gestion.Citadine(imm, km, car, Integer.parseInt(parts[4]), parts[5]);
                case "Berline":
                    return new org.gestion.Berline(imm, km, car, Integer.parseInt(parts[4]), parts[5]);
                case "Utilitaire":
                    return new org.gestion.Utilitaire(imm, km, car, Integer.parseInt(parts[4]), parts[5]);
                case "Camion":
                    return new org.gestion.Camion(imm, km, car, Integer.parseInt(parts[4]), parts[5]);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println("Erreur parsing ligne CSV: " + line + " -> " + e.getMessage());
            return null;
        }
    }
}

