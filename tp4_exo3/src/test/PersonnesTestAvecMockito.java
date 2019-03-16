package test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnes.IPersonne;
import personnes.Personnes;

class PersonnesTestAvecMockito {
	
	private List<IPersonne> populationVide, populationMemeAge, populationEntre10Et50ans, populationAleatoire;	
	private IPersonne p10, p30, p50, p;
	private Date date;
	private static final Random RANDOM = new Random(10);
	
	@BeforeEach
	void setUp() throws Exception {
		date = new Date();
		p10 = mock( IPersonne.class);
		p30 = mock( IPersonne.class);
		p50 = mock( IPersonne.class);
		p = mock( IPersonne.class);
		when(p10.getAge()).thenReturn(10);
		when(p10.getAge(anyObject())).thenReturn(10);
		when(p30.getAge()).thenReturn(30);
		when(p30.getAge(anyObject())).thenReturn(30);
		when(p50.getAge()).thenReturn(50);
		when(p50.getAge(anyObject())).thenReturn(50);
		int age = Math.abs(RANDOM.nextInt()) % 121;
		when(p.getAge()).thenReturn( age);
		when(p.getAge(anyObject())).thenReturn( age);

		
		populationVide = new ArrayList<IPersonne>();
		
		populationMemeAge = new ArrayList<IPersonne>();
		for (int i = 0; i < 20; i++ ) {
			populationMemeAge.add( p10);
		}
		
		populationEntre10Et50ans = new ArrayList<IPersonne>();
		populationEntre10Et50ans.add( p10);
		populationEntre10Et50ans.add( p10);
		populationEntre10Et50ans.add( p50);
		populationEntre10Et50ans.add( p10);
		populationEntre10Et50ans.add( p30);
		populationEntre10Et50ans.add( p10);
		populationEntre10Et50ans.add( p30);
		populationEntre10Et50ans.add( p50);
		populationEntre10Et50ans.add( p50);
		populationEntre10Et50ans.add( p50);
		populationEntre10Et50ans.add( p10);
		
		populationAleatoire = new ArrayList<IPersonne>();
		for ( int i = 0; i<100; i++)
			populationAleatoire.add( p);

	}
	
	@Test
	public void testLePlusGrandAge1() {
		assertThrows(NoSuchElementException.class, 
				() -> Personnes.lePlusGrandAge(populationVide, date));
	}
	
	@Test
	public void testLePlusGrandAge2() {
		assertThrows(NoSuchElementException.class, 
				() -> Personnes.lePlusGrandAge(populationVide));
	}
		
	@Test
	public void testLePlusGrandAge3() {
		assertEquals( 10, Personnes.lePlusGrandAge(populationMemeAge));
		assertEquals( 10, Personnes.lePlusGrandAge(populationMemeAge, date));
		assertEquals( 50, Personnes.lePlusGrandAge(populationEntre10Et50ans));
		assertEquals( 50, Personnes.lePlusGrandAge(populationEntre10Et50ans, date));
		assertEquals( 50, Personnes.lePlusGrandAge(
				Arrays.asList(new IPersonne[] {p50,p10,p30,p10})));	
		assertEquals( 50, Personnes.lePlusGrandAge(
				Arrays.asList(new IPersonne[] {p50,p10,p30,p10}), date));	
		assertEquals( 50, Personnes.lePlusGrandAge(
				Arrays.asList(new IPersonne[] {p10,p30,p30,p50})));	
		assertEquals( 50, Personnes.lePlusGrandAge(
				Arrays.asList(new IPersonne[] {p10,p30,p30,p50}), date));	
		verify(p10, atLeast(1)).getAge();
		verify(p30, atLeast(1)).getAge();
		verify(p50, atLeast(1)).getAge();
		verify(p10, atLeast(1)).getAge( date);
		verify(p50, atLeast(1)).getAge( date);		
		verify(p10, never()).getNom();
		verify(p30, never()).getNom();
		verify(p50, never()).getNom();
		verify(p10, never()).getPrenom();
		verify(p30, never()).getPrenom();
		verify(p50, never()).getPrenom();
	}
	
	@Test
	public void testLePlusGrandAge4() {
		int max = Personnes.lePlusGrandAge(populationAleatoire);
		assertEquals( max, Personnes.lePlusGrandAge(populationAleatoire, date));
		for (IPersonne p: populationAleatoire)
			assertTrue( p.getAge() <= max);
		verify(p, atLeast(1)).getAge();
		verify(p, atLeast(1)).getAge( date);
		verify(p, never()).getNom();
		verify(p, never()).getPrenom();
	}

}