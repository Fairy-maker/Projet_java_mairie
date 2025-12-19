package sacADos;

import solveurGlouton.ObjetInterface;

import java.util.Arrays;

/**
 * Objet du sac
 *
 * Représente un objet pouvant être mis dans un sac à dos.
 * Contient son utilité et ses couts pour plusieurs dimension.
 * Permet d'être utilisé par différents solveurs.
 */
public class Objet implements ObjetInterface {

    private int utilite;
    private  int[] couts;

    /**
     * Constructeur Objet
     *
     * Initialise un objet avec son utilité et ses coûts associés.
     *
     * @param utilite : l'utilité de l'objet
     * @param couts : tableau des coûts pour chaque dimension (éco, social, env)
     */
    public Objet(int utilite, int[] couts) {
        this.couts = couts;
        this.utilite = utilite;
    }

    /**
     * Obtenir l'utilité
     *
     * Retourne l'utilité de l'objet.
     *
     * @return int utilité
     */
    @Override
    public int getUtilite() {
        return utilite;
    }

    /**
     * Obtenir coûts
     *
     * Retourne les coûts de l'objet pour toutes les dimensions.
     *
     * @return int[] tableau des coûts
     */
    @Override
    public int[] getCouts() {
        return couts;
    }

    /**
     * Texte objet
     *
     * Renvoie une représentation textuelle de l'objet (utilité et coûts).
     *
     * @return String description de l'objet
     */
    @Override
    public String toString() {
        return "Objet{" +
                "utilite=" + utilite +
                ", couts=" + Arrays.toString(couts) +
                '}';
    }
}
