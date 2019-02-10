package exo_1_prof;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestPaire {

	private static void testMemePremier() {
		Paire<Integer,String> p1 = new Paire<>(9,"plus grand chiffre");
		Paire<Integer,Integer> p2 = new Paire<>(9,10);
		assert p1.<Integer,Integer>memePremier(p2);
		assert p1.<Integer>memePremier2(p2);		
	}
	
	private static void testCopiePremierAvec3Parametres()  {
		Paire<Integer,String> p1 = new Paire<>(9,"plus grand chiffre");
		Paire<Integer,Integer> p2 = new Paire<>(9,10);
		Integer [] tab = new Integer[1];
		tab[0]=0;Paire.<Integer,String>copiePremier(p1,tab,0);
		assert ( tab[0].equals(9) &&  tab[0]==9 && tab[0].equals( Integer.valueOf(9)) && tab[0] == Integer.valueOf(9)) ;
		tab[0]=0;Paire.<Integer>copiePremier2(p1,tab,0);
		assert tab[0].equals(9) &&  tab[0]==9 && tab[0].equals( Integer.valueOf(9)) && tab[0] == Integer.valueOf(9) ;
		assert p1.getClass() == p2.getClass() ;
		assert( p1.getClass().getSimpleName().equals( "Paire"));
	}
	
	private static void testGetNbInstances()  {
		ArrayList<Paire<?,?>> l = new ArrayList<> ();
		for (int i = 0; i<5; i++) l.add( new Paire<Integer,Integer>(7+i,2*i));
		for (int i = 0; i<3; i++) l.add( new Paire<Integer,String>());
		for (int i = 0; i<2; i++) l.add( new Paire<Float,Float>());
		assert( Paire.getNbInstances() == 14);
	}

	private static void test4()  {
		//Paire<Object,Object> p3 = new Paire<String,String>(); // ERREUR de COMPILATION : 
		// Type mismatch: cannot convert from Paire<String,String> to Paire<Object,Object>
		Paire<?,?> p4 = new Paire<Integer,String>();
		((Paire<Integer,String>)p4).setPremier(12); // (cast obligatoire)
		assert (p4.toString().equals("(12,null)"));
		p4 = new Paire<String,Double>();
		((Paire<String,Double>)p4).setPremier("ok"); // (cast obligatoire)
		assert (p4.toString().equals("(ok,null)"));
	}
	
	private static void testPrendPremier()  {
		Paire<Object,String> p5 = new Paire<>();
		List<Object> lo= new LinkedList<>();
		List<Integer> li = new LinkedList<>();
		li.add( Integer.valueOf(5)); 
		lo.add(2.5f);  
		p5.prendPremier(lo); assert (Float)p5.getPremier() == 2.5f ;
		p5.prendPremier(li); assert (Integer)p5.getPremier() == 5;
		li.add( 0, Integer.valueOf(10)); 
		lo.add(0, 5.f);  
		p5.prendPremier2(lo); assert (Float)p5.getPremier() == 5.f ;
		p5.prendPremier2(li); assert (Integer)p5.getPremier() == 10;
	}
	
	private static void testCopiePremierAvec2Parametres()  {
		Paire<Integer,Integer> p6 = new Paire<>(9,10);
		Collection<Object> co = new LinkedList<>();
		Collection<Integer> ci = new LinkedList<>();
		Paire.copiePremier(p6,co); 
		Paire.copiePremier(p6,ci);
		assert co.toString().equals("[9]");
		assert ci.toString().equals("[9]");
		co = new LinkedList<>();
		ci = new LinkedList<>();
		Paire.copiePremier2(p6,co); 
		Paire.copiePremier2(p6,ci);
		assert co.toString().equals("[9]");
		assert ci.toString().equals("[9]");
	}
	
	private static void finDuTest() {
		assert false:"Fin du test";		
	}

	public static void main(String [] args) {		
		testMemePremier();
		testCopiePremierAvec3Parametres();
		testGetNbInstances();
		test4();
		testPrendPremier();
		testCopiePremierAvec2Parametres();
		finDuTest();
	}
}
