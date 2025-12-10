package sacADos;

import java.util.List;
import java.util.ArrayList;
import solveurGlouton.*;


public class SacADosImpl implements solveurGlouton.SacADos {

    private int[] budgets;
    private List<ObjetDansSacADos> objets = new ArrayList<>();

    public SacADosImpl(int[] budgets) {
        this.budgets = budgets.clone(); // on clone le tableau budget pour ne pas etre impacté par une modification ultérieure faite a l'exterieur
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
    public List<ObjetDansSacADos> getObjets() { 
    	return objets; 
    }

    public void add(ObjetDansSacADos o) { 
    	objets.add(o); 
    }

    public int getUtiliteTotale() {
        int total = 0;
        for (ObjetDansSacADos o : objets) total += o.getUtilite();
        return total;
    }

    public void resoudre(MethodeDeResolution methodeDeResolution) throws Exception {

        switch (methodeDeResolution) {

            case GLOUTON_A_AJOUT:

                // Solveur glouton
                List<ObjetDansSacADos> solution =
                        GloutonAjoutSolver.resoudre(this);

                System.out.println("\n------- Solution gloutonne -------\n");
                for (ObjetDansSacADos o : solution)
                    System.out.println(o);

                System.out.println("Utilite totale de la solution est : " +
                        Utils.utilite(solution));

                return;

            case GLOUTON_A_RETRAIT:
                // TODO/A coder
                return;

            case HILL_CLIMBING:

                List<ObjetDansSacADos> solutionInitiale =
                        GloutonAjoutSolver.resoudre(this);

                List<ObjetDansSacADos> solutionFinale = HillClimbingSolver.resoudre(this, solutionInitiale);

                System.out.println("\n------- Solution hill climbing -------\n");
                for (ObjetDansSacADos o : solutionFinale)
                    System.out.println(o);

                System.out.println("Utilite totale de la solution est : " +
                        solutionFinale.stream().mapToInt(ObjetDansSacADos::getUtilite).sum());

                return;

        }


    }

}
	
