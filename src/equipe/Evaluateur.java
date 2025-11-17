package equipe;

public abstract class Evaluateur extends Personne {
	public Evaluateur(String nom, String prenom, int age) {
		super(nom, prenom, age);
	}
	public static void evalue_cout_projet() { 

	}
	public static void renseigner_cout_projet() {

	}
	public abstract void evalue_projet(Projet p);
}