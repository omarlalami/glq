package exo_1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestPaire {

	public static void main(String [] args) {		

	// question 4
	Paire<Integer,String> p0 = new Paire<Integer,String>(9,"plus grand chiffre");
	Paire<Integer,Integer> p1 = new Paire<Integer,Integer>(9,10);
	assert p0.<Integer,Integer>memePremier(p1) == true;
	Integer [] tab = new Integer[1];
	Paire.<Integer,String>copiePremier(p0,tab,0);
	assert tab[0].equals(9) && tab[0]==9 && tab[0].equals( new Integer(9))	&& tab[0] != new Integer(9) ;
	assert p0.getClass() == p1.getClass() ;
	assert p0.getClass().getSimpleName().equals( "Paire");
	assert false:"Fin du test";

	// Question 5
	System.out.println(Paire.getNbInstances());

	
	Paire<String,Integer> p2 = new Paire<String,Integer>("Omar",10);
	
	System.out.println(Paire.getNbInstances()); // car variable de classe

	
	Paire<Double,Integer> p3 = new Paire<Double,Integer>(9.1,10);
	
	p2.getPremier();p3.getPremier();
	System.out.println(Paire.getNbInstances());
	
	//Question 6)
	//Paire<Object,Object> p3 = new Paire<String,String>(); conflit de type
	// ya pas d'heritage entre genericite object vers string
	
	//Question 7 : ca ne marche pas parceque integer n'est pas sous type de ?
	// il faut donc caster
	
	 // les truc en commentaires c'est des enxemple en plus
	  
	Paire<?,?> p4 = new Paire<Integer,String>();
	
	//p4 = new Paire<ArrayList,Double>();
	//p4 = new Paire<Integer,String>();
	
	((Paire<Integer,String>)p4).setPremier(12);
	assert (p4.toString().equals("(12,null)"));
	System.out.println(p4);
	
	/*
	p4 = new Paire<String,String>();
	((Paire<String,String>)p4).setPremier("oui");
	assert (p4.toString().equals("(oui,null)"));
	 */

	
	// question 8 :
	// ma methode est un peu 
	
	Paire<Object,String> p5 = new Paire<Object,String>();
	
	List<Object> lo= new LinkedList<Object>();
	List<Integer> li = new LinkedList<Integer>();
	
	li.add( new Integer(5));
	lo.add(2.5f);
	
	p5.prendPremier(lo); assert (Float)p5.getPremier() == 2.5f ;
	p5.prendPremier(li); assert (Integer)p5.getPremier() == 5;
	
	/*
	Paire<Integer,Integer> p6 = new Paire<Integer,Integer>();
	List<String> ls= new LinkedList<String>();
	ls.add( new String("ee"));
	p6.prendPremier(ls);
	System.out.println(p6.getPremier());
	Integer i = p6.getPremier();

	 */
	
	
	// question 9 :
	
	Paire<Integer,Integer> p6 = new Paire<Integer,Integer>(9,10);
	
	Collection<Object> co = new LinkedList<Object>();
	Collection<Integer> ci = new LinkedList<Integer>();
	
	Paire.copiePremier(p6,co);
	Paire.copiePremier(p6,ci);
	
	assert co.toString().equals("[9]");
	assert ci.toString().equals("[9]");

	
	// question 10, on ne nous demande pas d'uiliser JUnit,
	// juste de completer manuellement, c'est assez complet donc pas la peine
	
	
	// question 11 :
	// ca met des truc sourligné en vert et jaune  ...
	// les truc en rouge ils ne sont pas executer : genre la methode setSecond
	// les truc en rouge ne sont pas couvert du coup on fait ca maintenant
	
	
	Integer tab_a [] =  new Integer [5] ;
	
	Paire<Integer,Integer> p = new Paire<Integer,Integer>(9,10);
	
	
	Paire.copiePremier(p,tab_a,2);

	p.memePremier(p);
	
	
	
	// question 12
	// ca met des lignes en couleur
	// ca nous permet de signalez des lignes en plus vide, des variable non utilisé ...
	// en faite ca check le code selon les convention de sun ou google ou autres ....
	// on peut soit traiter soit ignorer

	
	// question 13
	// ca nous signale des bugs ou trucs suspect
	// on peut soit traiter soit ignorer
	// comme des variable non utilisé par exemple
	
	
	
	
}



}
