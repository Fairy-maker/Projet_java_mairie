package sacADos;


import java.util.List;
import java.util.ArrayList;
import equipe.Cout;
import solveur_glouton.ObjetDansSacADos;



public class SacADos {
	private int dimension; 
    private int[] budget; 
    private List<ObjetDansSacADos> objets; 
	
    public SacADos(int dimension, int[] budget) {
        this.dimension = dimension; 
        this.budget = budget; 
        this.objets = new ArrayList<>();
    }
	
    public int getDimension() {
        return dimension;
    }
    
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    

    public int[] getBudget() {
		return budget;
	}

	public void setBudget(int[] budget) {
		this.budget = budget;
	}
    
    public List<ObjetDansSacADos> getObjets() {
        return objets;
    }
    
    
    public int getUtiliteTotale() {
        int total = 0;
        for (ObjetDansSacADos o : objets) {
            total += o.getUtilite();
        }
        return total;
    }

}
