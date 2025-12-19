package equipe;

import java.lang.reflect.Type;

/**
 * Répresente les projets qui sont définit par :
 * <ul>
 * <li> un titre, </li>
 * <li> une description, </li>
 * <li> un secteur, </li>
 * <li> un coût, </li>
 * <li> un bénéfice </li>
 * </ul>
 * @author feryel benameur
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
	 * permet de définir le bénéfice
	 * @param benefice nouvelle valeur du bénéfice
	 */
    public void setBenefice(int benefice) {
        this.benefice = benefice;
    }

    /**
     * permet d'accéder au secteur du projet
     * @return le secteur du projet 
     */

    public Secteur getSecteur() {
        return secteur;
    }

    /**
   * Constructeur qui nous permet de construire un projet
   * @param titre titre du projet
   * @param description description du projet
   * @param secteur secteur dans lequel est rattaché le projet (le projet peut être rattaché à plusieurs secteurs)
   * <p>
   * De plus, ce constructeur nous donne un coût pour le projet.
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
	 * permet d'accéder au coût total du projet en additionant les coûts évalués pour chaque type de coûts (économique,
	 * social et environnemental).
	 * Seuls les coûts positifs sont pris en compte.
	 * @return le coût total du projet qui est la somme des coûts positifs.
	 */
	public int getCoutTotal() {
        int coutTotal = 0;
        for (int i=0; i < TypeEvaluationCout.values().length; i++) {
            if (this.cout.toArray()[i] >= 0) {
                coutTotal += this.cout.toArray()[i];
            }
        }
        return coutTotal;
	}

    /**
     * Méthode qui renvoie une représentation textuelle dans la console du projet. On a donc :
     * <ul>
     * <li> un titre, </li>
     * <li> une description, </li>
     * <li> une liste de secteur(s), </li>
     * <li> les trois coûts donnés par nos évaluateurs, </li>
     * <li> le coût total </li>
     * <li> le bénéfice estimé</li>
     * </ul>
     * Seuls les coûts positifs sont affichés.
     * @return une chaîne de caractères décrivant le projet
     */
	@Override
	public String toString() {
        var s = "Projet : " + titre + "\nDescription : " + description + "\n";
        s += "Secteur : " + secteur + "\n";
        s += "Coûts donnés par nos évaluateurs :\n";
        for (int i=0; i< TypeEvaluationCout.values().length; i++) {
            TypeEvaluationCout type = TypeEvaluationCout.values()[i];
            if (cout.toArray()[i] >= 0) {
                s += "    -Coût " + type.name() + ": " + cout.toArray()[i] + " €\n";
            }
        }
        s += "Coût total : " + getCoutTotal() + " €\n";
        s += "Bénéfice (utilité) : " + this.benefice + " €\n";
        return s;
	}

}