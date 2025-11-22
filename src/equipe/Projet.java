package equipe;


public class Projet {
	private String titre;
	private String description;
	private double benefice;
	private double coutTotal;

	public void setBenefice(double benefice) {
		this.benefice = benefice;
	}

	private Secteur secteur;
	private Cout cout;
	
	public Projet (String titre, String description, Secteur secteur) {
		this.titre = titre;
		this.description = description;
		this.secteur = secteur;
		this.cout = new Cout(0, 0, 0);
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public Cout getCout() {
		return cout;
	}

	public void setCout(Cout cout) {
		this.cout = cout;
	}
	
	public double getCoutTotal() {
	    return cout.getCoutEco() + cout.getCoutSocio() + cout.getCoutEnv();
	}
	


	@Override
	public String toString() {
	    return  "Projet : " + titre + "\nDescription : " + description + 
	    		"\nSecteur : " + secteur + 
	    		"\n  Coûts donnés par nos évaluateurs : " + "\n    -Coût économique : " + cout.getCoutEco() + " € " + "\n    -Coût social : " + cout.getCoutSocio() + " € " + "\n    -Coût environnemental : " + cout.getCoutEnv() + " € " + 
	    		"\nCoût total :  " + getCoutTotal()+ "\n" ;
	}

}
