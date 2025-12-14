package main;

import equipe.Projet;
import equipe.Cout;
import solveurGlouton.ObjetInterface;

public class ProjetDansSacADos implements ObjetInterface {

	private Projet projet;

    public ProjetDansSacADos(Projet projet) {
        this.projet = projet;
    }

    @Override
    public int getUtilite() {
        return projet.getBenefice();
    }

    @Override
    public int[] getCouts() {
        Cout cout = projet.getCout();
        return new int[]{ cout.getCoutEco(), cout.getCoutSocio(), cout.getCoutEnv() };
    }

    @Override
    public String toString() {
        return projet.toString();
    }
}

