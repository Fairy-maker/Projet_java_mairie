package equipe;

import java.util.*;

/** Un Elu est une personne. Un Elu à donc un nom, un prénom et un âge. */
public class Elu extends Personne {
	
	private double benefice;
	private Random random;

	public Elu(String nom, String prenom, int age, Random random) {
		super(nom, prenom, age);
		this.random = random;
		this.benefice = -1;
	}
	
	public void estimerBenefice(Projet projet) {
		
		if(this.benefice != -1) {
			// Le benefice a deja ete estime
			return;
		}

		/** Simuler un coût réel de manière stochastique. */
		/** tout comme les autres couts on a fixe le cout réel sur un intervalle allant de 
		 * [1000 à 10000] déterminé de manière aléatoire puisque la consigne demande 
		 * un processus stochastique */
		double revenus = 3000 + random.nextInt(30003); 

		/** coût estimé total par les évaluateurs (voir la classe Evaluateur). */
		double coutTotal = projet.getCoutTotal();

		/** bénéfice = cout estimé - cout réel (déterminer aléatoirement). */
		this.benefice = revenus - coutTotal;

		System.out.println("Coût total estimé par nos trois évaluateurs : " + coutTotal + " € ");
		System.out.println("Coût réel : " + revenus + " € ");
		System.out.println("Bénéfice estimé par l'élu : " + benefice + " € " + "\n ");
		
	}
	
	public double getBenefice() {
		return benefice;
	}
		
}
