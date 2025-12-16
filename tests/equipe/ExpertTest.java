package equipe;

import static org.junit.jupiter.api.Assertions.*;
import equipe.Expert;
import equipe.Secteur;
import equipe.Projet;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class ExpertTest {

	@Test
	void proposerProjetTest() {
		List<Secteur> secteurs = List.of(Secteur.CULTURE);
		Expert ex = new Expert ("Kayn", "Georges", 24,secteurs,new Random());
		
		Projet p = ex.proposerProjet();
		
		assertNotNull(p); // verifie donc que la méthode ne retourne pas null et donc qu'un expert propose bien un projet
		
	}

}
