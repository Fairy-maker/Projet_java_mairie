package equipe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * Test unitaire pour la classe Évaluateur
 * @author feryel benameur
 * @version 1.0
 */
class EvaluateurTest {

	/**
	 * Cette méthode utilise la méthode des AAA (Arrange, Act, Assert) afin de vérifier que
	 * l'évaluateur évalue correctement le coût d'un projet.
	 */
	@Test
	void TestEvaluerCoutProjet() {
		//Arrange
		Projet p = new Projet("CULTURE", "Un projet culturel", Secteur.CULTURE);

        Evaluateur e = new Evaluateur("Jon", "Snow", 33, TypeEvaluationCout.ECONOMIQUE, new Random());
        
        //Act
        e.evaluerCoutProjet(p);
        
        //Assert
        assertTrue(
        	    p.getCout().getCoutEco() >= 1000 && p.getCout().getCoutEco() <= 10001 );
    }
}
