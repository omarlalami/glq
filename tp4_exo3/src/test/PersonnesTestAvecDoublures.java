package test;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnes.IPersonne;
import personnes.Personnes;

class PersonnesTestAvecDoublures {
	
	private List<IPersonne> populationVide, populationAleatoire, populationMemeAge, populationEntre10Et50ans;
	private Date date;
	
	@BeforeEach
	void setUp() throws Exception {
		date = new Date();		
		
		populationVide = new ArrayList<IPersonne>();
		
		populationMemeAge = new ArrayList<IPersonne>();
		for (int i = 0; i < 5; i++ ) {
			populationMemeAge.add( new DoublureDePersonne( 10));
		}
		
		populationEntre10Et50ans = new ArrayList<IPersonne>();
		populationEntre10Et50ans.add( new DoublureDePersonne( 50));
		populationEntre10Et50ans.add( new DoublureDePersonne( 50));
		populationEntre10Et50ans.add( new DoublureDePersonne( 10));
		populationEntre10Et50ans.add( new DoublureDePersonne( 30));
		populationEntre10Et50ans.add( new DoublureDePersonne( 10));
		
		populationAleatoire = new ArrayList<IPersonne>();
		for ( int i = 0; i<100; i++)
			populationAleatoire.add( new DoublureDePersonne());
	}

	@AfterEach
	void tearDown() throws Exception {
		populationVide = null;
		populationAleatoire = null;
		populationMemeAge = null;
		populationEntre10Et50ans = null;
	}
	
	@Test
	void testLePlusGrandAge1() {
		assertThrows( NoSuchElementException.class, 
				() -> Personnes.lePlusGrandAge(populationVide, date));
	}
	
	@Test
	void testLePlusGrandAge2() {
		assertThrows( NoSuchElementException.class, 
				() -> Personnes.lePlusGrandAge(populationVide));
	}
	
	@Test
	void testLePlusGrandAge3() {
		try {
			assertEquals( 10, Personnes.lePlusGrandAge(populationMemeAge));
			assertEquals( 10, Personnes.lePlusGrandAge(populationMemeAge, date));
			assertEquals( 50, Personnes.lePlusGrandAge(populationEntre10Et50ans));
			assertEquals( 50, Personnes.lePlusGrandAge(populationEntre10Et50ans, date));
		} catch ( RuntimeException e) { fail( "Acces au prenom de la personne"); }
	}

	@Test
	void testLePlusGrandAge4() {
		try {
			int max = Personnes.lePlusGrandAge(populationAleatoire);
			assertEquals( max, Personnes.lePlusGrandAge(populationAleatoire, date));
			for (IPersonne p: populationAleatoire)
				assertTrue( p.getAge() <= max);
		} catch ( RuntimeException e) { fail( "Acces au prenom de la personne"); }
	}
}