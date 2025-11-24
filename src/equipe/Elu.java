package equipe;

import java.util.*;

/** Un Elu est une personne. Un Elu à donc un nom, un prénom et un âge. */
public class Elu extends Personne {
	
	private Random random;

	public Elu(String nom, String prenom, int age, Random random) {
		super(nom, prenom, age);
		this.random = random;
	}
	
	public void estimerBenefice(Projet projet) {
		
		/** Simuler un coût réel de manière stochastique. */
		/** tout comme les autres couts on a fixe le cout réel sur un intervalle allant de 
		 * [1000 à 10000] déterminé de manière aléatoire puisque la consigne demande 
		 * un processus stochastique */
		int revenus = 3000 + random.nextInt(30003); 

		/** coût estimé total par les évaluateurs (voir la classe Evaluateur). */
		int coutTotal = projet.getCoutTotal();

		/** bénéfice = cout estimé - cout réel (déterminer aléatoirement). */
		int benefice = revenus - coutTotal;
		
		projet.setBenefice(benefice);

		System.out.println("Coût total estimé par nos trois évaluateurs : " + coutTotal + " € ");
		System.out.println("Revenus estimés par l'Elu : " + revenus + " € ");
		System.out.println("Bénéfice : " + benefice + " € " + "\n ");
		
	}
	
}
