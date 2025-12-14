package solveurGlouton;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import solveurGlouton.GloutonRetraitSolverTest.Objet;
import solveurGlouton.GloutonRetraitSolverTest.Sac;

class HillClimbingSolverTest {
	class Objet implements ObjetDansSacADos {
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
	class Sac implements SacADos{
		private int[] budgets;
		private int dimension;
		List<ObjetDansSacADos> objets;

		Sac(int[] budgets, int dimension, List<ObjetDansSacADos> objets){
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
			public List<ObjetDansSacADos> getObjets(){
				return objets;
			}
		}
	
	@Test
	void resoudreTest() throws Exception {
		List<ObjetDansSacADos> objets = List.of(
				new Objet(10,new int[]{6}),
				new Objet(8,new int[]{5}),
				new Objet(4,new int[]{3})
				);
				Sac sac2 = new Sac(new int[]{10}, 1,objets);
				
				List<ObjetDansSacADos> solutionInitial = List.of(new Objet(4, new int[] {5})); // mauvaise solution initiale

		        List<ObjetDansSacADos> result = HillClimbingSolver.resoudre(sac2, new ArrayList<>(solutionInitial));

		        int utiliteSolutionInitiale = 4;
		        int utiliteFinale = result.stream().mapToInt(ObjetDansSacADos::getUtilite).sum();

		        assertTrue(utiliteFinale >= utiliteSolutionInitiale); //Hill Climbing doit améliorer ou conserver l'utilité
		    
		
	}

}
