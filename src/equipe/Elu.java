package equipe;

import java.util.*;

/** Un Elu est une personne. Un Elu à donc un nom, un prénom et un âge. */
public class Elu extends Personne{
	private double benefice;
	private Random random = new Random();

	public Elu (String nom, String prenom, int age) {
		super(nom, prenom, age);
	}
	public void estimer_benefice(Cout cout) {

		/** Simuler un coût réel de manière stochastique. */
		double coutreel = 3000 + random.nextInt(30003); /** tout comme les autres couts on a fixe le cout réel sur un intervalle allant de [1000 à 10000] déterminé de manière aléatoire puisque la consigne demande un processus stochastique*/

		/** coût estimé total par les évaluateurs (voir la classe Evaluateur). */
		double coutestime = cout.getCoutEco() + cout.getCoutSocio() + cout.getCoutEnv();

		/** bénéfice = cout estimé - cout réel (déterminer aléatoirement). */
		this.benefice = coutreel - coutestime;

		System.out.println("Coût total estimé par nos trois évaluateurs : " + coutestime + " € ");
		System.out.println("Coût réel : " + coutreel + " € ");
		System.out.println("Bénéfice estimé par l'élu : " + benefice + " € " + "\n ");
		

	}
	public double getBenefice() {
		return benefice;
	}
	public void setBenefice(double benefice) {
		this.benefice = benefice;
	}
}
