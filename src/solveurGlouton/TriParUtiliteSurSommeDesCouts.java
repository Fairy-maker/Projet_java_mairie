package solveurGlouton;

import java.util.Comparator;

/**
 * Permet de comparer deux objets selon la première formule proposée dans le cours pour
 * résoudre un problème par une solution gloutonne à ajout : l'utilité d'un objet divisée
 * par la somme des ses couts
 *
 * @author clara baigneres
 * @version 1.0
 */

public class TriParUtiliteSurSommeDesCouts implements Comparator<ObjetInterface> {


    /**
     * Calcule la somme des couts d'un objet
     * @param o un objet qui respecte les contraintes de mon interface ObjetInterface
     * @return la somme des couts de l'objet o
     */
	private int sommeDesCouts(ObjetInterface o) {
		int somme = 0;
		for (int c : o.getCouts()) {
			somme += c;
		}
		return somme;
	}

    /**
     * Calcule l'interet d'un objet selon la première formule proposée dans le cours
     * @param o un objet qui respecte les contraintes de mon interface ObjetInterface
     * @return l'interet de l'objet o
     */
	private double interet(ObjetInterface o) {
        return ((double) o.getUtilite()) / ((double) sommeDesCouts(o));
	}


    /**
     * Compare deux objets selon leur interet
     * @param o1 un objet qui respecte les contraintes de mon interface ObjetInterface
     * @param o2 un second objet qui respecte les contraintes de mon interface ObjetInterface
     * @return une liste qui trie les objets du plus au moins interessant
     */
	@Override
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
