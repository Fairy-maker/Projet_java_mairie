package solveurGlouton;


import java.util.*;

public class GloutonAjoutSolver {

	public static List<ObjetDansSacADos> resoudre(SacADos sacADos) throws Exception {

        // La variable result est initialement vide. Elle sera retournée à la fin de cette méthode.
        // Elle contiendra tous les objets retenus pour le sac à dos.
		List<ObjetDansSacADos> result = new ArrayList<>();

		// On trie les objets du sac a dos

		//On recupere tous les objets qui respectent les conditions de notre interface ObjetDansSacADos depuis 
		// getObjets de notre interface sacADos 
		List<ObjetDansSacADos> tousLesObjets = new ArrayList<>(sacADos.getObjets()); 

		// Je définis comparatorByInterest comme le comparateur issus de TriParUtiliteSurSommeDesCouts
        TriParUtiliteSurSommeDesCouts comparatorByInterest = new TriParUtiliteSurSommeDesCouts();

		// Je trie les objets conservés en fonction de comparatorByInterest
        // Par exemple, quand le comparateur est une instance de SortByInterest, les objets sont
        // triés du plus intéressant (indice 0) au moins intéressant.
		tousLesObjets.sort(comparatorByInterest);

		// Je conserve dans une variable la taille de la liste getBudgets(normalement 3)
		int nbrBudgets = sacADos.getBudgets().length;

		// On cree une liste 'conso' de taille nbrBudgets initalisée à 0.
        // Elle va contenir une consommation par type de cout. Nous ferons attention
        // à ce que la consommation de chaque type de cout reste inférieure au budget
        // associé au type de cout.
		int[] conso = new int[nbrBudgets];
		Arrays.fill(conso, 0);

		// On fais une boucle sur tous les objets triés
		for (ObjetDansSacADos objet : tousLesObjets) {

            // On calcule la nouvelle consommation candidate en ajoutant à la
            // consommation courante les couts associés au projet courant.
			int[] newConso = Utils.addCoordinates(objet.getCouts(), conso);

            // Si la consommation candidate respecte bien tous les budgets,
            // elle devient la consommation courante, et le projet est retenu (i.e,
            // ajouté à la liste des "result").
			if (Utils.allSmaller(newConso, sacADos.getBudgets())) {
				conso = newConso;
				result.add(objet);
			}
		}

		return result;
	}
}

