package main;

import java.util.*;


//technique tiré de https://openclassrooms.com/forum/sujet/import-classe-java-98358
import equipe.Elu;
import equipe.Evaluateur;
import equipe.Expert;
import equipe.Secteur;
import equipe.TypeEvaluationCout;
import equipe.EquipeMunicipale;
import equipe.Projet;
import sacADos.MethodeDeResolution;
import sacADos.SacADos;
import solveurGlouton.ObjetInterface;
import solveurGlouton.Utils;

public class Main {
    //technique reprises du TP4 + certains prénoms et noms sont inspiré du TP 3 et TP 4
    public static void main(String[] args) throws Exception {

        Random random = new Random(0);

        // technique inspiré de la playlist youtube de Jiraws
        // Création de l'équipe municipale

        Elu elu = new Elu("Martin", "Bernard", 20, random);

        // On demande le scénario

        Scenario scenario = demanderScenario();

        // Le scenarion permet de savoir comment creer les liste d'experts et d'evaluateurs, ainsi que les budgets

        List<Expert> experts = new ArrayList<>();
        List<Evaluateur> evaluateurs = new ArrayList<>();
        int[] budgets = new int[0];
        switch (scenario) {
            case Scenario.COUTS_PAR_TYPES_DE_COUT:

                Expert expert = new Expert("Kayn", "Georges", 24, List.of(Secteur.values()), random);
                experts.add(expert);

                Evaluateur evaluateurEco = new Evaluateur("Benameur", "Féryel", 33, TypeEvaluationCout.ECONOMIQUE, random);
                Evaluateur evaluateurSocio = new Evaluateur("Baigneres", "Clara", 32, TypeEvaluationCout.SOCIAL, random);
                Evaluateur evaluateurEnv = new Evaluateur("Boucheron", "Lucie", 34, TypeEvaluationCout.ENVIRONNEMENT, random);
                evaluateurs.add(evaluateurEco);
                evaluateurs.add(evaluateurSocio);
                evaluateurs.add(evaluateurEnv);

                budgets = new int[TypeEvaluationCout.values().length];
                for (int i=0; i<TypeEvaluationCout.values().length; i++) {
                    budgets[i] = random.nextInt(10000, 100000);
                }

                break;
            case Scenario.COUTS_PAR_SECTEUR:

                Expert expertAttractiviteEco = new Expert("Jam", "Emmanuel", 35, List.of(Secteur.ATTRACTIVITE_ECONOMIQUE, Secteur.SANTE), random);
                experts.add(expertAttractiviteEco);
                Expert expertCulture = new Expert("Snow", "Jon", 45, List.of(Secteur.CULTURE, Secteur.SPORT), random);
                experts.add(expertCulture);
                Expert expertSport = new Expert("Marchand", "Léon", 28, List.of(Secteur.SPORT, Secteur.ATTRACTIVITE_ECONOMIQUE), random);
                experts.add(expertSport);
                Expert expertEducation = new Expert("Merveille", "Alice", 57, List.of(Secteur.EDUCATION, Secteur.CULTURE), random);
                experts.add(expertEducation);

                Evaluateur evaluateur = new Evaluateur("Benameur", "Féryel", 33, TypeEvaluationCout.ECONOMIQUE, random);
                evaluateurs.add(evaluateur);

                budgets = new int[Secteur.values().length];
                for (int i=0; i<Secteur.values().length; i++) {
                    budgets[i] = random.nextInt(10000, 11000);
                }

                break;
        }

        // On affiche les budgets

        switch (scenario) {
            case COUTS_PAR_TYPES_DE_COUT:
                System.out.println("Budgets par type de couts:");
                for (int i = 0; i < TypeEvaluationCout.values().length; i++) {
                    TypeEvaluationCout type = TypeEvaluationCout.values()[i];
                    System.out.println("Budget pour cout " + type.name() + ": " + budgets[i]);
                }
                break;
            case COUTS_PAR_SECTEUR:
                System.out.println("Budgets par secteur:");
                for (int i = 0; i < Secteur.values().length; i++) {
                    Secteur secteur = Secteur.values()[i];
                    System.out.println("Budget pour secteur " + secteur.name() + ": " + budgets[i]);
                }
                break;
        }

        EquipeMunicipale equipeMunicipale = new EquipeMunicipale(elu, evaluateurs, experts);

        System.out.println("\n-------- Simulation des Projets --------\n");
        equipeMunicipale.executerUnCycleDeSimulation();

        System.out.println("\n-------- Voici le récaputilatif des projets : -------- \n");
        for (Projet p : equipeMunicipale.getProjetsEtudies()) {
            System.out.println(p);
        }

        // On génère le sac à dos

        VersSacADos versSacADos = new VersSacADos(budgets, equipeMunicipale.getProjetsEtudies(), scenario);
        SacADos sac = versSacADos.genererSacADos();

        // On demande la méthode à utiliser

        MethodeDeResolution methodeDeResolution = demanderMethode();

        List<ObjetInterface> solution = sac.resoudre(methodeDeResolution);

        System.out.println("\n------- Solution -------\n");
        for (ObjetInterface o : solution)
            System.out.println(o);

        System.out.println("Utilite totale de la solution est : " +
                Utils.utilite(solution));

    }


    private static  MethodeDeResolution demanderMethode() {
        System.out.println("Choisissez votre méthode de résolution:");
        for (int i=0; i<MethodeDeResolution.values().length; i++) {
            System.out.println(i+1 + " Méthode " + MethodeDeResolution.values()[i].name());
        }
        int nombre = 0;
        while (nombre < 1 || nombre > MethodeDeResolution.values().length) {
            Scanner scan = new Scanner(System.in);
            try {
                nombre = scan.nextInt();
            } catch (Exception e) {
                continue;
            }
        }
        return MethodeDeResolution.values()[nombre-1];
    }


    private static Scenario demanderScenario() {
        int nombre = 0;
        while (nombre != 1 && nombre != 2) {
            System.out.println("Choisissez votre scénario:");
            System.out.println("- En choisissant 1, il y aura 3 évaluateurs (un par type de coût) et 1 expert qui representera les 5 secteurs.");
            System.out.println("- En choisissant 2, il y aura 1 évaluateur (économique) et 4 experts qui représenteront à eux 4 les 5 secteurs.");
            Scanner scan = new Scanner(System.in);
            try {
                nombre = scan.nextInt();
            } catch (Exception e) {
                continue;
            }
        }
        if (nombre == 1) {
            return Scenario.COUTS_PAR_TYPES_DE_COUT;
        } else {
            return Scenario.COUTS_PAR_SECTEUR;
        }
    }

}