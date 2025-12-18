package sacADos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import solveurGlouton.ObjetInterface;

/**
 * Test unitaire pour la classe SacADos
 * @author feryel benameur
 * @version 1.0
 */
class SacADosTest {
    // Création d'une classe interne pour pouvoir créer des objets car 
	// ObjetDansSacADos est une interface et ne peux donc pas être instancié
	
	/**
	 * Classe interne qui nous permet de créer des objets
	 */
    class Objet implements ObjetInterface {
        private int utilite;
        private int[] couts;

        /**
         * Constucteur qui nous permet de construire des objets
         * @param utilite utilité de l'objet
         * @param couts le tableaux des coûts de l'objet
         */
        Objet(int utilite, int[] couts) {
            this.utilite = utilite;
            this.couts = couts;
        }

        /** 
         * permet d'accéder a l'utilité de l'objet
         * @return l'utilité de l'objet
         */
        @Override
        public int getUtilite() {
            return utilite;
        }
        /**
         * permet d'accéder aux coûts de l'objet
         * @return le tableaux des coûts de l'objets 
         */

        @Override
        public int[] getCouts() {
            return couts;
        }
    }

    /**
	 * Cette méthode utilise la méthode des AAA (Arrange, Act, Assert) afin de vérifier que
	 * nos objets ont bien été ajoutés au sac à dos 
     */
    
	@Test
	void addObjetTest() {
		// Arrange
		int[] budgets = {10};

        List<ObjetInterface> objets = new ArrayList<>();
        Objet o1 = new Objet(6, new int[]{5});
        Objet o2 = new Objet(7, new int[]{8});
        SacADos sac = new SacADos(budgets, objets);
        
        //Act
        objets.add(o1);
        objets.add(o2);
		
        //Assert
		assertEquals(2, sac.getObjets().size()); //car le sac doit contenir 2 objets
        assertTrue(sac.getObjets().contains(o1)); // vérifie que le sac contient bien l'objet o1
        assertTrue(sac.getObjets().contains(o2)); // vérifie que le sac contient bien l'objet o2
	}

}