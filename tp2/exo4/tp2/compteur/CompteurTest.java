package tp2.compteur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompteurTest {

	//question 1 :
	// on ne peut pas tester car on ne sais pas a quel moment TestNbInstance sera appeler
	// si elle est appeler en premier on aura une valeur de 3
	// si c'est la derniere a etre appelé , on aura une valeur de 9
	// car a chaque fois qu'on appel un test BeforeEach est appelé avant donc creation d'instance
	
	
	Compteur c1,c2,c3;
	
	@BeforeEach
	void setUp() throws Exception {
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
		System.out.println("nombre d'instance : " + Compteur.getNbInstance());
	}
	
	// question 2 :
	
	
	@Test
	void testQ2 () {
		java.lang.reflect.Field nbInstance;
		try {
			nbInstance = Compteur.class.getDeclaredField("nombreDInstances");
			nbInstance.setAccessible(true);
			nbInstance.set(null, 10);
		} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("reflection : ");
		testGetNbInstance();
	}

}
