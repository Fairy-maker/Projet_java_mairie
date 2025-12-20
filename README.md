# Projet_java_mairie
Ce projet a pour objectif de modéliser et de simuler le fonctionnement d'une équipe municipale. Cette équipe municipale est chargée de proposer, évaluer et sélectionner des projets, puis de résoudre un problème de sac à dos multidimensionnel à l'aide de méthodes gloutonnes.

## Structure du projet 
```
projet_java_mairie
├── src/ 
│ ├── equipe/
│ │ ├── Cout.java
│ │ ├── Elu.java
│ │ ├── Evaluateur.java
│ │ └── ...
│ ├── main/
│ │ ├── Main.java
│ │ ├── Scenario.java
│ │ └── VersSacADos.java
│ ├── sacADos/
│ │ ├── MethodeDeResolution.java
│ │ ├── Objet.java
│ │ └── SacADos.java
│ └── solveurGlouton/
│ │ ├── GloutonAjoutSolver.java
│ │ ├── GloutonRetraitSolveur.java
│ │ ├── HillClimbingSolveur.java
│ │ └── ...
└── test/
├── equipe/
│ │ ├── EluTest.java
│ │ └── EvaluateurTest.java
├── main/
│ │ └── VersSacADosTest.java
├── solveurGlouton/
│ │ ├── GloutonRetraitSolverTest.java
│ │ └── HillClimbingSolverTest.java
└── test/resources
│ └── ...
```

## Prérequis 
- Java 21.0.8 ou version compatible avec le projet

## Installation 
### Cloner le repo
 `git clone <repo-url>`
 
 `cd projet_java_mairie`

## Lancement du projet 
 ### Application Java (classe main)
 Pour exécuter la classe main vous pouvez soit :
 - clic droit sur projet_java_mairie > Run As > Java Application > main > Ok
 - bouton Run
   ### Utilisation via la console
   1. Entrer un entier positif ou nul qui constituera votre graine d'aléa
   2. Choisissez un scénario en écrivant 1 ou 2 sur la console : les projets simulés s'affichent ainsi que leur récapitulatif
   3. Choisissez une méthode de résolution parmi les 4 proposés en écrivant leur numéro sur la console
   4. La solution gloutonne s'affiche
  ### Test JUnit
  Pour lancer les tests unitaires (JUnit) vous pouvez soit : 
  - clic droit sur projet_java_mairie > Run As > JUnit test
  - cliquer sur chaque JUnit puis Run


**Auteur :** BAIGNERES Clara, BENAMEUR Féryel, BOUCHERON Lucie 
