package equipe;

/**
 * Représente les personnes de l'équipe municipale
 * @author feryelbenameur
 * @version 1.0
 */

public abstract class Personne {

	private final String nom;
	private final String prenom;
	private final int age;

	/**
	 * Constructeur qui renvoie les personnes de l'équipe municipale
	 * @param nom nom d'une personne
	 * @param prenom prénom d'une personne
	 * @param age âge d'une personne 
	 */
	public Personne (String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;	
	}

	/**
	 * permet d'accéder au nom d'une personne
	 * @return nom d'une personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * permet d'accéder au prénom d'une personne
	 * @return le prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

}
