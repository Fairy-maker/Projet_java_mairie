package solveur_glouton;


/*import java.util.*;
import sacADos.Objet; // ici j'ai importe la classe Objet du package SacADos (dans mes fiches de cours)
public class GloutonAjoutSolver {
	
	public static void main () {
		getDimension dim = new Dimension () ;
		UtiliteTotale utilite = new UtiliteTotale () ;
		CoutTotal cout = new CoutTotal ();
		dim.getDimension();
		utilite.getUtilite();
		cout.getCout();
	} // ici j'ai créé une fonction main pour récupérer un objet issu de la fonction getDimension, getUtilite et getCout (video 1)

	private List[] S;

	public void ajoutS(List[] S){
		this.S = S ; 
	}
}
*/
import java.util.*;


interface ObjetDansSacADos {
	int getUtilite();
	int[] getCouts();
}

interface SacADos {
	int getDimension();
	int[] getBudgets();
	List<ObjetDansSacADos> getObjets();
}


public class GloutonAjoutSolver {
	
	public static List<ObjetDansSacADos> resolutionParMethodeGloutonne(SacADos sacADos) throws Exception {
		
		List<ObjetDansSacADos> result = List.of();
		
		// On trie les objets du sac a dos
		List<ObjetDansSacADos> tousLesObjets = sacADos.getObjets();
		SortByInterest comparatorByInterest = new SortByInterest();
		tousLesObjets.sort(comparatorByInterest);
		
		int nbrBudgets = sacADos.getBudgets().length;
		int[] conso = new int[nbrBudgets];
		Arrays.fill(conso, 0);
		
		for (ObjetDansSacADos objet : tousLesObjets) {
			int[] newConso = Utils.addCoordinates(objet.getCouts(), conso);
			if (Utils.allSmaller(newConso, sacADos.getBudgets())) {
				conso = newConso;
				result.add(objet);
			}
		}
		
		return result;
		
	}
	
}

