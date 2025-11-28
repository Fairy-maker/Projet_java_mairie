package sacADos;
import java.util.List;

import java.util.ArrayList;
import equipe.Cout;
import solveur_glouton.ObjetDansSacADos;
import solveur_glouton.SacADos;
import java.util.List;


public class SacADosImpl implements solveur_glouton.SacADos {
	private int dimension;
    private int[] budgets;
    private List<ObjetDansSacADos> objets = new ArrayList<>();

    public SacADosImpl(int dimension, int[] budgets) {
        this.dimension = dimension;
        this.budgets = budgets.clone();
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
}
	
