package equipe;

import java.util.*;

public class Expert extends Personne{
	//chaque expert est spécialisé dans une liste de secteurs que l'on a definit dans notre énumération secteur
	private List <Secteur> secteur;
	//pour faire le processus stochastique
	private Random random;  

	public Expert (String nom, String prenom, int age, List <Secteur> secteur, Random random) {
		super(nom, prenom, age);
		this.secteur = secteur; 
		this.random = random;
	}

	public List<Secteur> getSecteurs() {
		return secteur;
	}

	public void setSecteurs(List<Secteur> secteurs) {
		this.secteur = secteurs;
	}

	public Projet proposerProjet () {
		Secteur secteurchoisi = secteur.get(random.nextInt(secteur.size())); //Un expert est spécialisé dans un secteur aléatoire parmi ceux proposé par l'énoncé
		String titre = "un projet dans le secteur " + secteurchoisi; // génère le titre du projet dans le secteur choisi
		String description = "Projet dans le secteur " + secteurchoisi; //génère la description du projet dans le secteur choisi
		Projet p = new Projet(titre, description, secteurchoisi); //créer/propose le projet
		System.out.println("L'expert "+ getPrenom()+ " " + getNom()+ " propose " + p.getTitre()); //nous renvoie dans la console le projet proposé par tel ou tel expert
		return p; //renvoie le projet
	}
}