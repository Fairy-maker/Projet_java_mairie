package solveurGlouton;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;


class GloutonRetraitSolverTest {

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

    class Sac implements SacADosInterface {
        private int[] budgets;
        private int dimension;
        List<ObjetInterface> objets;

        Sac(int[] budgets, int dimension, List<ObjetInterface> objets) {
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
        public List<ObjetInterface> getObjets() {
            return objets;
        }
    }

    @Test
    void resoudreTest() throws Exception {
        List<ObjetInterface> objets = List.of(
                new Objet(10, new int[]{6}),
                new Objet(8, new int[]{5}),
                new Objet(4, new int[]{3})
        );
        Sac sac1 = new Sac(new int[]{10}, 1, objets); // sac ayant une dimension de 6, un tableau de budgets de 7 et nos objets

        List<ObjetInterface> result = GloutonRetraitSolver.resoudre(sac1);

        // Calcul du coût total :
        int coutTotal = result.stream().mapToInt(o -> o.getCouts()[0]).sum();

        assertTrue(coutTotal <= 10); // Faux si le coût dépasse la capacité de notre sac

        // Vérifie qu'au moins un objet utile est choisi
        int utiliteTotale = result.stream().mapToInt(ObjetInterface::getUtilite).sum();

        assertTrue(utiliteTotale >= 8); // car la solution doit conserver les objets les plus utiles
    }


}
