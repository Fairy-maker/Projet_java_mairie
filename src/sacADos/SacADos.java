package sacADos;

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

    public void resoudre(MethodeDeResolution methodeDeResolution) throws Exception {

        switch (methodeDeResolution) {

            case GLOUTON_A_AJOUT:

                // Solveur glouton
                List<ObjetInterface> solution =
                        GloutonAjoutSolver.resoudre(this);

                System.out.println("\n------- Solution gloutonne -------\n");
                for (ObjetInterface o : solution)
                    System.out.println(o);

                System.out.println("Utilite totale de la solution est : " +
                        Utils.utilite(solution));

                return;

            case GLOUTON_A_RETRAIT:

                // Solveur glouton
                List<ObjetInterface> solutionRetrait =
                        GloutonRetraitSolver.resoudre(this);

                System.out.println("\n------- Solution gloutonne a retrait -------\n");
                for (ObjetInterface o : solutionRetrait)
                    System.out.println(o);

                System.out.println("Utilite totale de la solution est : " +
                        Utils.utilite(solutionRetrait));

                return;

            case HILL_CLIMBING_SIMPLE:

                List<ObjetInterface> solutionInitiale =
                        GloutonRetraitSolver.resoudre(this);

                List<ObjetInterface> solutionFinale1 = HillClimbingSolver.resoudre(this,  Arrays.asList(solutionInitiale));

                System.out.println("\n------- Solution hill climbing -------\n");
                for (ObjetInterface o : solutionFinale1)
                    System.out.println(o);

                System.out.println("Utilite totale de la solution est : " +
                        solutionFinale1.stream().mapToInt(ObjetInterface::getUtilite).sum());

                return;

            case HILL_CLIMBING_MULTIPLE:

                List<ObjetInterface> solutionInitiale1 =
                        GloutonAjoutSolver.resoudre(this);

                List<ObjetInterface> solutionInitiale2 =
                        GloutonRetraitSolver.resoudre(this);

                List<List<ObjetInterface>> solutionsInitiales = Arrays.asList(solutionInitiale1, solutionInitiale2);
                List<ObjetInterface> solutionFinale2 = HillClimbingSolver.resoudre(this,  solutionsInitiales);

                System.out.println("\n------- Solution hill climbing -------\n");
                for (ObjetInterface o : solutionFinale2)
                    System.out.println(o);

                System.out.println("Utilite totale de la solution est : " +
                        solutionFinale2.stream().mapToInt(ObjetInterface::getUtilite).sum());

                return;


        }


    }

}
	
