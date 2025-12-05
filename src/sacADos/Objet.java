package sacADos;
import java.util.ArrayList;

import java.util.List;
import equipe.Cout;

public class Objet {
	  private int utilite;
	    private int[] couts; // tableau de dimension k

	    public Objet(int utilite, int[] couts) {
	        this.utilite = utilite;
	        // on utilise clone pour cloner le tableau. C'est une méthode qui provient de la classe Object en java 
	        // la référence sur ce site : https://perso.telecom-paristech.fr/hudry/coursJava/avance/dupliquer.html
	        this.couts = couts.clone(); 
	    }

	    public int getUtilite() { 
	    	return utilite; 
	    	}
	    // renvoie une copie du tableau
	    public int[] getCouts() { 
	    	return couts.clone(); 
	    	}
	    // methode qui nous permets d'accéder directement à une case de notre tableau. En effet idx corresponds à l'index de l'élément dans notre tableau
	    public int getCoutAt(int idx) {
	        return couts[idx];
	    }

	    public void setCouts(int coutEco, int coutSocio, int coutEnv) {
	        this.couts[0] = coutEco;
	        this.couts[1] = coutSocio;
	        this.couts[2] = coutEnv;
	    }

	    @Override
	    public String toString() {
	        return "Objet[utilite=" + utilite + ", couts=" + java.util.Arrays.toString(couts) + "]";
	    }
	}
