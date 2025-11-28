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
import sacADos.SacADosImpl;
import solveur_glouton.*;

public class Main {
	//technique reprises du TP4 + certains prénoms et noms sont inspiré du TP 3 et TP 4
	public static void main(String[] args) throws Exception { 
		Random random = new Random(0);
		// technique inspiré de la playlist youtube de Jiraws
		// Création de l'équipe municipale
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
		
		System.out.println("-------- Simulation des Projets --------\n");
		equipeMunicipale.executerUnCycleDeSimulation();
		
		System.out.println("\n-------- Voici les projets retenus : -------- \n");
		for (Projet p : Equipe_municipale.projetsEtudies) {
			System.out.println(p);
		}

		// Sac à dos
        SacADosImpl sac = new SacADosImpl(3, new int[]{3000, 2000, 1000});
        for (Projet p : equipeMunicipale.projetsEtudies) {
            ProjetDansSacADos pd = new ProjetDansSacADos(p);
            sac.add(pd);
        }

        // Solveur glouton
        SortByInterest comparator = new SortByInterest();
        List<ObjetDansSacADos> solution =
            GloutonAjoutSolver.resolutionParMethodeGloutonne(sac, comparator);

        System.out.println("\n-------- Solution gloutonne --------\n");
        for (ObjetDansSacADos o : solution)
            System.out.println(o);

        System.out.println("Utilite totale = " +
            solution.stream().mapToInt(ObjetDansSacADos::getUtilite).sum());
    }
}

