package solveurGlouton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Permet de comparer deux objets selon la formule donnée dans le cours pour résoudre
 * un problème par une solution gloutonne à retrait : l'utilité d'un objet divisée par
 * le max des ses couts
 *
 * @author clara baigneres
 * @version 1.0
 */
public class TriParUtiliteSurCout implements Comparator<ObjetInterface> {

    private final ArrayList<Integer> indicesValeursMax;

    /**
     * Initialise ma variable indicesValeursMax
     * @param sacADos un sac à dos respectant les contraintes de mon interface SacADosInterface
     * @throws Exception dans le cas où addCoordinates, substractCoordinates ou indicesOfMacValue
     * renvoie une erreur
     */
    TriParUtiliteSurCout(SacADosInterface sacADos) throws Exception {

        // On calcule la somme des couts de tous les objets du sac a dos

        int[] sommeDesCouts = new int[sacADos.getDimension()];
        Arrays.fill(sommeDesCouts, 0);

        for(ObjetInterface objet: sacADos.getObjets()) {
            sommeDesCouts = Utils.addCoordinates(sommeDesCouts, objet.getCouts());
        }

        // On retranche les budgets de la somme

        int[] sommeDesCoutsMoinsBudgets = Utils.substractCoordinates(sommeDesCouts, sacADos.getBudgets());

        // On determine les indices des plus grands dépassement de budget

        this.indicesValeursMax = Utils.indicesOfMaxValue(sommeDesCoutsMoinsBudgets);

    }

    /**
     * Calcule le cout maximal parmis les couts d'un objet
     * @param o un objet qui respecte les contraintes de mon interface ObjetInterface
     * @return le cout maximal parmis les couts d'un objet
     */
    private int maxDesCouts(ObjetInterface o) {
        int maxCourant = 0;
        for (int indice: this.indicesValeursMax) {
            if (maxCourant < o.getCouts()[indice]) {
                maxCourant = o.getCouts()[indice];
            }
        }
        return maxCourant;
    }

    /**
     * Calcule l'interet d'un objet selon la formule du cours
     * @param o un objet qui respecte les contraintes de mon interface ObjetInterface
     * @return l'interet de l'objet o
     */
    private double interet(ObjetInterface o) {
        int max = maxDesCouts(o);
        int denominateur;
        if (max == 0) {
            denominateur = Integer.MAX_VALUE;
        } else {
            denominateur = max;
        }
        return ((double) o.getUtilite()) / ((double) denominateur);
    }

    /**
     * Compare deux objets selon leur interet
     * @param o1 un objet qui respecte les contraintes de mon interface ObjetInterface
     * @param o2 un second objet qui respecte les contraintes de mon interface ObjetInterface
     * @return une liste qui trie les objets du moins au plus interessant
     */
    public int compare(ObjetInterface o1, ObjetInterface o2) {
        double interet1 = interet(o1);
        double interet2 = interet(o2);
        if(interet1 < interet2) {
            return -1;
        } else if(interet1 == interet2) {
            return 0;
        } else {
            return 1;
        }
    }

}
