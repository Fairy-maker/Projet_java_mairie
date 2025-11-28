package main;

import equipe.Projet;
import equipe.Cout;
import solveur_glouton.ObjetDansSacADos;
import equipe.Cout;
import solveur_glouton.ObjetDansSacADos;

public class ProjetDansSacADos implements ObjetDansSacADos {

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
