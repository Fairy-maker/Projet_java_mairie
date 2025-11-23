package equipe;

import java.util.*;

public class Expert extends Personne {
	
	// Chaque expert est spécialisé dans une liste de secteurs que l'on a definit dans notre énumération secteur
	private List<Secteur> secteurs; 
	private Random random;  //pour faire le processus stochastique

	public Expert(String nom, String prenom, int age, List<Secteur> secteurs, Random random) {
		super(nom, prenom, age);
		this.secteurs = secteurs; 
		this.random = random;
	}

	public List<Secteur> getSecteurs() {
		return secteurs;
	}

	public Projet proposerProjet() {
		Secteur secteurChoisi = secteurs.get(random.nextInt(secteurs.size())); //Un expert est spécialisé dans un secteur aléatoire parmi ceux proposé par l'énoncé
		String titre = "un projet dans le secteur " + secteurChoisi; // génère le titre du projet dans le secteur choisi
		String description = "Projet dans le secteur " + secteurChoisi; //génère la description du projet dans le secteur choisi
		Projet p = new Projet(titre, description, secteurChoisi); //créer/propose le projet
		System.out.println("L'expert "+ getPrenom()+ " " + getNom()+ " propose " + p.getTitre()); //nous renvoie dans la console le projet proposé par tel ou tel expert
		return p; //renvoie le projet
	}
}