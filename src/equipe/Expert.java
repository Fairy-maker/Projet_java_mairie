package equipe;

import java.util.*;
 
public class Expert extends Personne{
	private List <Secteur> secteur;
	
	public Expert (String nom, String prenom, int age, List <Secteur> secteur) {
		super(nom, prenom, age);
		this.secteur = secteur;
	}

	public Projet proposer_projet () {
		Secteur secteurchoisi = secteur;
		String titre = titre;
		String description = description; 
		int benefice = benefice; 
		Cout cout = new Cout();
	return new Projet (titre, description,benefice,secteurchoisi, cout);
	}
}