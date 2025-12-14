package sacADos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import solveurGlouton.*;

import java.util.ArrayList;
import java.util.List;

class SacADosTest {
    // Création d'une classe interne pour pouvoir créer des objets car ObjetDansSacADos est une interface et ne peux donc pas être instancié
    class Objet implements ObjetInterface {
        private int utilite;
        private int[] couts;

        Objet(int utilite, int[] couts) {
            this.utilite = utilite;
            this.couts = couts;
        }

        @Override
        public int getUtilite() {
            return utilite;
        }

        @Override
        public int[] getCouts() {
            return couts;
        }
    }

	@Test
	void addObjetTest() {
		int[] budgets = {10};

        List<ObjetInterface> objets = new ArrayList<>();
        Objet o1 = new Objet(6, new int[]{5});
        Objet o2 = new Objet(7, new int[]{8});
        objets.add(o1);
        objets.add(o2);
		SacADos sac = new SacADos(budgets, objets);

		assertEquals(2, sac.getObjets().size()); //car le sac doit contenir 2 objets
        assertTrue(sac.getObjets().contains(o1));
        assertTrue(sac.getObjets().contains(o2));
	}

}