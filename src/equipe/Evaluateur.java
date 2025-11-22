package equipe;

import java.util.*;

public class Evaluateur extends Personne {
	private TypeEvaluationCout type;
	private Random random = new Random(); // Nous permet de générer le processus stochastique

	public Evaluateur(String nom, String prenom, int age, TypeEvaluationCout type) { // Notre constructeur
		super(nom, prenom, age);
		this.type = type;

	}    
	public TypeEvaluationCout getType() {
		return type;
	}
	public void setType(TypeEvaluationCout type) {
		this.type = type;
	}

	/**@param Projet p est un projet p */
	public void evalue_cout_projet(Projet p) { // Les évaluateurs évaluent le coût du projet en fonction de leur domaine. En effet, un évaluateur va évaluer un cout économique s'il est spécialisé dans l'économie
		switch (type) { // si l'évaluteur est type économique il évalue le premier bloc, s'il est de type social il évalue le deuxième etc..
		case ECONOMIQUE:
			p.getCout().setCoutEco(1000 + random.nextInt(10001)); // Pour avoir un cout économique entre 1000 et 10000 (on ne veut pas de cout économique en dessous de 1000 car on se dit que les projets qui concernent les villes sont souvent de grands projets qui ont un cout economique assez élevé
			break;

		case SOCIAL:
			p.getCout().setCoutSocio(100 + random.nextInt(901)); // Pour avoir un coût social entre 1000 et 10000
			break;

		case ENVIRONNEMENT:
			p.getCout().setCoutEnv(50 + random.nextInt(451)); // pour avoir un coût environnemental entre 1000 et 10000
			break;
		}

	}
	public void renseigner_cout_projet(Projet p){
		evalue_cout_projet(p); 

	}
}