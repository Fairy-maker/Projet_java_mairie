package equipe;
import java.util.List;

import solveur_glouton.SacADos;
import sacADos.Objet ;

import java.util.ArrayList;

public class VersSacADos {
	public static SacADos convertir(List<Projet> projets, int dimension, int budget) {

		SacADos sac = new sacADos(dimension, budget); 

		for (Projet p : projets) {
			Objet o = new Objet(
					p.getCoutTotal();
					);
			sac.ajouterObjet(o);
		}

		return sac;
	}


}
