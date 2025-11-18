package solveur_glouton;

import java.util.Comparator;


public class SortByInterest implements Comparator<ObjetDansSacADos> {
	
	private int sommeDesCouts(ObjetDansSacADos o) {
		int somme = 0;
		for (int c : o.getCouts()) {
			somme += c;
		}
		return somme;
	}
	
	
	private double interet(ObjetDansSacADos o) {
		return ((double) o.getUtilite()) / ((double) sommeDesCouts(o));
	}

	
	@Override
	public int compare(ObjetDansSacADos o1, ObjetDansSacADos o2) {
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
