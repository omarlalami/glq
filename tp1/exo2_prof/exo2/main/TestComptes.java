package exo2.main;

import exo2.personne.Personne;
import exo2.compte.*;

public class TestComptes {

	public static void main(String[] args) {
		/* création de 2 personnes */
		Personne Navet = new Personne ("Navet", "Jean", 1990, 'm'), 
		         Adorer = new Personne ( "Adorer",  "Yvon", 1992, 'm');	
		/* Création de comptes */
		CompteAnonyme c1 = new Compte(Navet, 100.0f);
		CompteAnonyme c2 = new ComptePlacement(Navet, 1000.0f);
		CompteAnonyme c3 = new CompteRemunere(Adorer, 2000.0f);
		CompteAnonyme c4 = new CompteAnonyme(5000.0f);
		
		/* 1 annee passe apres la creation des comptes */
		CompteRemunere.majDate( 365) ;
		System.out.println( c2);
		System.out.println( c3);

		try { c1.depot(-10f); } 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); }
		
		try { c1.depot(0f); } 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); }
		
		try { c2.depot(500f);} 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); }
		catch (UnsupportedOperationException e) { System.err.println(e.getMessage()); }
		
		try { c3.retrait(-50);} 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); }
		
		try { c4.retrait(0);} 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); }
		
		try { CompteAnonyme.virement(c1, c4, 200);} 
		catch (IllegalArgumentException e) { System.err.println(e.getMessage()); } 
		catch (ExceptionSoldeInsuffisant e) {System.err.println(e.getMessage()); }
		
		try { CompteAnonyme.virement(c1, c4, 0);} 
		catch (Exception e) { System.err.println(e.getMessage()); } 
		
		try { CompteAnonyme.virement(c1, c2, 50);} 
		catch (Exception e) { System.err.println(e.getMessage()); }		
	}
}