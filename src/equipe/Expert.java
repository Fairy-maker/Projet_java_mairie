package equipe;

import java.util.*;
/**
 * Un expert est une personne qui, rattaché à un secteur, a les compétences pour proposer des projets
 * @author feryelbenameur
 * @version 1.0
 */
public class Expert extends Personne {
	
	// Chaque expert est spécialisé dans une liste de secteurs que l'on a definit dans notre énumération secteur
	private List<Secteur> secteurs; 
	private Random random;  //pour faire le processus stochastique
	
/**
 * Constructeur qui nous permet de définir un expert
 * @param nom nom de l'expert
 * @param prenom prénom de l'expert
 * @param age âge de l'expert
 * @param secteurs secteurs dans lequel l'expert est spécialisé
 * @param random utiliser pour réaliser le processus stochastique
 */

	public Expert(String nom, String prenom, int age, List<Secteur> secteurs, Random random) {
		super(nom, prenom, age);
		this.secteurs = secteurs; 
		this.random = random;
	}
	
	/**
	 * permet d'accéder aux secteurs de l'expert
	 * @return les secteurs de l'expert
	 */

	public List<Secteur> getSecteurs() {
		return secteurs;
	}
/**
 * Méthode qui permet aux experts de créer/ proposer des projets en fonction des secteurs dans lesquels ils sont "spécialisé".
 * L'expert est spécialisé dans un secteur aléatoire parmi ceux proposé dans l'énumération secteur
 * L'expert va proposer un projet qui détient :
 * <ul>
 * <li> un titre,</li>
 * <li> une description </li>
 * <li> appartient à un secteur donné </li>
 * </ul>
 * 
 * <p>
 * De plus, cette méthode nous renvoie dans la console l'identité de l'expert (nom et prénom) ainsi que le projet qu'il propose.
 * </p>
 * @return le projet p proposé par l'expert
 */
	public Projet proposerProjet() {
		Secteur secteurChoisi = secteurs.get(random.nextInt(secteurs.size()));
		String titre = "un projet dans le secteur " + secteurChoisi; 
		String description = "Projet dans le secteur " + secteurChoisi; 
		Projet p = new Projet(titre, description, secteurChoisi); 
		System.out.println("L'expert "+ getPrenom()+ " " + getNom()+ " propose " + p.getTitre());
		return p; //renvoie le projet
	}
}