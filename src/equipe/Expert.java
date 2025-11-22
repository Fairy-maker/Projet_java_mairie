package equipe;

import java.util.*;
<<<<<<< Updated upstream
 
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
=======

public class Expert extends Personne{
	private List <Secteur> secteurs; //chaque expert est spécialisé dans une liste de secteurs que l'on a definit dans notre énumération secteur
    private Random random = new Random();  //pour faire le processus stochastique
	
	public Expert (String nom, String prenom, int age, List <Secteur> secteurs) {
		super(nom, prenom, age);
		this.secteurs = secteurs; 
	}

	public List<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(List<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public Projet proposer_projet () {
		Secteur secteurchoisi = secteurs.get(random.nextInt(secteurs.size())); //Un expert est spécialisé dans un secteur aléatoire parmi ceux proposé par l'énoncé
		String titre = "un projet dans le secteur " + secteurchoisi; // génère le titre du projet dans le secteur choisi
		String description = "Projet dans le secteur " + secteurchoisi; //génère la description du projet dans le secteur choisi
		Projet p = new Projet(titre, description, secteurchoisi); //créer/propose le projet
		System.out.println("L'expert "+ getPrenom()+ " " + getNom()+ " propose " + p.getTitre()); //nous renvoie dans la console le projet proposé par tel ou tel expert
		return p; //renvoie le projet
	}
}
>>>>>>> Stashed changes
