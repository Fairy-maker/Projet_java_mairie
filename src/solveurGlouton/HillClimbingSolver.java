package solveurGlouton;


import java.util.ArrayList;
import java.util.List;

/**
 * Essaie d'améliorer une solution initiale en explorant ses voisins. Si un voisin est en effet
 * une meilleure solution, alors il devient la nouvelle solution courante et la méthode continue
 * jusqu'à ne pas trouver de voisins meilleurs.
 * Pour définir un voisin, nous allons retirer un objet de notre solution initiale et le remplacer par un autre.
 * Deux solutions S et S' sont donc voisines si S' est égale à S à un objet près.
 *
 * @author clara baigneres
 */
public class HillClimbingSolver {

    public static List<ObjetInterface> resoudre(SacADosInterface sacADos, List<List<ObjetInterface>> solutionsInitiales) throws Exception {

        // On applique la méthode Hill Climbing "classique" pour chaque solution initale
        // et on stocke le résultat dans une liste.
        List<List<ObjetInterface>> solutions = new ArrayList<>();
        for (List<ObjetInterface> solutionInitiale: solutionsInitiales) {
            List<ObjetInterface> solution = fonctionHillClimbing(sacADos, solutionInitiale);
            solutions.add(solution);
        }

        // On ne garde que la meilleure des solutions
        List<ObjetInterface> meilleureSolution = solutions.getFirst();
        for (List<ObjetInterface> solutionCourante: solutions) {
            if (Utils.utilite(meilleureSolution) < Utils.utilite(solutionCourante)) {
                meilleureSolution = solutionCourante;
            }
        }

        return meilleureSolution;

    }

    /**
     * résout le problème de sac à dos multidimensionnel avec la méthode du HillClimbing
     * @param sacADos un sac à dos respectant les contraintes de mon interface SacADosInterface
     * @param solutionInitiale Une liste d'objets respecant les contraintes de mon interface ObjetInterface
     *                         et qui constitue la solution initiale pour notre sac à dos
     * @return renvoie la meilleure solution (un voisin ou la solution initiale)
     * @throws Exception dans le cas où la liste de notre solution initiale est vide.
     */
    private static List<ObjetInterface> fonctionHillClimbing(SacADosInterface sacADos, List<ObjetInterface> solutionInitiale) throws Exception {

        /*
         On calcule l'utilité de notre solution initiale. L'objectif va être
         de vérifier si un voisin a une plus grande utilité, mais tout en
         respectant les contraintes de budgets
        */
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

        /*
         S'il n'y a aucun objet non inclus, on a fini (car dans ce cas là
         aucun voisin n'existe)
        */
        if (objetsNonInclus.isEmpty()) {
            return solutionInitiale;
        }

        /*
         On cherche le voisin qui maximise l'utilite
         on initialise utiliteMeilleurVoisin à -1 et une liste meilleurVoisin
         vide, qui contiendra des objets respectant mon interface ObjetInterface
        */

        int utiliteMeilleurVoisin = -1;
        List<ObjetInterface> meilleurVoisin = new ArrayList<>();

        /*
         Pour tous les index, un par un, on crée une liste voisinCourant qui est d'abord
         égale à notre liste solutionInitiale, mais à laquelle on retire l'objet à l'index
         en question. On calcule l'utilité de cette nouvelle liste
        */
        for (int index=0; index < solutionInitiale.size(); index++) {
            List<ObjetInterface> voisinCourant = new ArrayList<>(solutionInitiale);
            voisinCourant.remove(index);
            int[] sommeDesCoutsDeLaSousListe = Utils.sommeDesCouts(voisinCourant);

            /*
             Maintenant pour chaque objet qui n'était pas inclu dans solutionInitiale, on ajoute
             l'objet à voisinCourant (on fait le changement d'un objet de solutionInitiale pour
             créer tous les voisins possibles)
            */
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
            return fonctionHillClimbing(sacADos, meilleurVoisin);
        }

    }

}