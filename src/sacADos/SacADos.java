package sacADos;

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
                // TODO/A coder
                return;

            case HILL_CLIMBING:

                List<ObjetInterface> solutionInitiale =
                        GloutonAjoutSolver.resoudre(this);

                List<ObjetInterface> solutionFinale = HillClimbingSolver.resoudre(this, solutionInitiale);

                System.out.println("\n------- Solution hill climbing -------\n");
                for (ObjetInterface o : solutionFinale)
                    System.out.println(o);

                System.out.println("Utilite totale de la solution est : " +
                        solutionFinale.stream().mapToInt(ObjetInterface::getUtilite).sum());

                return;

        }


    }

}
	
