package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import tp2.bibliotheque.Auteur;
import tp2.bibliotheque.Bibliotheque;
import tp2.bibliotheque.Livre;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BibliothequeTest {

	private List<Livre> livres;
	private Bibliotheque bibliotheque;

	@BeforeEach
	private void init() {
	}
	
	private static List<Object[]> fournirDonnees() { 
		return Arrays.asList(new Object[][] { {"xxx", new Object [] {"a0","a1","s0"} }, {"xxx", new Object [] {"a1","a1"} }} );
	}
	
	@ParameterizedTest @MethodSource("fournirDonnees")
	void testAjouteEtEnleve(String resultat, String[] ordres) {
		
	}

}
