package equipe;
import java.util.*;

public class EquipeMunicipale {
	
	private Elu elu;
	private final Evaluateur evaluateurEco;
	private final Evaluateur evaluateurSocio;
	private final Evaluateur evaluateurEnv;
	public List <Expert> experts;
	public List <Projet> projetsEtudies = new ArrayList<>();
	
	public EquipeMunicipale(Elu elu, Evaluateur evaluateurEco, Evaluateur evaluateurSocio, Evaluateur evaluateurEnv, List<Expert> experts) {
		this.elu = elu;
		this.evaluateurEco = evaluateurEco;
		this.evaluateurSocio = evaluateurSocio;
		this.evaluateurEnv = evaluateurEnv;
		this.experts = experts;
	}
	
	
	/**
	 * Si la liste des projets a evaluer est vide, cette methode demande
	 * a chaque expert de creer un projet, en fait evaluer le cout par les evaluateurs,
	 * fait evaluer le benefice par l'elu, et stocke le projet dans la liste des projets
	 * étuidés par la municipalité.
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
	        projetsEtudies.add(p);								
		}
	}
	
}
