package equipe;

import java.util.*;

/**
 * Un élu est une personne faisant partie de l'équipe muncipale qui estime le bénéfice 
 * @author feryel benameur
 * @version 1.0
 */
public class Elu extends Personne {

	private final Random random;
	private double benefice;
    private double revenus;

	/**
	 * Constructeur par défaut
	 * @param nom nom de l'élu
	 * @param prenom prénom de l'élu
	 * @param age âge de l'élu
	 * @param random utiliser pour faire le processus stochastique
	 */
	public Elu(String nom, String prenom, int age, Random random) {
		super(nom, prenom, age);
		this.random = random;
        this.benefice = -1;
        this.revenus = -1;
	}
	
	/**
	 * Permet d'estimer le bénéfice d'un projet
	 * @param cout coût d'un projet
	 */
	public void estimerBenefice(Cout cout) {

        /* coût estimé total par les évaluateurs (voir la classe Evaluateur). */
        double coutTotalEstime = cout.getCoutTotal();

        if(this.benefice == -1 || this.revenus == -1) {

            /* Simuler un coût réel de manière stochastique.
             * tout comme les autres couts on a fixe le cout réel sur un intervalle allant de [1000 à 10000]
             * déterminé de manière aléatoire puisque la consigne demande un processus stochastique
             */
            this.revenus = 3000 + random.nextInt(30003);

            /* bénéfice = cout estimé - cout réel (déterminer aléatoirement). */
            this.benefice = revenus - coutTotalEstime;

        }

        /*
         * Renvoie le coût total estimé par nos évaluateurs, le coût réel ainsi que le bénéfice évalué par l'élu
         */
        System.out.println("Coût total estimé par nos trois évaluateurs : " + coutTotalEstime + " € ");
        System.out.println("Coût réel : " + this.revenus + " € ");
        System.out.println("Bénéfice estimé par l'élu : " + this.benefice + " € " + "\n ");

    }
}
