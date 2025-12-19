package solveurGlouton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe d'utilitaires pour alléger le code des autres classes.
 */
public abstract class Utils {

    /**
     * Calcule la somme des éléments de deux tableaux, indice par indice
     *
     * @param a un tableau
     * @param b un autre tableau
     * @return un tableau avec la somme des valeurs des tableux a et b,
     * indice par indice
     * @throws IllegalArgumentException dans le cas où nos deux tableaux sont de tailles différentes
     */
    public static int[] addCoordinates(int[] a, int[] b) throws IllegalArgumentException {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays of different sizes");
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] + b[i];
        }
        return result;
    }

    /**
     * Calcule la différence des éléments de deux tableaux, indice par indice
     *
     * @param a un tableau
     * @param b un autre tableau
     * @return nun tableau avec la différence des valeurs des tableux a et b,
     * indice par indice
     * @throws IllegalArgumentException dans le cas où nos deux tableaux sont de tailles différentes
     */
    public static int[] substractCoordinates(int[] a, int[] b) throws IllegalArgumentException {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays of different sizes");
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }

    /**
     * Vérifie si les éléments d'un tableau a sont bien inférieurs aux éléments
     * d'un tableau bounds, indice par indice
     *
     * @param a      le tableau qu'on compare
     * @param bounds le tableau avec nos limites
     * @return false si une valeure à indice i de a est supérieur à l'élément à
     * l'indice i de bounds, true sinon
     * @throws IllegalArgumentException dans le cas où nos deux tableaux sont de tailles différentes
     */
    public static boolean allSmaller(int[] a, int[] bounds) throws IllegalArgumentException {
        if (a.length != bounds.length) {
            throw new IllegalArgumentException("Arrays of different sizes");
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > bounds[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * On cherche la valeure maximale d'un tableau
     *
     * @param a un tableau
     * @return la valeure maximale du tableau a
     * @throws IllegalArgumentException dans le cas où a est un tableau vide
     */
    public static int maxValue(int[] a) throws IllegalArgumentException {
        if (a.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int currentMax = a[0];
        for (int val : a) {
            if (currentMax < val) {
                currentMax = val;
            }
        }
        return currentMax;
    }

    /**
     * On cherche l'indice d'une certaine valeure entrée en paramètre
     *
     * @param valueToFind la valeure à chercher dans notre tableau
     * @param a           un tableau
     * @return une liste avec tous les indices où l'on retrouve la valeure recherchée dans
     * notre tableau
     */
    public static ArrayList<Integer> indicesOfValue(int valueToFind, int[] a) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (valueToFind == a[i]) {
                indices.add(i);
            }
        }
        return indices;
    }

    /**
     * On cherche l'indice de la valeure maximale de notre tableau
     *
     * @param a un tableua
     * @return une liste avec tous les indices où l'on retrouve la valeure maximale de notre
     * tableau dans notre tableau
     */
    public static ArrayList<Integer> indicesOfMaxValue(int[] a) {
        int maxValue = maxValue(a);
        return indicesOfValue(maxValue, a);
    }

    /**
     * Calcule la somme de chacun des couts d'une liste d'objets
     *
     * @param objets liste d'objets qui respectent les contraintes de mon interface ObjetInterface
     * @param nombreDeCouts taille attendue que le nomre de couts de chaque objet
     * @return un tableau "somme" avec la somme de chacun des couts de ma liste d'objets
     * @throws IllegalArgumentException dans le cas où addCoordinates renvoie une erreur
     */
    public static int[] sommeDesCouts(List<ObjetInterface> objets, int nombreDeCouts) throws IllegalArgumentException {

        int[] somme = new int[nombreDeCouts];
        Arrays.fill(somme, 0);
        for (ObjetInterface obj : objets) {
            somme = Utils.addCoordinates(somme, obj.getCouts());
        }
        return somme;
    }

    /**
     * Calcule la somme des utilités d'une liste d'objets
     *
     * @param objets liste d'objets qui respectent les contraintes de mon interface ObjetInterface
     * @return la somme des utilités d'une liste d'objets
     */
    public static int utilite(List<ObjetInterface> objets) {
        int utilite = 0;
        for (ObjetInterface obj : objets) {
            utilite += obj.getUtilite();
        }
        return utilite;
    }

}
