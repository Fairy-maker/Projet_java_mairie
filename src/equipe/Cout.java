package equipe;

/**
 * Représente un ensemble de cout associés à un projet :
 * <ul>
 * <li> cout économique </li>
 * <li> cout social </li>
 * <li> cout environnemental</li>
 * </ul>
 * <p>
 * Les coûts sont initialisés à -1 pour dire qu'ils ne sont pas encore connus.
 * </p>
 * @author feryel benameur
 * @version 1.0
 */
public class Cout {
	private int coutEco;
	private int coutSocio;
	private int coutEnv;
	/**
	 * Constructeur par défaut de la classe Coût
	 * @param coutEco
	 * @param coutSocio
	 * @param coutEnv
	 * <p>
	 * On initialise tous les coûts à -1 s'ils ne sont pas connus
	 * </p>
	 */
	Cout() {
		this.coutEco = -1;
		this.coutSocio = -1;
		this.coutEnv = -1;
	}	
/**
 * Créer un ensemble de coûts (économique, social et environnemental) 
 * @param coutEco
 * @param coutSocio
 * @param coutEnv
 */
	Cout(int coutEco, int coutSocio, int coutEnv){
		this.coutEco = coutEco;
		this.coutSocio = coutSocio;
		this.coutEnv = coutEnv;
	}

	/**
	 * permet d'accéder au coût économque qui était en private
	 * @return le coût économique 
	 */
	public int getCoutEco() {
		return coutEco;
	}

	/**
	 * permet de définir le coût économique
	 * @param coutEco nouvelle valeure du cout économique
	 */
	public void setCoutEco(int coutEco) {
		this.coutEco = coutEco;
	}
/**
 * permet d'accéder au coût social qui est en private
 * @return le cout social
 */
	public int getCoutSocio() {
		return coutSocio;
	}

	/**
	 * permer de définir le coût social
	 * @param coutSocio nouvelle valeure du coût sociale
	 */
	public void setCoutSocio(int coutSocio) {
		this.coutSocio = coutSocio;
	}

	/**
	 * permet d'accéder au coût environnemental
	 * @return le coût environnemental
	 */
	public int getCoutEnv() {
		return coutEnv;
	}

	/**
	 * permet de définir le coût environnemental
	 * @param coutEnv nouvelle valeure du coût sociale
	 */
	public void setCoutEnv(int coutEnv) {
		this.coutEnv = coutEnv;
	}
	
/**
 * Calcul le coût total qui est la somme des trois coûts (économique, social et environnemental)
 * @return le cout total
 * @throws Error si au moins un des coûts n'a pas encore été évalué (valeur qui est de -1)
 */
	public int getCoutTotal() throws Error {
		if (this.coutEco == -1 || this.coutEnv == -1 || this.coutSocio == -1) {
			throw new Error("Un des couts n'est pas encore évalué");
		}
		return this.coutEco + this.coutSocio + this.coutEnv;
	}
}
