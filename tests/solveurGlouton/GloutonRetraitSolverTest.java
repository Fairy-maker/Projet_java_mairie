package solveurGlouton;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Test Unitaire de la classe GloutonRetraitSolver
 * @author feryel benameur
 * @version 1.0
 */
class GloutonRetraitSolverTest {

	/**
	 * Création d'une classe interne afin de créer des objets
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
     * Création d'une classe interne sac a dos afin de pouvoir instancier des objets sac a dos
     */
    class Sac implements SacADosInterface {
        private int[] budgets;
        private int dimension;
        List<ObjetInterface> objets;

        /**
         * Constructeur qui nous permet de construire un sac à dos 
         * @param budgets le tableaux des budgets
         * @param dimension dimension du sac a dos 
         * @param objets la list d'objets dans le sac a dos
         */
        Sac(int[] budgets, int dimension, List<ObjetInterface> objets) {
            this.budgets = budgets;
            this.objets = objets;
            this.dimension = dimension;
        }
        
        /**
         * permet d'accéder à la dimension du sac à dos 
         * @return la dimension du sac a dos
         */
        @Override
        public int getDimension() {
            return dimension;
        }

        /**
         * Permet d'accéder au tableaux des budgets du sac a dos 
         * @return le tableaux des budgets du sac a dos 
         */
        @Override
        public int[] getBudgets() {
            return budgets.clone();
        }

        /**
         * permet d'accéder à la list d'objet du sac à dos 
         * @return la liste d'objets du sac a dos 
         */
        @Override
        public List<ObjetInterface> getObjets() {
            return objets;
        }
    }

    /**
	 * Cette méthode utilise la méthode des AAA (Arrange, Act, Assert) afin de vérifier que
	 * la solution conserve uniquement les objets les plus utiles
     * @throws Exception provient de l'exception/erreur généré dans la classe GloutonRetraitSolver
     */
    @Test
    void resoudreTest() throws Exception {
    	
    	//Arrange
        List<ObjetInterface> objets = List.of(
                new Objet(10, new int[]{6}),
                new Objet(8, new int[]{5}),
                new Objet(4, new int[]{3})
        );
        Sac sac1 = new Sac(new int[]{10}, 1, objets);

        // Act
        List<ObjetInterface> result = GloutonRetraitSolver.resoudre(sac1);

        // Calcul du coût total :
        int coutTotal = result.stream().mapToInt(o -> o.getCouts()[0]).sum();

        //Assert
        assertTrue(coutTotal <= 10); // Faux si le coût dépasse la capacité de notre sac

        // Vérifie qu'au moins un objet utile est choisi
        int utiliteTotale = result.stream().mapToInt(ObjetInterface::getUtilite).sum();

        assertTrue(utiliteTotale >= 8); // car la solution doit conserver les objets les plus utiles
    }
    
}
