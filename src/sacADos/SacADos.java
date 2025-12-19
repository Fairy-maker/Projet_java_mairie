package sacADos;

import java.rmi.UnexpectedException;
import java.util.Arrays;
import java.util.List;

import solveurGlouton.*;

/**
 * Sac à dos
 *
 * Représente un sac à dos avec un ensemble d’objets et des budgets.
 * Permet de résoudre le problème avec différentes méthodes.
 * Utilisé par les solveurs gloutons (ajout et retrait) et hill climbing.
 */

public class SacADos implements SacADosInterface {

    private final int[] budgets;
    private final List<ObjetInterface> objets;

    /**
     * Constructeur SacADos
     *
     * Initialise un sac à dos avec ses budgets et sa liste d’objets.
     *
     * @param budgets int[] tableau des limites maximales pour chaque dimension
     * @param objets List<ObjetInterface> liste des objets disponibles
     */
    public SacADos(int[] budgets, List<ObjetInterface> objets) {
        this.budgets = budgets.clone(); // on clone le tableau budget pour ne pas etre impacté par une modification ultérieure faite a l'exterieur
        this.objets = objets;
    }

    /**
     * Obtenir dimension
     *
     * Retourne le nombre de dimensions du sac (taille du tableau budgets).
     *
     * @return int nombre de dimensions
     */
    @Override
    public int getDimension() {
        return this.budgets.length;
    }

    /**
     * Obtenir budgets
     *
     * Retourne une copie des budgets du sac.
     *
     * @return int[] budgets
     */

    @Override
    public int[] getBudgets() {
        return budgets.clone();
    }

    /**
     * Obtenir objets
     *
     * Retourne la liste des objets du sac.
     *
     * @return List<ObjetInterface> objets
     */
    @Override
    public List<ObjetInterface> getObjets() {
        return objets;
    }

    /**
     * Calcul utilité totale
     *
     * Calcule la somme des utilités de tous les objets dans le sac.
     *
     * @return int utilité totale
     */
    public int getUtiliteTotale() {
        int total = 0;
        for (ObjetInterface o : objets) total += o.getUtilite();
        return total;
    }

    /**
     * Résoudre sac
     *
     * Résout le problème du sac à dos avec une méthode choisie.
     *
     * @param methodeDeResolution MethodeDeResolution à utiliser (glouton, hill climbing, etc.)
     * @return List<ObjetInterface> solution du sac
     * @throws Exception si la méthode n’est pas connue
     */
    public List<ObjetInterface> resoudre(MethodeDeResolution methodeDeResolution) throws Exception {

        switch (methodeDeResolution) {

            case GLOUTON_A_AJOUT:

                return GloutonAjoutSolver.resoudre(this);

            case GLOUTON_A_RETRAIT:

                return GloutonRetraitSolver.resoudre(this);

            case HILL_CLIMBING_SIMPLE:

                List<ObjetInterface> solutionInitiale =
                        GloutonRetraitSolver.resoudre(this);

                return HillClimbingSolver.resoudre(this, Arrays.asList(solutionInitiale));

            case HILL_CLIMBING_MULTIPLE:

                List<ObjetInterface> solutionInitiale1 =
                        GloutonAjoutSolver.resoudre(this);

                List<ObjetInterface> solutionInitiale2 =
                        GloutonRetraitSolver.resoudre(this);

                List<List<ObjetInterface>> solutionsInitiales = Arrays.asList(solutionInitiale1, solutionInitiale2);

                return HillClimbingSolver.resoudre(this, solutionsInitiales);

        }

        throw new UnexpectedException("La cas n'est pas connu");

    }

}
	
