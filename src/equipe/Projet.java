package equipe;

/**
 * Répresente les projets qui sont définits par :
 * <ul>
 * <li> un titre, </li>
 * <li> une description, </li>
 * <li> un ou des secteur(s), </li>
 * <li> un coût, </li>
 * <li> un bénéfice </li>
 * </ul>
 * @author feryelbenameur
 * @version 1.0
 */

public class Projet {
	
	private final String titre;
	private final String description;
	private final Secteur secteur;
	private final Cout cout;
	private int benefice;
	
  /**
   * permet d'accéder au bénéfice d'un projet
   * @return le bénéfice du projet
   */	
	public int getBenefice() {
		return benefice;
	}
	
  /**
   * Constructeur qui nous permet de construire un projet
   * @param titre titre du projet
   * @param description description du projet
   * @param secteur secteurs dans lequel est rattaché le projet (le projet peut être rattaché à plusieurs secteurs)
   * <p>
   * De plus, ce constructeur nous donne un cout pour le projet
   * </p>
   */
	public Projet(String titre, String description, Secteur secteur) {
		this.titre = titre;
		this.description = description;
		this.secteur = secteur;
		this.cout = new Cout();
	}
	
  /**
   * permet d'accéder au titre du projet
   * @return le titre du projet
   */
	public String getTitre() {
		return titre;
	}

    /**
     * permet d'accéder au coût du projet
     * @return le coût du projet
     */
	public Cout getCout() {
		return cout;
	}

	/**
	 * permet d'accéder au coût total du projet
	 * @return le coût total du projet qui est la somme des trois coûts (économique, social, environnemental)
	 */
	public double getCoutTotal() {
	    return cout.getCoutEco() + cout.getCoutSocio() + cout.getCoutEnv();
	}

    /**
     * Méthode qui renvoie une représentation textuelle dans la console du projet. On a donc :
     * <ul>
     * <li> un titre, </li>
     * <li> une description, </li>
     * <li> une liste de secteur(s), </li>
     * <li> les trois coûts donnés par nos évaluateurs, </li>
     * <li> le coût total </li>
     * </ul>
     * @return une chaîne de caractères décrivant le projet
     */
	@Override
	public String toString() {
	    return  "Projet : " + titre + "\nDescription : " + description + 
	    		"\nSecteur : " + secteur + 
	    		"\n  Coûts donnés par nos évaluateurs : " + "\n    -Coût économique : " + cout.getCoutEco() + " € " + "\n    -Coût social : " + cout.getCoutSocio() + " € " + "\n    -Coût environnemental : " + cout.getCoutEnv() + " € " + 
	    		"\nCoût total :  " + getCoutTotal()+ "\n" ;
	}

}