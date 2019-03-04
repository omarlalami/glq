package exo1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import exo1.AFaire.*;

public class TestAFaire {

	/*
	 * Q1
	 * 
	 * oui l'annontation Deprecated apparait dans la doclet
	 * 
	 */
	
	@AFaire 
	public int s=5;
	public int b=2;
	
	@AFaire(descrption_tache="mettre a jour fichier",nom_developpeur="lalami",d="04/03",niveau=NIVEAU.NORMAL)
	public void salut() {
		System.out.println("salut");
	}
	
	@Deprecated
	public void bonjour() {
		System.out.println("bonjour");
	}
	
	
	/*
	 * 
	 *  question 2 -- a & b & c a finir
	 * 
	 * 
	 * */
	
	
	
}
