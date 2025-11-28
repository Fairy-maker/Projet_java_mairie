package sacADos;
import java.util.ArrayList;
import java.util.List;
import equipe.Cout;

public class Objet {
	public int utilite;
    public int[] cout;
        
    public Objet(int utilite, int[] cout) {
    	this.utilite = utilite;
    	this.cout = cout;
    }
    
    public int getUtilite() {
    	return utilite;
    }
        
    public int[] getCouts() {
        return cout;
    }

    public int getcoutEco() {
    	return cout[0];
    }
    
    public int getcoutSocio() {
    	return cout[1];
    }
    
    public int getcoutEnv() {
    	return cout[2];
    }
  
    public void setCouts(int coutEco, int coutSoco, int coutEnv) {
    	cout[0] = getcoutEco();
    	cout[1] = getcoutSocio();
    	cout[2] = getcoutEnv();
        }

}
