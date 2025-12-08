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

    public void resoudre() throws Exception {

        // Solveur glouton
        SortByInterest comparator = new SortByInterest();
        List<ObjetDansSacADos> solution =
                GloutonAjoutSolver.resolutionParMethodeGloutonne(this, comparator);

        System.out.println("\n------- Solution gloutonne -------\n");
        for (ObjetDansSacADos o : solution)
            System.out.println(o);

        System.out.println("Utilite totale de la solution est : " +
                solution.stream().mapToInt(ObjetDansSacADos::getUtilite).sum());

    }

}
	
