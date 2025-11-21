package sacADos;

import java.util.ArrayList;
import java.util.List;

public class Objet {
    public int utilite;
    public List<Integer> couts;
        
    public Objet(int utilite, int coutEconomique, int coutSocial, int coutEnvironnemental) {
    	this.utilite = utilite;
    	this.couts = new ArrayList<>();
    	couts.add(coutEconomique);
    	couts.add(coutSocial);
    	couts.add(coutEnvironnemental);
    }
    
    public int getUtilite() {
    	return utilite;
    }
    
    public void setUtilite(int utilite) {
        this.utilite = utilite;
    }
    
    public List<Integer> getCouts() {
        return couts;
    }
    
    public int getcoutEconomique() {
    	return couts.get(1);
    }
    
    public int coutSocial() {
    	return couts.get(2);
    }
    
    public int coutEnvironnemental() {
    	return couts.get(3);
    }
    

    public void setCouts(int coutEconomique, int coutSocial, int coutEnvironnemental) {
        couts.set(1, coutEconomique);
        couts.set(2, coutSocial);
        couts.set(3, coutEnvironnemental);

    }
}