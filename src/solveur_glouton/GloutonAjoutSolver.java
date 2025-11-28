package solveur_glouton;


import java.util.*;
import sacADos.SacADos;

public class GloutonAjoutSolver {
	
	public static List<ObjetDansSacADos> resolutionParMethodeGloutonne(SacADos sacADos) throws Exception {
		
		List<ObjetDansSacADos> result = List.of(); //Creation liste result
		
		// On trie les objets du sac a dos
		
		//On recupere tous les objets qui respectent les conditions de notre interface ObjetDansSacADos depuis 
		// getObjets de notre interface sacADos 
		List<ObjetDansSacADos> tousLesObjets = sacADos.getObjets(); 
		
		// Je définis comparatorByInterest comme le comparateur issus de SortByInterest
		SortByInterest comparatorByInterest = new SortByInterest();
		
		// Je trie les objets conservés en fonction de comparatorByInterest
		tousLesObjets.sort(comparatorByInterest);
		
		// Je conserve dans une variable la taille de la liste getBudgets(normalement 3)
		int nbrBudgets = sacADos.getBudgets().length;
		
		// On cree une liste de taille nbrBudgets initalisée à 0
		int[] conso = new int[nbrBudgets];
		Arrays.fill(conso, 0);
		
		// Je fais une boucle sur tous les objets (qui sont maintenant triés)  
		for (ObjetDansSacADos objet : tousLesObjets) {
			
			// Je crée une nouvelle liste newConso dans laquelle 
			int[] newConso = Utils.addCoordinates(objet.setCouts(), conso);
			if (Utils.allSmaller(newConso, sacADos.getBudgets())) {
				conso = newConso;
				result.add(objet);
			}
		}
		
		return result;
	}
	
	public void ajouterObjet() {
		SacADos sac = new SacADos(nbrBud);
	}
}

