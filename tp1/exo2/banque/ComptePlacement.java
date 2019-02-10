package banque;

import personne.Personne;

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
	
	@Override public boolean depot( float montant) {
		throw new java.lang.UnsupportedOperationException("on ne peut pas faire un depot sur un compte placement");
		//afficheTexteErreur( "Depot impossible");
		//return false;
	}
	
}