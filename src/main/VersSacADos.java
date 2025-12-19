package main;

import equipe.Projet;
import equipe.Secteur;
import sacADos.Objet;
import sacADos.SacADos;
import solveurGlouton.ObjetInterface;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Transforme une liste de projets en objets pour le sac à dos.
 * Gère aussi la lecture depuis un fichier MKP (format spécifique).
 * Permet de générer un SacADos prêt à être résolu.
 */
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

    /**
     * Constructeur depuis liste
     *
     * @param budgets int[] tableau des budgets par dimension
     * @param projets List<Projet> liste des projets
     * @param scenario le scenario choisi par l'utilisateur
     */
    VersSacADos(int[] budgets, List<Projet> projets, Scenario scenario) {
        this.n = projets.size();
        this.k = budgets.length;
        this.budgets = budgets;
        this.couts = new int[this.n][this.k];
        this.benefices = new int[this.n];
        // en fonction du scenario choisi on crée nos listes de couts et benefices
        switch (scenario) {
            case COUTS_PAR_TYPES_DE_COUT:
                for (int i=0; i < this.n; i++) {
                    Projet proj = projets.get(i);
                    this.couts[i] = proj.getCout().toArray();
                    this.benefices[i] = proj.getBenefice();
                }
                break;
            case COUTS_PAR_SECTEUR:
                for (int i=0; i < this.n; i++) {
                    Projet proj = projets.get(i);
                    this.couts[i] = new int[budgets.length];
                    Arrays.fill(this.couts[i], 0);

                    // On cherche l'index du secteur de notre objet dans l'énumeration pour
                    // faire correspondre l'index de son cout
                    Secteur secteurDuProjet = proj.getSecteur();
                    int indexDuSecteur = Arrays.asList(Secteur.values()).indexOf(secteurDuProjet);
                    this.couts[i][indexDuSecteur] = proj.getCout().getCoutEco();

                    this.benefices[i] = proj.getBenefice();
                }
                break;
        }
    }

    /**
     * Retourne la matrice de couts, où le premier indice détermine
     * l'objet et le second spécifie le type de cout.
     * @return la matrice de couts.
     */
    public int[][] getCouts() {
		return couts;
	}

    /**
     * Constructeur depuis fichier
     *
     * @param mkpFilePath Path chemin du fichier MKP
     * @throws Exception si le fichier n’est pas conforme
     */
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
    /**
     * Générer SacADos
     *
     * Transforme les projets et budgets en objet SacADos.
     *
     * @return SacADos prêt à résoudre
     */
    public SacADos genererSacADos() {

        List<ObjetInterface> objets = new ArrayList<>();

        for (int i=0; i<this.n; i++) {
            Objet objet = new Objet(this.benefices[i], this.couts[i]);
            objets.add(objet);
        }

        return new SacADos(this.budgets, objets);

    }

}

