package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import equipe.Projet;
import equipe.Secteur;
/**
 * Test unitaire pour la classe VersSacADos
 */
class VersSacADosTest {
	
	// Cas 1 : coût par types de coûts 
	/**
	 * Cette méthode utilise la méthode AAA afin de vérifier qu'on a bien une transformation d'un projet en objet 
	 * de sac à dos dans le cas où les objets sont définis par type de coûts.
	 * Le test s'assure que les coûts sont placés dans le bon ordre dans le tableaux de coûts.
	 */
	@Test
	void testCoutParTypeDeCout() {
		
		//Arrange
	    Projet p = new Projet("Projet Culturel", "Un projet culturel", Secteur.CULTURE);

	    p.getCout().setCoutEco(5);
	    p.getCout().setCoutSocio(2);
	    p.getCout().setCoutEnv(1);
	    
	    p.setBenefice(10);

	    VersSacADos v = new VersSacADos(new int[]{10, 10, 10},List.of(p),Scenario.COUTS_PAR_TYPES_DE_COUT);

	    //Act
	    int[] couts = v.getCouts()[0];

	    //Assert
	    assertEquals(5, couts[0]); // cout économique
	    assertEquals(2, couts[1]); // cout social
	    assertEquals(1, couts[2]); // cout environnemental
	}
	
	//Cas 2 : coût par secteurs : 
	/**
	 * Cette méthode utilise la méthode AAA afin de vérifier qu'on a bien une transformation d'un projet
	 * en objet de sac a dos dans le cas où les objets sont définis par le type de secteurs où seuls le coût économique compte.
	 * Le test s'assure que le coût économique est bien affecté à la dimension correspondant à son secteur et 
	 * ainsi que les autres secteurs ne consomment pas de budgets (dans notre cas).
	 */

	@Test
	void testCoutParSecteur() {  

		// Arrange
		Projet p = new Projet("Projet Culturel", "Un projet culturel", Secteur.CULTURE);

		// On fixe les coûts
		p.getCout().setCoutEco(5); // le projet a un cout economique de 5 et dans notre cas seul ce cout est retenu
		p.getCout().setCoutSocio(2); // cette valeur sera donc ignoré
		p.getCout().setCoutEnv(1); // cette valeur sera aussi ignoré

		p.setBenefice(10); // on dit que l'utilité/bénéfice du projet est de 10

		//Ici on a une instance de VersSacADos qui a 5 budgets (1 par secteurs) rangé par ordre de secteurs
		//On construit le sac a dos en utilisant les secteurs comme dimension (donc dim=5) et le cout economique
		
		VersSacADos v = new VersSacADos( new int[]{10, 10, 10, 10, 10}, List.of(p), Scenario.COUTS_PAR_SECTEUR);

		// Act
		int[] couts = v.getCouts()[0];

		// Assert
		//car on est bien censé avoir en indice 3 (culture), le cout économique de ce projet qui est de 5. 
		// Ici seul le secteur culture consomme du budget
		assertEquals(5, couts[Secteur.CULTURE.ordinal()]); 
		
	}

}
