package tp2.bibliotheque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Livre {
	String titre;
	List<Auteur> auteurs;
	
	public Livre(String t, Auteur... x) {
		Objects.requireNonNull(t);
		titre = t;
		auteurs = new ArrayList();
		for( Auteur a : x)
			auteurs.add(a);
	}
	
	@Override 
	public String toString() {
		String resultat = titre;
		if (! auteurs.isEmpty()) resultat += " "+ auteurs;
		return resultat;
	}
	
}