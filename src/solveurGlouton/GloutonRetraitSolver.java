package solveurGlouton;

import java.util.*;

/**
 * Résout le problème du sac à dos multidimensionnel grâce à une méthode
 * gloutonne par retrait : on débute par une liste de tous nos objets triés
 * du moins au plus interessant. On retire les éléments un par un jusqu'à
 * respecter les contraintes de buget. On va ensuite trier les objets retirés
 * du plus au moins interessant et essayer de les ajouter aux objets conservés,
 * tout en respectant les budgets.
 *
 * @author clara baigneres
 * @version 1.0
 */
public class GloutonRetraitSolver {

    /**
     * Résout le problème avec la méthode gloutonne par retrait
     * @param sacADos un sac à dos respectant les contraintes de mon interface SacADosInterface
     * @return result, la liste de tous les objets conservés pour mon sac à dos.
     * @throws Exception dans le cas où TriParUtiliteSurCout, consoCourante, allSmaller, substractCoordinates
     * ou addCoordinates renvoie une erreur.
     */
    public static List<ObjetInterface> resoudre(SacADosInterface sacADos) throws Exception {

        /*
         La variable result contient initialement tous les objets. Elle sera retournée à la fin de cette méthode.
         Elle contiendra tous les objets retenus pour le sac à dos.
        */
        List<ObjetInterface> result = new ArrayList<>(sacADos.getObjets());

        /*
         On utilise un comparateur specifique pour trier la liste de l'objet du moins intéressant
         au plus intéressant.
        */
        TriParUtiliteSurCout comparatorPourRetrait = new TriParUtiliteSurCout(sacADos);

        // On trie les objets du moins intéressant au plus intéressant grâce à notre comparateur
        result.sort(comparatorPourRetrait);
        Collections.reverse(result);

        /*
         On calcule la consomation courrante de tous les objets.
         Tant que une (ou plus) de ces consos est supérieure au budget correspondant
         on retire le premier objet de notre liste, que l'on conserve dans une nouvelle
         liste "objetsRetires".
        */
        int[] consoCourante = GloutonRetraitSolver.consoCourante(result);
        List<ObjetInterface> objetsRetires = new ArrayList<>();
        while (!Utils.allSmaller(consoCourante, sacADos.getBudgets())) {
            ObjetInterface objetRetire = result.removeFirst();
            objetsRetires.add(objetRetire);
            consoCourante = Utils.substractCoordinates(consoCourante, objetRetire.getCouts());
        }

        /*
         La liste "result" est acceptable en terme de cout.
         On va essayer d'ajouter certains objets de la liste "objetsRetires".
         On commence par la trier.
        */
        TriParUtiliteSurSommeDesCouts comparatorPourAjout = new TriParUtiliteSurSommeDesCouts();
        objetsRetires.sort(comparatorPourAjout);

        /*
         On parcourt tous les objets retirés et on insère ce qu'il est possible
         de garder.
        */
        for (ObjetInterface objetCandidat: objetsRetires) {
            int[] consoCandidate = Utils.addCoordinates(consoCourante, objetCandidat.getCouts());
            if (Utils.allSmaller(consoCandidate, sacADos.getBudgets())) {
                consoCourante = consoCandidate;
                result.add(objetCandidat);
            }
        }
        /*
         On renvoie la liste contenant tous les objets conservés pour
         notre sac à dos
        */
        return result;

    }


    /**
     * Calcule la consommation par couts, d'une liste d'objets
     * @param objets une liste d'objets qui respectent les contraintes de mon interface ObjetInterface
     * @returnla la consommation par couts, d'une liste d'objets
     * @throws Exception dans le cas où addCoordinates renvoie une erreur
     */
    private static int[] consoCourante(List<ObjetInterface> objets) throws Exception {

        // Si la lise est vide, on renvoie 0
        if (objets.isEmpty()) {
            return new int[0];
        }

        /*
         on crée une liste "conso" de la taille du nombre de couts de notre
         premier élément de la liste. On initalise ses valeurs à 0
        */
        int[] conso = new int[objets.getFirst().getCouts().length];
        Arrays.fill(conso, 0);

        /*
         Pour tous les objets de ma liste, j'ajoute les consommations de chacun de
         ses couts à "conso"
        */
        for (ObjetInterface o: objets) {
            conso = Utils.addCoordinates(conso, o.getCouts());
        }

        // On renvoie la consommation, par couts, de la liste d'objets
        return conso;
    }

    
}
