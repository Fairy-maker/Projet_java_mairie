package equipe;

import java.util.ArrayList;
import java.util.List;
import equipe.Cout;

public class Objet {
    public int utilite;
    public List<Integer> cout;
        
    public Objet(int utilite, int coutEco, int coutSocio, int coutEnv) {
    	this.utilite = utilite;
    	this.cout = new ArrayList<>();
    	cout.add(coutEco);
    	cout.add(coutSocio);
    	cout.add(coutEnv);
    }
    
    public int getUtilite() {
    	return utilite;
    }
    
    public void setUtilite(int utilite) {
        this.utilite = utilite;
    }
    
    public List<Integer> getCouts() {
        return cout;
    }
    
    public int getcoutEco() {
    	return cout.get(0);
    }
    
    public int getcoutSoco() {
    	return cout.get(1);
    }
    
    public int getcoutEnv() {
    	return cout.get(2);
    }
  
    public void setCouts(int coutEco, int coutSoco, int coutEnv) {
    	cout.set(0, coutEco);
    	cout.set(1, coutSoco);
    	cout.set(2, coutEnv);
    }
}
