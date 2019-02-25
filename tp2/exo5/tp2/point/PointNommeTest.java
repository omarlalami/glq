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
		System.out.println("coucou");
	}

	@Test
	void testToString() {
		 assertEquals("mon point 3(2,3)",p3.toString());
	}
	
	@Test
	void testAfficher() {
		fail("Not yet implemented");
	}
	
	@Override
	protected Point creer() {
		return new PointNomme("A");
	}

	@Override
	protected Point creer(int i) {
		return new PointNomme(i,"B");
	}

	@Override
	protected Point creer(int i, int j) {
		// TODO Auto-generated method stub
		return new PointNomme(i,j,"C");
	}


}
