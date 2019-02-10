package exo2.compte;

import exo2.personne.Personne;

public class Compte extends CompteAnonyme {
	private Personne titulaire;

	public Compte( Personne p, float montant) {
		super( montant);
		titulaire=p;
	}
	
	public Compte( Personne p) {
		this(p,0);
	}
	
	@Override public String getTypeToString() {
		return "Compte standard";
	}
	
	public Personne getTitulaire() {
		return titulaire;
	}
	
	@Override public String toString() {
		return( getTypeToString() + " n°" + getNumero() + ", titulaire : " + getTitulaire().getNom()	+ ", solde = " + getSolde() + " euros");
	}
}