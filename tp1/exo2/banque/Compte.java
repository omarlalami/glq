package banque;

import personne.Personne;

public class Compte extends CompteAnonyme {
	private Personne titulaire;

	public Compte( Personne p, float montant) {
		super( montant);
		titulaire=p;
	}
	
	public Compte( Personne p) {
		this(p,0);
	}
	
	@Override protected String getTypeToString() {
		return "Compte standard";
	}
	
	public Personne getTitulaire() {
		return titulaire;
	}
	
	@Override protected String finToString() {
		return( ", titulaire : " + getTitulaire().getNom()	+ super.finToString());
	}
}