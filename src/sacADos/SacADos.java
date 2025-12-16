package sacADos;

import java.rmi.UnexpectedException;
import java.util.Arrays;
import java.util.List;

import solveurGlouton.*;


public class SacADos implements SacADosInterface {

    private final int[] budgets;
    private final List<ObjetInterface> objets;

    public SacADos(int[] budgets, List<ObjetInterface> objets) {
        this.budgets = budgets.clone(); // on clone le tableau budget pour ne pas etre impacté par une modification ultérieure faite a l'exterieur
        this.objets = objets;
    }

    @Override
    public int getDimension() {
        return this.budgets.length;
    }

    @Override
    public int[] getBudgets() {
        return budgets.clone();
    }

    @Override
    public List<ObjetInterface> getObjets() {
        return objets;
    }

    public int getUtiliteTotale() {
        int total = 0;
        for (ObjetInterface o : objets) total += o.getUtilite();
        return total;
    }

    public List<ObjetInterface> resoudre(MethodeDeResolution methodeDeResolution) throws Exception {

        switch (methodeDeResolution) {

            case GLOUTON_A_AJOUT:

                return GloutonAjoutSolver.resoudre(this);

            case GLOUTON_A_RETRAIT:

                return GloutonRetraitSolver.resoudre(this);

            case HILL_CLIMBING_SIMPLE:

                List<ObjetInterface> solutionInitiale =
                        GloutonRetraitSolver.resoudre(this);

                return HillClimbingSolver.resoudre(this, Arrays.asList(solutionInitiale));

            case HILL_CLIMBING_MULTIPLE:

                List<ObjetInterface> solutionInitiale1 =
                        GloutonAjoutSolver.resoudre(this);

                List<ObjetInterface> solutionInitiale2 =
                        GloutonRetraitSolver.resoudre(this);

                List<List<ObjetInterface>> solutionsInitiales = Arrays.asList(solutionInitiale1, solutionInitiale2);

                return HillClimbingSolver.resoudre(this, solutionsInitiales);

        }

        throw new UnexpectedException("La cas n'est pas connu");

    }

}
	
