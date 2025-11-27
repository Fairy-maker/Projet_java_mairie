package equipe;

import java.util.*;

public class Evaluateur extends Personne {
	
	private TypeEvaluationCout type;
	private Random random; // Nous permet de générer le processus stochastique

	public Evaluateur(String nom, String prenom, int age, TypeEvaluationCout type, Random random) { // Notre constructeur
		super(nom, prenom, age);
		this.type = type;
		this.random = random;
	}    
	
	public TypeEvaluationCout getType() {
		return type;
	}
	
	/** Les évaluateurs évaluent le coût du projet en fonction de leur domaine. 
	 * En effet, un évaluateur va évaluer un cout économique s'il est
	 *  spécialisé dans l'économie */
	/**@param Projet p est un projet p */
	public void evaluerCoutProjet(Projet p) {
		// si l'évaluteur est type économique il évalue le premier bloc,
		// s'il est de type social il évalue le deuxième etc..
		switch (this.type) {
		
		case ECONOMIQUE:
			// Pour avoir un cout économique entre 1000 et 10000 (on ne veut pas de cout économique 
			// en dessous de 1000 car on se dit que les projets qui concernent les villes sont 
			// souvent de grands projets qui ont un cout economique assez élevé
			p.getCout().setCoutEco(1000 + random.nextInt(10001));
			break;

		case SOCIAL:
			// Pour avoir un coût social entre 1000 et 10000
			p.getCout().setCoutSocio(100 + random.nextInt(901)); 
			break;

		case ENVIRONNEMENT:
			// pour avoir un coût environnemental entre 1000 et 10000
			p.getCout().setCoutEnv(50 + random.nextInt(451));
			break;
			
		}

	}
	
	//public void renseigner_cout_projet(Projet p){
	//	evaluerCoutProjet(p); 
	//}
}