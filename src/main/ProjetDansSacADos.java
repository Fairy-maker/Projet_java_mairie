package main;

import equipe.Projet;
import equipe.Cout;
import solveur_glouton.ObjetDansSacADos;

public class ProjetDansSacADos implements ObjetDansSacADos {

	private Projet projet;
	
	public ProjetDansSacADos(Projet projet) {
		this.projet = projet;
	}
	
	// On implemente l'interface ObjetDansSacADos facilement grace au projet
	
	public int getUtilite() {
		return this.projet.getBenefice();
	}

	public int[] getCouts() {
		Cout cout = this.projet.getCout();
		int[] couts = new int[3];
		couts[0] = cout.getCoutEco();
		couts[1] = cout.getCoutSocio();
		couts[2] = cout.getCoutEnv();
		return couts;	
	}

}
