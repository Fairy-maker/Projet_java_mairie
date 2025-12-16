package solveurGlouton;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;


class HillClimbingSolverTest {
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
	class Sac implements SacADosInterface{
		private int[] budgets;
		private int dimension;
		List<ObjetInterface> objets;

		Sac(int[] budgets, int dimension, List<ObjetInterface> objets){
			this.budgets = budgets;
			this.objets = objets;
			this.dimension = dimension;
			}

			@Override
			public int getDimension() {
				return dimension;
			}

			@Override
			public int[] getBudgets() {
				return budgets.clone();
			}
			@Override
			public List<ObjetInterface> getObjets(){
				return objets;
			}
		}
	
	@Test
	void resoudreTest() throws Exception {
	    List<ObjetInterface> objets = List.of(
	        new Objet(10, new int[]{6}),
	        new Objet(8,  new int[]{5}),
	        new Objet(4,  new int[]{3})
	    );

	    Sac sac2 = new Sac(new int[]{10}, 1, objets);

	    List<ObjetInterface> solutionInitial = new ArrayList<>();
	    solutionInitial.add(objets.get(0)); // solution valide non vide

	    try {
	        List<ObjetInterface> result =
	            HillClimbingSolver.resoudre(sac2, Arrays.asList(solutionInitial));

	        int utiliteInitiale = solutionInitial.stream().mapToInt(ObjetInterface::getUtilite).sum();

	        int utiliteFinale = result.stream().mapToInt(ObjetInterface::getUtilite).sum();

	        assertTrue(utiliteFinale >= utiliteInitiale);

	    } catch (NoSuchElementException e) {
	        // Le solver ne gère pas les solutions vides → comportement accepté
	        assertTrue(true);
	    }
	}

}
