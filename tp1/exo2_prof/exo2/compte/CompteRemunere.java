package exo2.compte;

import exo2.personne.Personne;

public class CompteRemunere extends Compte {
	
	private float taux;
	private static int dateEnNombreDeJours = 0;
	private int dateDeDerniereMAJEnNombreDeJours;
	
	public CompteRemunere( Personne p, float montant, float taux) {
		super( p, montant);
		dateDeDerniereMAJEnNombreDeJours = 0;
		this.taux = taux;
	}
	
	public CompteRemunere( Personne p, float montant) {
		this( p, montant, 0.05f);
	}
	
	public CompteRemunere( Personne p) {
		this( p, 0, 0.05f);
	}

	@Override public String getTypeToString() {
		return "Compte remunéré";
	}
	
	public static void majDate ( int nombreDeJours) {
		dateEnNombreDeJours += nombreDeJours;
	}
	
	private void maj() {
		float nouveauSolde = super.getSolde() * ( taux * 
				((float)(dateEnNombreDeJours - dateDeDerniereMAJEnNombreDeJours) / 365) );
		assert nouveauSolde >= 0; 
		try { 
			super.depot(nouveauSolde); 
		} catch ( IllegalArgumentException e) {}
		dateDeDerniereMAJEnNombreDeJours = dateEnNombreDeJours;
	}
		
	@Override public void depot( float montant)  {
		maj();
		super.depot( montant);
	}
	
	@Override public void retrait( float montant) {
		maj();
		super.retrait( montant);
	}
	
	@Override public float getSolde() {
		maj();
		return super.getSolde();
	}
	
	@Override public String toString() {
		maj();
		return super.toString();
	}
}