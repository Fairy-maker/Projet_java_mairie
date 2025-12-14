package solveurGlouton;


import java.util.ArrayList;
import java.util.List;

public class HillClimbingSolver {

    public static List<ObjetInterface> resoudre(SacADosInterface sacADos, List<ObjetInterface> solutionInitiale) throws Exception {

        int utiliteSolutionInitiale = Utils.utilite(solutionInitiale);

        // On interdit les solutions vides
        if (solutionInitiale.isEmpty()) {
            throw new Error("La solution initiale est vide");
        }

        // On construit la liste des objets non-inclus dans la solution courante.
        List<ObjetInterface> objetsNonInclus = new ArrayList<>();
        for (ObjetInterface obj: sacADos.getObjets()) {
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
        List<ObjetInterface> meilleurVoisin = new ArrayList<>();
        for (int index=0; index < solutionInitiale.size(); index++) {
            List<ObjetInterface> voisinCourant = new ArrayList<>(solutionInitiale);
            voisinCourant.remove(index);
            int[] sommeDesCoutsDeLaSousListe = Utils.sommeDesCouts(voisinCourant);
            for (ObjetInterface obj: objetsNonInclus) {
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