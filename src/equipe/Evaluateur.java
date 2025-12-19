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
	
	public Evaluateur(String nom, String prenom, int age, TypeEvaluationCout type, Random random) {
		super(nom, prenom, age);
		this.type = type;
		this.random = random;
	}    

	/**
	 * Méthode qui permet aux évaluateur d'évaluer le coût en fonction du type auxquels ils sont "spécialisés".
	 * Un évaluateur économique va évaluer le coût économique,
	 * Un évaluateur social va évaluer le coût social,
	 * Un évaluateur environnemental va évaluer le coût environnemental.
	 * @param p est un projet p
	 */
	public void evaluerCoutProjet(Projet p) {
		// si l'évaluateur est  de type économique il évalue le premier bloc,
		// s'il est de type social il évalue le deuxième etc..
		switch (this.type) {
		
		case ECONOMIQUE:
			
			p.getCout().setCoutEco(5000 + random.nextInt(10000));
			break;

		case SOCIAL:
			// Pour avoir un coût social entre 5000 et 10000
			p.getCout().setCoutSocio(5000 + random.nextInt(10000));
			break;

		case ENVIRONNEMENT:
			// pour avoir un coût environnemental entre 5000 et 10000
			p.getCout().setCoutEnv(5000 + random.nextInt(10000));
			break;
			
		}

	}

}