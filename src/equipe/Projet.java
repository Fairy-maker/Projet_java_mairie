package equipe;


public class Projet {
	
	private String titre;
	private String description;
	private Secteur secteur;
	private Couts couts;
	
	private double benefice;

	public void setBenefice(double benefice) {
		this.benefice = benefice;
	}

	
	public Projet (String titre, String description, Secteur secteur) {
		this.titre = titre;
		this.description = description;
		this.secteur = secteur;
		this.couts = new Couts();
	}

	public String getTitre() {
		return titre;
	}

	public String getDescription() {
		return description;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public double getCoutTotal() throws Error {
	    return couts.getCoutTotal();
	}
	
	public void setCoutSocio(int coutSocio) {
		this.couts.setCoutSocio(coutSocio);
	}
	
	public void setCoutEco(int coutEco) {
		this.couts.setCoutEco(coutEco);
	}
	
	public void setCoutEnv(int coutEnv) {
		this.couts.setCoutEnv(coutEnv);
	}

	@Override
	public String toString() {
	    return  "Projet : " + titre + "\nDescription : " + description + 
	    		"\nSecteur : " + secteur + 
	    		"\n  Coûts donnés par nos évaluateurs : " + "\n    -Coût économique : " + couts.getCoutEco() + " € " + "\n    -Coût social : " + couts.getCoutSocio() + " € " + "\n    -Coût environnemental : " + couts.getCoutEnv() + " € " + 
	    		"\nCoût total :  " + getCoutTotal()+ "\n" ;
	}

}
