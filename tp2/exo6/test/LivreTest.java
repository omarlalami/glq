package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp2.bibliotheque.Auteur;
import tp2.bibliotheque.Livre;

class LivreTest {

	Livre l1,l2,l3;
	private Auteur alexandreDumas = new Auteur( "Dumas", "Alexandre");
	private Auteur ReneGoscinny = new Auteur( "Goscinny", "Rene");
	private Auteur AlbertUderzo = new Auteur( "Uderzo", "Albert");
	
	@BeforeEach
	void setUp() throws Exception {
		l1 = new Livre("Les trois mousquetaires",alexandreDumas);
		l2 = new Livre("Bourbon Kid");
		l3 = new Livre("Asterix le Gaulois",ReneGoscinny,AlbertUderzo);
	}

	@Test
	void testToString() {
		assertEquals("Les trois mousquetaires [Alexandre Dumas]", l1.toString());
		assertEquals("Bourbon Kid", l2.toString());
		assertEquals("Asterix le Gaulois [Rene Goscinny, Albert Uderzo]", l3.toString());
	}

}
