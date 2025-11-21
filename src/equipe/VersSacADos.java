package equipe;

import java.util.List;

import sacADos.Objet;
import sacADos.SacADos;

import java.util.ArrayList;

public class VersSacADos {
	
	public static SacADos convertir(List<Projet> projets, int dimension, int budget) {
		
		SacADos sac = new SacADos(dimension, budget); 
		
		for (Projet p : projets) {
			Objet o = new Objet(p.getUtilite(), p.getCount());
			sac.ajouterObjet(o);
		}
		
		return sac
	}
}
