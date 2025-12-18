package equipe;

import java.util.*;

/**
 * Un élu est une personne faisant partie de l'équipe muncipale qui estime le bénéfice.
 * @author feryel benameur
 * @version 1.0
 */
public class Elu extends Personne {

	private final Random random;

	/**
	 * Constructeur qui nous permet de construire un élu 
	 * @param nom nom de l'élu
	 * @param prenom prénom de l'élu
	 * @param age âge de l'élu
	 * @param random utiliser pour faire le processus stochastique
	 */
	public Elu(String nom, String prenom, int age, Random random) {
		super(nom, prenom, age);
		this.random = random;
	}

	/**
	 * Permet d'estimer le bénéfice d'un projet
	 * @param p Le projet dont il faut évaluer le bénéfice
	 */
	public void estimerBenefice(Projet p) {
        p.setBenefice(random.nextInt(1000));
    }
}
