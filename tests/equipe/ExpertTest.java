package equipe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * Test Unitaire pour la classe expert
 * @author feryel benameur
 * @version 1.0
 */

class ExpertTest {
	
	/**
	 * Cette méthode utilise la méthode des AAA (Arrange, Act, Assert) afin de vérifier que
	 * l'expert propose bien des projets
	 */
	@Test
	void proposerProjetTest() {
		//Arrange
		List<Secteur> secteurs = List.of(Secteur.CULTURE);
		Expert ex = new Expert ("Kayn", "Georges", 24,secteurs,new Random());
		
		//Act
		Projet p = ex.proposerProjet();
		
		//Assert
		assertNotNull(p); // verifie que la méthode ne retourne pas null et donc qu'un expert propose bien un projet
		
	}

}
