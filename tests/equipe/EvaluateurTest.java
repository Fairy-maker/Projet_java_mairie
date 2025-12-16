package equipe;

import static org.junit.jupiter.api.Assertions.*;


import equipe.Secteur;
import equipe.TypeEvaluationCout;
import equipe.Evaluateur;
import equipe.Projet;
import java.util.Random;

import org.junit.jupiter.api.Test;

class EvaluateurTest {

	@Test
	void TestEvaluerCoutProjet() {
		Projet p = new Projet("CULTURE", "Un projet culturel", Secteur.CULTURE);

        Evaluateur e = new Evaluateur("Jon", "Snow", 33, TypeEvaluationCout.ECONOMIQUE, new Random());
     

        e.evaluerCoutProjet(p);
        
        assertTrue(
        	    p.getCout().getCoutEco() >= 1000 && p.getCout().getCoutEco() <= 10001 );
    }
}
