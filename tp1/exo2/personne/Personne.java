package personne;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Personne {

	private static int nombreInstances = 0;
	private static int anneeCourante = new GregorianCalendar().get(Calendar.YEAR);
	private int numero; 
	private String nom, prenom;
	private int anneeNaissance;
	private boolean celibataire, sexeMasculin;
	private String terminaison;
	private Personne conjoint, pere, mere;
	
	public Personne (String unNom, String unPrenom, int annee, char sexe, Personne papa, Personne maman) 
	 {
		if (annee > anneeCourante) annee = anneeCourante ;
		numero = ++nombreInstances;
		nom = unNom;
		prenom = unPrenom;
		anneeNaissance = annee;
		conjoint = null;
		celibataire = ( conjoint == null );
		sexeMasculin = ( sexe == 'M' ) || ( sexe == 'm' );
		terminaison = sexeMasculin ? "" : "e"; 
		pere = papa;
		mere = maman;
		System.out.println("Naissance de la " + numero + "ème personne");
	}
	
	public Personne (String unNom, String unPrenom, int annee, char sexe) 
	 {
		this( unNom, unPrenom, annee, sexe, null, null);
	}
	
	public int compareTo( Personne autrePersonne) {
		int valeur = autrePersonne.getAge() - getAge();
		return valeur;
	}
	
	static public int compareTo( Personne p1, Personne p2) {
		int valeur = p2.getAge() - p1.getAge();
		return valeur;
	}
	
	public void marier( Personne fiance) {
		if (( conjoint == null ) && ( sexeMasculin != fiance.sexeMasculin )) {
				conjoint = fiance;
				celibataire = false;
				fiance.marier( this);
		}
		else if ( conjoint != null ) {
			if (conjoint != fiance ) System.err.println( getNomPrenom() + " déjà marié(e)");
		}
		else {
			System.err.println( getNomPrenom() + " et " + fiance.getNomPrenom() + " de même sexe");
		}
	}
	
	public boolean estAncetre( Personne petitfils) {
		if ( petitfils == null) return false;
		return ( (petitfils.pere == this) || (petitfils.mere == this) 
				 || estAncetre( petitfils.pere) || estAncetre( petitfils.mere));
	}
	
	public void afficheAieux( int generation) {
		if ( generation == 0) { System.out.println( getNomPrenom()); }
		if ( pere != null) {
			for( int g = 0; g < generation; g++) System.out.print( "\t");
			System.out.print( "|___");
			System.out.println( "de père " + pere.getNomPrenom());
			pere.afficheAieux( generation + 1);
		}
		if ( mere != null) {
			for( int g = 0; g < generation; g++) System.out.print( "\t");
			System.out.print( "|___");
			System.out.println( "de mère " + mere.getNomPrenom());
			mere.afficheAieux( generation + 1);
		}
		
	}
	
	public String getNomPrenom() {
		String resultat = new String ("");
		resultat += ( sexeMasculin ? "M. " : ( celibataire ? "Mlle " : "Mme "));
		if ( ! sexeMasculin && ! celibataire ) 
			resultat += conjoint.nom + " née " ;
		resultat += nom + " " + prenom;
		return resultat;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String toString() {
		String resultat = getNomPrenom();
		resultat += " né" + terminaison + " en " + anneeNaissance;
		resultat += ( celibataire ? ", célibataire" : ", marié" + terminaison );
		return resultat ;
	}
	
	public void afficheAge(int annee) {
		int age = annee - anneeNaissance;
		String verbe;
		
		System.out.print( getNomPrenom());
		if ( age < 0 )
			System.out.println( " n'était pas né" + terminaison + " en " + annee);
		else {
			verbe = ( annee < anneeCourante ) ? new String ("avait") : ( ( annee == anneeCourante ) ? new String ("a"): new String ("aura"));
			System.out.println( " " + verbe + " " + age + " ans en " + annee);
		}
	}
	
	public void afficheAge() {
		afficheAge( anneeCourante);
	}
	
	public int getAge() {
		int age = anneeCourante - anneeNaissance;
		return age ;
	}
}