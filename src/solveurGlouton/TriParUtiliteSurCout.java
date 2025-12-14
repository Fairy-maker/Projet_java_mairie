package solveurGlouton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TriParUtiliteSurCout implements Comparator<ObjetInterface> {

    private final ArrayList<Integer> indicesValeursMax;

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

    private int maxDesCouts(ObjetInterface o) {
        int maxCourant = 0;
        for (int indice: this.indicesValeursMax) {
            if (maxCourant < o.getCouts()[indice]) {
                maxCourant = o.getCouts()[indice];
            }
        }
        return maxCourant;
    }

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
