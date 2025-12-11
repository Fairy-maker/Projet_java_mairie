package equipe;

import java.util.*;

/**
 * Un évaluateur est une personne qui détermine un type de coût
 * @author feryelbenameur
 * @version 1.0
 */
public class Evaluateur extends Personne {
	
	private final TypeEvaluationCout type;
	private final Random random;

	/**
	 * Constructeur qui nous permet de définir un évaluateur
	 * @param nom nom de l'évaluateur
	 * @param prenom prénom de l'évaluateur
	 * @param age âge de l'évaluateur
	 * @param type type de coût dans lequel l'évaluateur est spécialisé
	 * @param random random nous permet de générer le processus stochastique
	 */
	
	public Evaluateur(String nom, String prenom, int age, TypeEvaluationCout type, Random random) { // Notre constructeur
		super(nom, prenom, age);
		this.type = type;
		this.random = random;
	}    

	/**
	 * Méthode qui permet aux évaluateur d'évaluer le coûts en fonction du type auxquelles ils sont "spécialisés".
	 * Un évaluateur économique va évaluer le coût économique
	 * Un évaluateur social va évaluer le coût social
	 * Un évaluateur environnemental va évaluer le coût environnemental
	 * @param p est un projet p
	 */
	public void evaluerCoutProjet(Projet p) {
		// si l'évaluateur est type économique il évalue le premier bloc,
		// s'il est de type social il évalue le deuxième etc..
		switch (this.type) {
		
		case ECONOMIQUE:
			// Pour avoir un cout économique entre 1000 et 10000 (on ne veut pas de cout économique 
			// en dessous de 1000 car on se dit que les projets qui concernent les villes sont 
			// souvent de grands projets qui ont un cout economique assez élevé)
			p.getCout().setCoutEco(1000 + random.nextInt(10001));
			break;

		case SOCIAL:
			// Pour avoir un coût social entre 100 et 1000
			p.getCout().setCoutSocio(100 + random.nextInt(901)); 
			break;

		case ENVIRONNEMENT:
			// pour avoir un coût environnemental entre 50 et 500
			p.getCout().setCoutEnv(50 + random.nextInt(451));
			break;
			
		}

	}

}