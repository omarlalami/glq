package tp2.compteur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompteurTest {

	//question 1 :

	// a chaque fois qu'on appel un test, BeforeEach est appelé avant donc creation d'instance du coup on ne sais pas excatement qu'elle est la valeur
	// la solution c'est de mettre a 0 la variable comme ca nos tests seront independant
	

	// question 2 :
	
	Compteur c1,c2,c3;
	
	@BeforeEach
	void setUp() throws Exception {
		java.lang.reflect.Field nbInstance;

		try {
			nbInstance = Compteur.class.getDeclaredField("nombreDInstances");
			//nbInstance.setAccessible(true);
			nbInstance.set(null, 0);
		} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
			e.printStackTrace();
		}

		c1 = new Compteur();
		c2 = new Compteur(5);
		c3 = new Compteur(10,2);
	}

	@Test
	void testIncremente() {
		c3.incremente();
		c2.incremente();
		c1.incremente();
		assertEquals(c1.valeur(),1);
		assertEquals(c2.valeur(),6);
		assertEquals(c3.valeur(),12);
	}

	@Test
	void testRemetAZero() {
		c3.remetAZero();
		assertEquals(c3.valeur(),0);
	}
	
	@Test
	void testGetNbInstance() {
		assertEquals(3, Compteur.getNbInstance());
	}
	
}
