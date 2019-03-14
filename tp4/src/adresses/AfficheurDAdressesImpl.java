package adresses;
/**
 * Une implementation de l'interface <tt>AfficheurDAdresses</tt>.
 *
 */
public class AfficheurDAdressesImpl implements AfficheurDAdresses {
	private ChercheurDAdresses chercheur;
	
	public AfficheurDAdressesImpl(ChercheurDAdresses c) { 
		chercheur = c; 
	}
	
	@Override
	public String afficher(String nom) {
		Adresse a = chercheur.chercher( nom);
		if ( a == null) throw new IllegalArgumentException();
		String resultat = a.nom() + "\n";
		if ( a.numero() != 0)
			resultat += a.numero() +  " ";
		resultat += a.rue() + "\n";
		resultat += a.codePostal() +  " " + a.ville();
		return resultat;
	}
}
