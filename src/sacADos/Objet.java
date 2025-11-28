package sacADos;
import java.util.ArrayList;

import java.util.List;
import equipe.Cout;

public class Objet {
	  private int utilite;
	    private int[] couts; // tableau de dimension k

	    public Objet(int utilite, int[] couts) {
	        this.utilite = utilite;
	        this.couts = couts.clone();
	    }

	    public int getUtilite() { return utilite; }
	    public int[] getCouts() { return couts.clone(); }

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
