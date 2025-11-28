package main;

import java.util.*;


//technique tiré de https://openclassrooms.com/forum/sujet/import-classe-java-98358
import equipe.Elu; 
import equipe.Evaluateur;
import equipe.Expert;
import equipe.Secteur;
import equipe.TypeEvaluationCout;
import sacADos.Objet;
import equipe.Equipe_municipale;
import equipe.Projet;

public class Main {
	public static void main(String args[]) { //technique reprises du TP4 + certains prénoms et noms sont inspiré du TP 3 et TP 4
		Random random = new Random(0);
		// technique inspiré de la playlist youtube de Jiraws
		Elu elu = new Elu ("Martin","Bernard", 20, random);
		Evaluateur evaluateurEco = new Evaluateur ("Benameur", "Féryel", 33, TypeEvaluationCout.ECONOMIQUE, random);
		Evaluateur evaluateurSocio = new Evaluateur("Baigneres", "Clara", 32, TypeEvaluationCout.SOCIAL, random);
		Evaluateur evaluateurEnv = new Evaluateur("Boucheron", "Lucie", 34, TypeEvaluationCout.ENVIRONNEMENT, random);
		Expert expertSanté = new Expert ("Kayn", "Georges", 24, List.of(Secteur.SANTÉ), random);
		Expert expertAttractivitéEco = new Expert ("Jam", "Emmanuel", 35, List.of(Secteur.ATTRACTIVITÉ_ÉCONOMIQUE), random);
		Expert expertEcologie = new Expert ("Thumberg", "Greta", 19, List.of(Secteur.ÉCOLOGIE), random);
		Expert expertCulture = new Expert ("Snow", "Jon", 45, List.of(Secteur.CULTURE), random);
		Expert expertSport = new Expert ("Marchand", "Léon", 28, List.of(Secteur.SPORT), random);
		Expert expertEducation = new Expert ("Merveille", "Alice", 57, List.of(Secteur.ÉDUCATION), random);

		// technique inspiré du TP6 
		List<Expert> expert = new ArrayList<>();
		expert.add(expertSanté);
		expert.add(expertEducation);
		expert.add(expertSport);
		expert.add(expertCulture);
		expert.add(expertEcologie);
		expert.add(expertAttractivitéEco);

		Equipe_municipale equipeMunicipale = new Equipe_municipale(elu, evaluateurEco, evaluateurSocio, evaluateurEnv, expert);
		
		
		// Test sur l'équipe municipale 
		
		System.out.println("-------- Simulation des Projets --------\n");
		equipeMunicipale.executerUnCycleDeSimulation();
		
		
		System.out.println("\n-------- Voici les projets etudies : -------- \n");
		for (Projet p : equipeMunicipale.projetsEtudies) {
			System.out.println(p);
		}
		
		
		// Test sur le sacADos 
		
		System.out.println("\n Test sur le sac a dos : \n");
		// Création de nos objets
		Objet Objet1 = new Objet (50, [2200, 400, 230]);
		Objet Objet2 = new Objet (30, 1200, 300, 220 );
		Objet Objet3 = new Objet (60, 1240, 600, 120 );
		
		// Création du sac a dos :
		sacADos sacados1 = new sacADos(2, 7000);
		// On ajout les objets dans le sac a dos :
		sacados1.add(Objet1);
		sacados1.add(Objet2);
		sacados1.add(Objet3);		
		
		
	}
}

