package exo2.compte;

import exo2.personne.Personne;

public class ComptePlacement extends CompteRemunere {

	public ComptePlacement( Personne p, float montant, float taux) {
		super( p, montant, taux);
	}
	
	public ComptePlacement( Personne p, float montant) {
		super( p, montant);
	}
	
	@Override public String getTypeToString() {
		return "Compte placement";
	}
	
	@Override public void depot( float montant) {
		throw new UnsupportedOperationException( debutTexteErreur + "Depot impossible");
	}
	
}