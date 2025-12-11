package equipe;
import java.util.*;

/**
 * Représente une équipe municipale composé de :
 * <ul>
 * <li> un elu qui évalue le bénéfice d'un projet </li>
 * <li> trois évaluateurs (un économique, un social et un environnemental) qui évalue le coût du projet </li>
 * <li> une liste d'expert spécialisé dans des secteurs particuliers et qui proposent des projets </li>
 *</ul>
 */

public class EquipeMunicipale {

	private final Elu elu;
	private final Evaluateur evaluateurEco;
	private final Evaluateur evaluateurSocio;
	private final Evaluateur evaluateurEnv;
    private final List<Expert> experts;

	private final List<Projet> projetsEtudies = new ArrayList<>();

    /**
     * Constructeur qui nous permet de créer une nouvelle équipe municipale
     * @param elu l'élu chargé d'évaluer le bénéfice des projets
     * @param evaluateurEco l'évaluateur économique chargé d'évaluer le coût économique du projet
     * @param evaluateurSocio l'évaluateur social chargé d'évaluer le coût social du projet
     * @param evaluateurEnv l'évaluateur environnemental chargé d'évaluer le coût environnemental du projet
     * @param experts la liste d'expert spécialisé dans des secteurs particulier et qui sont chargé de proposer des projets
     *
     * @author feryel benameur
     */
	public EquipeMunicipale(Elu elu, Evaluateur evaluateurEco, Evaluateur evaluateurSocio, Evaluateur evaluateurEnv, List <Expert> experts) {
		this.elu = elu;
		this.evaluateurEco = evaluateurEco;
		this.evaluateurSocio = evaluateurSocio;
		this.evaluateurEnv = evaluateurEnv;
		this.experts = experts;
	}

    /**
     * Retourne la liste des projets étudiés.
     * @return La liste des projets étudiés.
     */
    public List<Projet> getProjetsEtudies() {
        return projetsEtudies;
    }
    /**
	 * Exécute un cycle de simulation des projets 
	 * <p>
	 * Si la liste des projets ) évaluer est vide alors la méthode demande à chaque experts de proposer un projet,
	 * en fait évaluer les coûts par nos évaluateurs,
	 * fait estimer le bénéfice par l'élu et enfin,
	 * ajoute le projet à la liste des projets étudiés.
	 * </p>
	 * <p>
	 * Si des projets ont été étudiés, la méthode ne fait rien
	 * </p>
	 */
	public void executerUnCycleDeSimulation() {
		if(!this.projetsEtudies.isEmpty()) {
			return;
		}
		for(Expert expert: this.experts) {
			Projet p = expert.proposerProjet();
	        evaluateurEco.evaluerCoutProjet(p);
	        evaluateurSocio.evaluerCoutProjet(p);
	        evaluateurEnv.evaluerCoutProjet(p);
	        elu.estimerBenefice(p);
	        this.projetsEtudies.add(p);
		}
	}
	
}
