package sacADos;

import solveurGlouton.ObjetInterface;

public class Objet implements ObjetInterface {

    private int utilite;
    private  int[] couts;

    public Objet(int utilite, int[] couts) {
        this.couts = couts;
        this.utilite = utilite;
    }

    @Override
    public int getUtilite() {
        return utilite;
    }

    @Override
    public int[] getCouts() {
        return couts;
    }
}
