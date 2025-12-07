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
	
	private String titre;
	private String description;
	private Secteur secteur;
	private Cout cout;
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
     * permet de définir le titre du projet
     * @param titre le nouveau titre du projet
     */
	public void setTitre(String titre) {
		this.titre = titre;
	}

    /**
     * permet d'accéder à la description du projet
     * @return la description du projet
     */
    public String getDescription() {
		return description;
	}

    /**
     * permet de définir la description du projet
     * @param description la nouvelle description du projet
     */
	public void setDescription(String description) {
		this.description = description;
	}

    /**
     * permet d'accéder au secteurs(s) du projet
     * @return le secteur(s) du projet
     */
	public Secteur getSecteur() {
		return secteur;
	}

	/**
	 * permet de définir le(s) secteur(s) du projet
	 * @param secteur la nouvelle valeure pour le(s) secteur(s) du projet
	 */
	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

    /**
     * permet d'accéder au coût du projet
     * @return le coût du projet
     */
	public Cout getCout() {
		return cout;
	}

    /**
     * permet de définir le coût du projet
     * @param cout la nouvelle valeur pour le coût du projet
     */
	public void setCout(Cout cout) {
		this.cout = cout;
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
