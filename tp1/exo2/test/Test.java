package test;

import banque.*;
import personne.Personne;

public class Test {

	public static void main(String[] args) {

		// question 1 : on n'a pas de soucis avec SpotBugs : 0 bugs
		
		// question 2 : pour les modifs voir les fichiers concernés
		
		Personne p1 = new Personne("nom1","prenom1",1995,'h');
		Personne p2 = new Personne("nom2","prenom2",1994,'f');
		
		CompteAnonyme c1 = new Compte(p1, 100.0f);
		CompteAnonyme c2 = new ComptePlacement(p2, 1000);
		CompteAnonyme c3 = new CompteRemunere(p1, 2000);
		CompteAnonyme c4 = new CompteAnonyme(5000);
		
		System.out.println("");
		System.out.println("");
		
		try { c1.depot(-10); } 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); }
		
		try { c2.depot(500);} 
		catch (UnsupportedOperationException e) { System.err.println(e.getMessage()); }
		
		try { c3.retrait(-50);} 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); }
		
		try { c4.retrait(-20);} 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); }
		
		try { CompteAnonyme.virement(c1, c4, 5200);} 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); }
		
		try { CompteAnonyme.virement(c1, c4, -20);} 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); } 
		
		// question 3 :
		// je sais pas comment faire ce qu'elle demande, j'ai ajouter une java.lang.RuntimeException pour depot 
		
		c1.depot(2587);
		
		try { c1.depot(2587);} 
		catch(java.lang.IllegalArgumentException e) {System.err.println(e.getMessage());}
		// dans catch on est obligé de mettre IllegalArgumentException sinon on a une erreur
		// pour RuntimeException sa nous affiche pas derreur
		
		
		// question 4
		// elles doivent etre controlé ... par définnition
		
		//controlés :
		//java.lang.IllegalArgumentException
		//ExceptionSoldeInsuffisant hérite de IllegalArgumentException
		//java.lang.UnsupportedOperationException
		
		// non controlé :
		//java.lang.RuntimeException
		//java.lang.Error
		
		
		
	}

}
