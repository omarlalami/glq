package tp2.compteur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompteurSingletonTest {

	
	// q3 : je ne trouve pas de probleme ....
	
	CompteurSingleton c1;

	
	@BeforeEach
	void setUp() throws Exception {
		
		// mettre instorspection ici
		c1 = CompteurSingleton.instance();
	}

	@Test
	void testIncremente() {
		c1.incremente();
		assertEquals(c1.valeur(),10);
//		c2.incremente();
//		assertEquals(c2.valeur(),20);

	}
			// ce test est dependant du precedant , et du coup c'est pas bon
			// ce quil faut faire cest mettre une introspection Reflection pour recuperer le constructeur de compteurSingleton et l'appelé dans SetUp()
	@Test
	void testIncremente2() {
		c1.incremente();
		assertEquals(c1.valeur(),10);
//		c2.incremente();
//		assertEquals(c2.valeur(),20);

	}

	@Test
	void testRemetAZero() {
		c1.remetAZero();
		assertEquals(c1.valeur(),0);	
	}

}
