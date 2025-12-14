package solveurGlouton;

import java.util.*;

public class GloutonRetraitSolver {

    public static List<ObjetInterface> resoudre(SacADosInterface sacADos, Comparator<ObjetInterface> comparator) throws Exception {

        // La variable result contient initialement tous les objets. Elle sera retournée à la fin de cette méthode.
        // Elle contiendra tous les objets retenus pour le sac à dos.
        List<ObjetInterface> result = new ArrayList<>(sacADos.getObjets());

        // On utilise un comparateur specifique pour trier la liste de l'objet le moins intéressant
        // au plus intéressant.
        TriParUtiliteSurCout comparatorPourRetrait = new TriParUtiliteSurCout(sacADos);

        // On trie les objets du moins intéressant au plus intéressant
        result.sort(comparatorPourRetrait);
        Collections.reverse(result);

        // On calcule la consomation courrante de tous les objets.
        // Tant que une (ou plus) de ces consos est supérieure au budget correspondant
        int[] consoCourante = GloutonRetraitSolver.consoCourante(result);
        List<ObjetInterface> objetsRetires = new ArrayList<>();
        while (!Utils.allSmaller(consoCourante, sacADos.getBudgets())) {
            ObjetInterface objetRetire = result.removeFirst();
            objetsRetires.add(objetRetire);
            consoCourante = Utils.substractCoordinates(consoCourante, objetRetire.getCouts());
        }

        // La liste "result" est acceptable en termes de cout.
        // On va essayer d'ajouter certains objets de la liste "objetsRetires".
        // On commence par la trier.
        TriParUtiliteSurSommeDesCouts comparatorPourAjout = new TriParUtiliteSurSommeDesCouts();
        objetsRetires.sort(comparatorPourAjout);

        // On parcourt tous les objets retirés et on insère ceux qu'il est possible
        // de garder.
        for (ObjetInterface objetCandidat: objetsRetires) {
            int[] consoCandidate = Utils.addCoordinates(consoCourante, objetCandidat.getCouts());
            if (Utils.allSmaller(consoCandidate, sacADos.getBudgets())) {
                consoCourante = consoCandidate;
                result.add(objetCandidat);
            }
        }

        return result;

    }



    private static int[] consoCourante(List<ObjetInterface> objets) throws Exception {
        if (objets.isEmpty()) {
            return new int[0];
        }
        int[] conso = new int[objets.getFirst().getCouts().length];
        Arrays.fill(conso, 0);
        for (ObjetInterface o: objets) {
            conso = Utils.addCoordinates(conso, o.getCouts());
        }
        return conso;
    }

    
}
