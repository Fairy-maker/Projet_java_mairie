package equipe;
import java.util.*;

public class Equipe_municipale {
	private Elu elu;
	private final Evaluateur evaluateureco;
	private final Evaluateur evaluateursocio;
	private final Evaluateur evaluateurenv;
	public List <Expert> expert;
	public List <Projet> Liste_projet = new ArrayList<>();
	
	public Equipe_municipale(Elu elu, Evaluateur evaluateureco, Evaluateur evaluateursocio, Evaluateur evaluateurenv, List <Expert> expert) {
		this.elu = elu;
		this.evaluateureco = evaluateureco;
		this.evaluateursocio = evaluateursocio;
		this.evaluateurenv = evaluateurenv;
		this.expert = expert;
	}
	
	public void simuler_projet (Expert expert) {
		Projet p = expert.proposer_projet();
        evaluateureco.evalue_cout_projet(p);
        evaluateursocio.evalue_cout_projet(p);
        evaluateurenv.evalue_cout_projet(p);
        elu.estimer_benefice(p.getCout());
        Liste_projet.add(p);	
							
	}	
}
