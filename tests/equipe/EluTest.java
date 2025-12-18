package equipe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

/** Test unitaire pour la classe Elu
 * @author feryel benameur
 * @version 1.0
 */
class EluTest { 

	/**
	 * Cette méthode utilise la méthode des AAA (Arrange, Act, Assert) afin de vérifier que l'élu estime correctement un bénéfice.
	 */
	@Test
	void estimerBeneficeTest() {
		
		// Arrange
		Projet p = new Projet("CULTURE", "Un projet culturel", Secteur.CULTURE);
		p.getCoutTotal();
		
		Elu elu = new Elu ("Martin","Bernard", 20, new Random());
		
		// Act
		elu.estimerBenefice(p);
		int benef = p.getBenefice();

		//Assert
        assertTrue(benef >= 0 && benef < 1000);
	}

}
