package equipe;

public class Projet {
	private String titre;
	private String description;
	private float benefice;
	private Secteur secteur;
	private Cout cout;
	
	public Projet (String titre, String description, float benefice, Secteur secteur, Cout cout) {
		this.titre = titre;
		this.description = description;
		this.benefice = benefice;
		this.secteur = secteur;
		this.cout = cout;
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

	public float getBenefice() {
		return benefice;
	}

	public void setBenefice(float benefice) {
		this.benefice = benefice;
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


}
