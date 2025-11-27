package main;

import java.util.*;


//technique tiré de https://openclassrooms.com/forum/sujet/import-classe-java-98358
import equipe.Elu; 
import equipe.Evaluateur;
import equipe.Expert;
import equipe.Secteur;
import equipe.TypeEvaluationCout;
import equipe.Equipe_municipale;
import equipe.Projet;

public class Main {
	public static void main(String args[]) { //technique reprises du TP4 + certains prénoms et noms sont inspiré du TP 3 et TP 4
		// technique inspiré de la playlist youtube de Jiraws
		Elu elu = new Elu ("Martin","Bernard", 20);
		Evaluateur evaluateureco = new Evaluateur ("Benameur", "Féryel", 33, TypeEvaluationCout.ECONOMIQUE);
		Evaluateur evaluateursocio = new Evaluateur("Baigneres", "Clara", 32, TypeEvaluationCout.SOCIAL);
		Evaluateur evaluateurenv = new Evaluateur("Boucheron", "Lucie", 34, TypeEvaluationCout.ENVIRONNEMENT);
		Expert expertsanté = new Expert ("Kayn", "Georges", 24, List.of(Secteur.SANTÉ));
		Expert expertattractivitéeco = new Expert ("Jam", "Emmanuel", 35, List.of(Secteur.ATTRACTIVITÉ_ÉCONOMIQUE));
		Expert expertecologie = new Expert ("Thumberg", "Greta", 19, List.of(Secteur.ÉCOLOGIE));
		Expert expertculture = new Expert ("Snow", "Jon", 45, List.of(Secteur.CULTURE));
		Expert expertsport = new Expert ("Marchand", "Léon", 28, List.of(Secteur.SPORT));
		Expert experteducation = new Expert ("Merveille", "Alice", 57, List.of(Secteur.ÉDUCATION));
		
		// technique inspiré du TP6 
		List<Expert> expert = new ArrayList<>();
		expert.add(expertsanté);
		expert.add(experteducation);
		expert.add(expertsport);
		expert.add(expertculture);
		expert.add(expertecologie);
		expert.add(expertattractivitéeco);
		
		Equipe_municipale equipe_municipale = new Equipe_municipale(elu, evaluateureco, evaluateursocio, evaluateurenv, expert);
		
		
		//Partie proposé par l'IA :
		System.out.println("-------- Simulation des Projets --------\n");
		for (Expert e : expert) {
			equipe_municipale.simuler_projet(e);
		}
		
		System.out.println("\n-------- Voici les projets retenus : -------- \n");
		for (Projet p : equipe_municipale.Liste_projet) {
			System.out.println(p);
		}
	}
}
