package equipe;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import java.util.Random; 

class EluTest {

	@Test
	void estimerBeneficeTest() {
		Projet p = new Projet("CULTURE", "Un projet culturel", Secteur.CULTURE);
		p.getCoutTotal();
		
		Elu elu = new Elu ("Martin","Bernard", 20, new Random());
		
		elu.estimerBenefice(p);
		int benef = p.getBenefice();

        assertTrue(benef >= 0 && benef < 1000);
	}

}
