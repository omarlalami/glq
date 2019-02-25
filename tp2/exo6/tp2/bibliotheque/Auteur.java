package tp2.bibliotheque;

public class Auteur {

	private String nom,prenom;



	public Auteur(String nom, String prenom) {
		if (prenom == null)
			throw new NullPointerException();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Auteur(String prenom) {
		this("",prenom);
	}
	
	
	@Override
	public String toString() {
		if (getNom()=="")
			return getPrenom();
		else
			return getPrenom() + " " + getNom();
	}

	
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

}
