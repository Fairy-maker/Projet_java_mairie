package equipe;
import java.util.*;

public class Equipe_municipale {
	private Elu elu;
	private final Evaluateur evaluateurEco;
	private final Evaluateur evaluateurSocio;
	private final Evaluateur evaluateurEnv;
	public List <Expert> expert;
	public static List <Projet> ProjetsEtudies = new ArrayList<>();
	
	public Equipe_municipale(Elu elu, Evaluateur evaluateurEco, Evaluateur evaluateurSocio, Evaluateur evaluateurEnv, List <Expert> expert) {
		this.elu = elu;
		this.evaluateurEco = evaluateurEco;
		this.evaluateurSocio = evaluateurSocio;
		this.evaluateurEnv = evaluateurEnv;
		this.expert = expert;
	}

	/**
	 * Si la liste des projets a evaluer est vide, cette methode demande
	 * a chaque expert de creer un projet, en fait evaluer le cout par les evaluateurs,
	 * fait evaluer le benefice par l'elu, et stocke le projet dans la liste des projets
	 * étuidés par la municipalité.
	 */
	public void executerUnCycleDeSimulation() {
		if(!this.ProjetsEtudies.isEmpty()) {
			return;
		}
		for(Expert expert: this.expert) {
			Projet p = expert.proposerProjet();
	        evaluateurEco.evaluerCoutProjet(p);
	        evaluateurSocio.evaluerCoutProjet(p);
	        evaluateurEnv.evaluerCoutProjet(p);
	        elu.estimerBenefice(p.getCout());
	        ProjetsEtudies.add(p);								
		}
	}
	
}
