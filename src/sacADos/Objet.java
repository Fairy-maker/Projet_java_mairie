package sacADos;

import solveurGlouton.*;

public class Objet implements ObjetDansSacADos {

    private final int utilite;
    private final int[] couts;

    public Objet(int utilite, int[] couts) {
        this.utilite = utilite;
        this.couts = couts;
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
