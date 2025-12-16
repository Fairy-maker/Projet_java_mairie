package solveurGlouton;

/**
 * Une interface qui définit ce qu'un objet doit avoir :
 * <ul>
 *  * <li> un getUtilite (qui renvoie l'utilité de l'objet en int) </li>
 *  * <li> un getCout (qui renvoie le tableau des couts de l'objet) </li>
 *  * </ul>
 */
public interface ObjetInterface {
	int getUtilite();
	int[] getCouts();
}
