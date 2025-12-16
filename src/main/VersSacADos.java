package main;

import equipe.Projet;
import sacADos.Objet;
import sacADos.SacADos;
import solveurGlouton.ObjetInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VersSacADos {

    final int[] budgets;
    // Couts des projets. Chaque ligne représente les couts d'un projet.
    private final int[][] couts;
    // Benefices (ou utilites) des projets
    private final int[] benefices;
    // Nombre d'objets
    final int n;
    // Nombre de budgets
    final int k;

    public VersSacADos(int[] budgets, List<Projet> projets) {
        this.n = projets.size();
        this.k = budgets.length;
        this.budgets = budgets;
        this.couts = new int[this.n][this.k];
        this.benefices = new int[this.n];
        for (int i=0; i < this.n; i++) {
            Projet proj = projets.get(i);
            this.couts[i] = proj.getCout().toArray();
            this.benefices[i] = proj.getBenefice();
        }
    }

    public VersSacADos(Path mkpFilePath) throws Exception {

        try (BufferedReader br = Files.newBufferedReader(mkpFilePath)) {

            // La premier ligne du fichier contient:
            // le nombre d'objets, le nombre de budgets
            String[] premiereLigne = br.readLine().trim().split("\\s+");
            this.n = Integer.parseInt(premiereLigne[0]);
            this.k = Integer.parseInt(premiereLigne[1]);
            // On ne considere pas la solution optimale pour le moment

            // Les lignes suivantes contiennent une utilite pour chacun des n objets
            this.benefices = new int[this.n];
            int nbrBenefices = 0;
            while (nbrBenefices < this.n) {
                String[] line = br.readLine().trim().split("\\s+");
                for (String s: line) {
                    int benefice = Integer.parseInt(s);
                    this.benefices[nbrBenefices] = benefice;
                    nbrBenefices++;
                }
            }

            // Les lignes suivantes contiennent les couts
            this.couts = new int[this.n][this.k];
            int j = 0;
            while (j < this.k) {
                int i = 0;
                while (i < this.n) {
                    String[] line = br.readLine().trim().split("\\s+");
                    for (String s: line) {
                        int cout = Integer.parseInt(s);
                        this.couts[i][j] = cout;
                        i++;
                    }
                }
                j++;
            }

            // La dernière ligne contient les budgets
            this.budgets = new int[this.k];
            String[] derniereLigne = br.readLine().trim().split("\\s+");
            if (derniereLigne.length != this.k) {
                throw new Exception();
            }
            for (int i=0; i<this.k; i++) {
                this.budgets[i] = Integer.parseInt(derniereLigne[i]);
            }

        }

    }

    public SacADos genererSacADos() {

        List<ObjetInterface> objets = new ArrayList<>();

        for (int i=0; i<this.n; i++) {
            Objet objet = new Objet(this.benefices[i], this.couts[i]);
            objets.add(objet);
        }

        return new SacADos(this.budgets, objets);

    }

}

