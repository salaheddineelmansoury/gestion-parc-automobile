# Gestion de parc automobile

Programme Java en ligne de commande (interface console, sans interface graphique) pour gérer un parc de véhicules (voitures et motos). Projet réalisé pour mettre en pratique la **programmation orientée objet (POO)** : héritage, classes abstraites et polymorphisme.

## Fonctionnalités

Menu interactif dans la console :

1. Ajouter un véhicule (choix du type parmi 7)
2. Rechercher un véhicule par immatriculation
3. Modifier un véhicule (Entrée pour conserver une valeur)
4. Supprimer un véhicule
5. Afficher tous les véhicules
6. Enregistrer le parc dans un fichier CSV
7. Charger un parc depuis un fichier CSV

Un même numéro d'immatriculation ne peut pas être ajouté deux fois. La recherche ne tient pas compte des majuscules/minuscules.

## Modélisation POO

```
Vehicule (classe abstraite : immatriculation, kilométrage, carburant)
├── Voiture (classe abstraite : nombre de portes, transmission)
│   ├── Citadine
│   ├── Berline
│   ├── Utilitaire
│   └── Camion
└── Moto (classe abstraite : nombre de roues)
    ├── Roadster
    ├── Sportive
    └── Custom
```

Notions mises en pratique :

- **Héritage** et **classes abstraites** (`Vehicule`, `Voiture`, `Moto`)
- **Polymorphisme** : la méthode abstraite `getType()` est redéfinie dans chaque classe fille, et `toString()` est enrichi à chaque niveau de la hiérarchie
- **Encapsulation** : attributs privés, accesseurs et mutateurs
- **Surcharge de constructeurs** (constructeur avec paramètres et constructeur par défaut)
- Redéfinition de `equals()` et `hashCode()` (l'immatriculation identifie un véhicule)
- Collections Java : `ArrayList`, `Iterator`
- Gestion des exceptions (`NumberFormatException`, `IOException`) et validation des saisies
- Lecture/écriture de fichiers avec `BufferedReader` / `BufferedWriter` (try-with-resources)

## Structure du projet

```
src/
└── org/
    ├── Main.java              Menu et interaction avec l'utilisateur
    ├── gestion/
    │   ├── Vehicule.java, Voiture.java, Moto.java
    │   ├── Citadine.java, Berline.java, Utilitaire.java, Camion.java
    │   ├── Roadster.java, Sportive.java, Custom.java
    │   └── ParcManager.java   Gestion du parc (ajout, recherche, modification, suppression)
    └── tools/
        └── FileTools.java     Sauvegarde et chargement CSV
```

## Format du fichier CSV

```
type;immatriculation;kilometrage;carburant;champ1;champ2
```

Exemples :

```
Berline;AB-123-CD;45000;Essence;4;traction
Roadster;EF-456-GH;12000;Essence;2
```

## Lancer le projet

Prérequis : JDK 8 ou supérieur.

Depuis la racine du projet :

```
javac -d out src/org/*.java src/org/gestion/*.java src/org/tools/*.java
java -cp out org.Main
```

Le projet s'ouvre aussi directement dans IntelliJ IDEA ou Eclipse (classe principale : `org.Main`).

## Pistes d'amélioration

- Ajouter une interface graphique (JavaFX ou Swing)
- Ajouter des attributs supplémentaires (marque, modèle, date de mise en circulation)
- Remplacer le stockage CSV par une base de données (SQL)
- Ajouter des tests unitaires (JUnit)

## Auteur

Salah Eddine EL MANSOURY – Étudiant L3 MIAGE, Université de Toulouse
[LinkedIn](https://linkedin.com/in/salah-eddine-el-mansoury-1686a82b4/)
