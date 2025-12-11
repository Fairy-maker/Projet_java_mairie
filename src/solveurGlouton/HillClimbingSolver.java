package solveurGlouton;

import jdk.jshell.execution.Util;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HillClimbingSolver {

    public static List<ObjetDansSacADos> resoudre(SacADos sacADos, List<ObjetDansSacADos> solutionInitiale) throws Exception {

        int utiliteSolutionInitiale = Utils.utilite(solutionInitiale);

        // On interdit les solutions vides
        if (solutionInitiale.isEmpty()) {
            throw new Error("La solution initiale est vide");
        }

        // On construit la liste des objets non-inclus dans la solution courante.
        List<ObjetDansSacADos> objetsNonInclus = new ArrayList<>();
        for (ObjetDansSacADos obj: sacADos.getObjets()) {
            if (!solutionInitiale.contains(obj)) {
                objetsNonInclus.add(obj);
            }
        }

        // S'il n'y a aucun objet non inclus, on a fini
        if (objetsNonInclus.isEmpty()) {
            return solutionInitiale;
        }

        // On cherche le voisin qui maximise l'utilite

        int utiliteMeilleurVoisin = -1;
        List<ObjetDansSacADos> meilleurVoisin = new ArrayList<>();
        for (int index=0; index < solutionInitiale.size(); index++) {
            List<ObjetDansSacADos> voisinCourant = new ArrayList<>(solutionInitiale);
            voisinCourant.remove(index);
            int[] sommeDesCoutsDeLaSousListe = Utils.sommeDesCouts(voisinCourant);
            for (ObjetDansSacADos obj: objetsNonInclus) {
                voisinCourant.add(obj);
                // On verifie que le voisin respecte le budget, sinon il est ecarté
                int[] somme = Utils.addCoordinates(sommeDesCoutsDeLaSousListe, obj.getCouts());
                if (!Utils.allSmaller(somme, sacADos.getBudgets())) {
                    voisinCourant.remove(obj);
                    continue;
                }
                // On ne conserve que le meilleur voisin
                int utiliteVoisinCourant = Utils.utilite(voisinCourant);
                if (utiliteVoisinCourant > utiliteMeilleurVoisin) {
                    utiliteMeilleurVoisin = utiliteVoisinCourant;
                    meilleurVoisin = new ArrayList<>(voisinCourant);
                }
                voisinCourant.remove(obj);
            }
        }

        // Si le voisin n'est pas meilleur, on a fini
        if (utiliteMeilleurVoisin <= utiliteSolutionInitiale) {
            return solutionInitiale;
        } else {
            return resoudre(sacADos, meilleurVoisin);
        }

    }

}