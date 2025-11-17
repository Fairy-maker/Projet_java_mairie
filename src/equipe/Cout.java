package equipe;

public class Cout {
	private int coutEco;
	private int coutSocio;
	private int coutEnv;

	Cout(int coutEco, int coutSocio, int coutEnv){
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
}
