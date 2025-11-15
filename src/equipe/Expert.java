package equipe;

import java.util.*;

public class Expert extends Personne{
	public Expert (String nom, String prenom, int age) {
		super(nom, prenom, age);
	}
	public class Experts extends LinkedList<Personne>{
		public void addexpert (String nom, String prenom, int age) {
			this.add(new Personne(nom, prenom, age));

		}
	}
	public static void proposer_projet () {
		
	}
}