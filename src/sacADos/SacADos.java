package sacADos;

import java.util.List;
import java.util.ArrayList;

public class SacADos {
	public int dimension; 
	public int budget; 
	public List<Objet> objets; 
	
	public SacADos(int dimension, int budget) {
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
    
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    
    public List<Objet> getObjet() {
        return objets;
    }

    public boolean ajouterObjet(Objet o) {
    	if (objets.size() < dimension) {
    		objets.add(o);
    		return true;
    	}
    	return false;
    }
    
    public int getUtiliteTotale() {
    	int total = 0;
    	for (Objet o : objets) {
    		total += o.getUtilite();
    	}
    	return total;
    }
    
    public int getCoutTotale() {
    	int total = 0;
    	for (Objet o : objets) {
    		total += o.getCout();
    	}
    	return total;
    }
}
