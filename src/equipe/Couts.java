package equipe;

public class Couts {
	private int coutEco;
	private int coutSocio;
	private int coutEnv;
	
	// Initialiseur à utiliser quand les couts ne sont pas encore connus
	Couts() {
		this.coutEco = -1;
		this.coutSocio = -1;
		this.coutEnv = -1;
	}

	Couts(int coutEco, int coutSocio, int coutEnv) {
		this.coutEco = coutEco;
		this.coutSocio = coutSocio;
		this.coutEnv = coutEnv;
	}

	public int getCoutEco() {
		return coutEco;
	}

	public void setCoutEco(int coutEco) {
		this.coutEco = coutEco;
	}

	public int getCoutSocio() {
		return coutSocio;
	}

	public void setCoutSocio(int coutSocio) {
		this.coutSocio = coutSocio;
	}

	public int getCoutEnv() {
		return coutEnv;
	}

	public void setCoutEnv(int coutEnv) {
		this.coutEnv = coutEnv;
	}
	
	public int getCoutTotal() throws Error {
		if (this.coutEco == -1 || this.coutEnv == -1 || this.coutSocio == -1) {
			throw new Error("Un des couts n'est pas encore évalué");
		}
		return this.coutEco + this.coutSocio + this.coutEnv;
	}
}
