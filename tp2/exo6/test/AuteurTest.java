package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp2.bibliotheque.Auteur;

public class AuteurTest {

    private Auteur victorHugo, alexandreDumas, celine;
    
	@BeforeEach
	public void setUp() throws Exception {
		victorHugo = new Auteur( "Hugo", "Victor");
		alexandreDumas = new Auteur( "Dumas", "Alexandre");
		celine = new Auteur( "Celine");
	}
	
	@Test
	public void testToString() {
		assertEquals("Victor Hugo", victorHugo.toString());
		assertEquals("Alexandre Dumas", alexandreDumas.toString());
		assertEquals("Celine", celine.toString());
	}

	@Test
	public void testAuteur() {
		assertThrows(NullPointerException.class, () -> new Auteur(null));
	}
}