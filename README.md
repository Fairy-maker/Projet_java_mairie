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
- eclipse (si possible)
- JUnit 5 

## Installation 
### Cloner le repo
 `git clone <repo-url>`
 
 `cd projet_java_mairie`

## Lancement du projet 
 ### Application Java (classe main)
  #### Depuis eclipse : 
 Pour exécuter la classe main vous pouvez soit :
 - clic droit sur projet_java_mairie > Run As > Java Application > main > Ok
 - bouton Run
  #### Depuis votre terminal : 
  - Commencer par ouvrir un terminal depuis le projet (clic droit sur le projet > nouveau terminal au projet)
    #### Compiler le projet :
    Pour compiler le projet, vous pouvez soit :
    - Compiler toutes les classes d'un seul coup en faisant :
      `javac -d bin $(find src -name "*.java")`
    - Compiler chaque classe une par une en faisant :
      `javac src/nompackage/NomClasse.java`
      Attention cette deuxième méthode de compilation nécessite que toutes les autres classes sois compiler avant de compiler la classe main. Une erreur de compilation apparaitra sinon.
    #### Executer le projet :
    - Pour exécuter une classe vous devez vous placer sur le bon dossier et entrer :
      `java nomdupackage.NomDeMaClasse`
    - Pour exécuter le projet via la classe main vous devez écrire :
      `java -cp bin main.Main` ou encore si vous êtes bien dans le bon dossier
      `java main.Main`.
      
   ### Utilisation via la console
   1. Entrer un entier positif ou nul qui constituera votre graine d'aléa
   2. Choisissez un scénario en écrivant 1 ou 2 sur la console : les projets simulés s'affichent ainsi que leur récapitulatif
   3. Choisissez une méthode de résolution parmi les 4 proposés en écrivant leur numéro sur la console
   4. La solution gloutonne s'affiche
  ### Test JUnit
   #### Depuis eclipse : 
  Pour lancer les tests unitaires (JUnit) vous pouvez soit : 
  - clic droit sur projet_java_mairie > Run As > JUnit test
  - cliquer sur chaque JUnit puis Run


**Auteur :** BAIGNERES Clara, BENAMEUR Féryel, BOUCHERON Lucie 
