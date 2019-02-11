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
		catch (ExceptionSoldeInsuffisant e) { System.err.println(e.getMessage()); }
		
		//try { CompteAnonyme.virement(c1, c4, -20);} 
		//catch (ExceptionSoldeInsuffisant e) { System.err.println(e.getMessage()); } 
		
		
		// question 3 explication de la prof :
		// depot c'est RuntimeException ou sous classe donc pas obligé de mettre throws
		// en général c'est a eviter car les personnes qui vont la réutilisé pour coder ne seront pas au courant
		// de préference on utilise des sous classes de Exception comme ca on est averti de l'exception
		
		// question 3 :
		// je sais pas comment faire ce qu'elle demande, j'ai ajouter une java.lang.RuntimeException pour depot 
		
		//c1.depot(2587);
		//CompteAnonyme.virement(c1, c4, -20);
		
		try { c1.depot(-20);} 
		catch(java.lang.RuntimeException e) {System.err.println(e.getMessage());}
		// pour cette exemple c'est pas bien d'attraper qu'un seul exception général
		// il faut toujours attrapé des exception précises comme ca on évite d'attraper une exception non traité ( division par 0 ) par exemple
		
		
		
		// dans catch on est obligé de mettre IllegalArgumentException sinon on a une erreur
		// pour RuntimeException sa nous affiche pas derreur
		
		
		// question 4
		// elles doivent etre controlé ... par définnition
		
		//controlés :
		//ExceptionSoldeInsuffisant hérite de exception
		//java.lang.UnsupportedOperationException
		
		// non controlé :
		//java.lang.IllegalArgumentException hérite de java.lang.RuntimeException
		//java.lang.RuntimeException
		//java.lang.Error
		
		// q4 prof :
		// dans le cas ou le depot peut etre rentré par lutilisateur alors on devrait attrapé l'erreur si c'est négatif
		// on la mettrait comme java.lang.UnsupportedOperationException car c'est une erreur qui peut avoir lieu
		// dans notre cas on suppose que l'erreur n'arrivera pas donc on peut la laissez comme ca
		// c'est une erreur qui na pas lieu d'arrivé par définition
		
		
	}

}
