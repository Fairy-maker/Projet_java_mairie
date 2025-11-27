package equipe;

import java.util.*;

/** Un Elu est une personne. Un Elu à donc un nom, un prénom et un âge. */
public class Elu extends Personne{
	private Random random;
	private double benefice;

	public Elu (String nom, String prenom, int age, Random random) {
		super(nom, prenom, age);
		this.random = random;
	}
	public void estimerBenefice(Cout cout) {

		/** Simuler un coût réel de manière stochastique. */
		int revenus = 3000 + random.nextInt(30003); /** tout comme les autres couts on a fixe le cout réel sur un intervalle allant de [1000 à 10000] déterminé de manière aléatoire puisque la consigne demande un processus stochastique*/

		/** coût estimé total par les évaluateurs (voir la classe Evaluateur). */
		double coutTotalEstime = cout.getCoutTotal();

		/** bénéfice = cout estimé - cout réel (déterminer aléatoirement). */
		this.benefice = revenus - coutTotalEstime;

	

		System.out.println("Coût total estimé par nos trois évaluateurs : " + coutTotalEstime + " € ");
		System.out.println("Coût réel : " + revenus + " € ");
		System.out.println("Bénéfice estimé par l'élu : " + benefice + " € " + "\n ");
		
	}
}
