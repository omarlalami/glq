package tp2.compteur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompteurSingletonTest {

	
	// q3 : je ne trouve pas de probleme ....
	
	CompteurSingleton c1;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = CompteurSingleton.instance();
	}

	@Test
	void testIncremente() {
		c1.incremente();
		assertEquals(c1.valeur(),10);

	}

	@Test
	void testRemetAZero() {
		c1.remetAZero();
		assertEquals(c1.valeur(),0);	
	}

}
