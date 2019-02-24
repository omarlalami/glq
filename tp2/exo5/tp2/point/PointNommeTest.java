package tp2.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointNommeTest extends AbstraitePointTest{
	
	/*Reponse aux questions
	 * Quel est le risque si ces contraintes ne sont pas vérifiées?
	 * on risque d'avoir deux objets qui n'ont pas les memes valeurs mais dont lappel de Equals renvoi True
	 * 
	 * Que se passe-t-il sinon ?
	 * java va croire que ce sont des methodes propres a nous et ne fera pas la verification si on defini correctement les methodes !
	 * 
	 * 
	 * remarque : je nai pas mis en place le dernier truc pour l'affichage
	 * */

	@BeforeEach
	void setUp() throws Exception {
		p1 = new PointNomme("mon point 1");
		p2 = new PointNomme(1,"mon point 2");
		p3 = new PointNomme(2,3,"mon point 3");
	}

	@Test
	void testToString() {
		 assertEquals("mon point 3(2,3)",p3.toString());
	}
	
	@Test
	void testAfficher() {
		fail("Not yet implemented");
	}

}
