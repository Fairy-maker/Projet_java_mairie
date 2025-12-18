package solveurGlouton;

import java.util.List;

/**
 * Une interface qui définit ce qu'un sac à dos doit avoir :
 * <ul>
 *  * <li> un getDimension (qui renvoie la dimension de notre sac à dos en int) </li>
 *  * <li> un getBudget (qui renvoie le tableau des budgets du sac à dos) </li>
 *  * <li> un getObjets (qui renvoie la liste des objets présents dans le sac à dos
 *          et qui respectent mon interface OvjetInterface)</li>
 *  * </ul>
 *  @author clara baigneres
 *  @version 1.0
 */

public interface SacADosInterface {
	int getDimension();
	int[] getBudgets();
	List<ObjetInterface> getObjets();
}
