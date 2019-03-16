package personnes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Implementation de l'interface <tt>IPersonne</tt>.
 * 
 * @author Lucile Torres
 * @see IPersonne
 */

public class Personne implements IPersonne, Comparable<Personne>{

	/** Le nom de la Personne */
	private final String nom_;
	
	/** Le prenom de la Personne */
	private final String prenom_;
	
	/** La date de naissance de la Personne */
	private final Date dateNaissance_;
	
	/**
	 * Construit une personne avec le nom, le prenom et la date de naissance donnes.
	 * 
	 * @param 	prenom le prenom de la personne.
	 * @param 	nom le nom de la personne.
	 * @param 	d la date de naisssance.
	 * @throws 	NullPointerException si le nom, le prenom ou la date de naissance 
	 * 			sont {@code null}. 
	 * 
	 */
	public Personne (String prenom, String nom, Date d) { 
		 super();
		 if (nom == null || prenom == null || d == null)
	            throw new NullPointerException();
		 nom_ = nom; prenom_ = prenom; dateNaissance_ = d;
	}
		
	/**
	  * Renvoie le nom de cette personne.
	  *
	  * @return le nom de cette personne.
	  */
	public String getNom() { return nom_; }
	
	/**
	  * Renvoie le prenom de cette personne.
	  *
	  * @return le prenom de cette personne.
	  */
	public String getPrenom() { return prenom_; }
	
	/**
	  * Renvoie la date de naissance de cette personne.
	  *
	  * @return la date de naissance de cette personne.
	  */
	public Date getDate() { return dateNaissance_; }
	
	private int calculAge( Calendar c1, Calendar c2) {
		int age = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		c1.set(Calendar.YEAR, c2.get(Calendar.YEAR));
		if (c1.after(c2)) age--;
		return age;
	}
	
	/**
	 * Renvoie l'age de la personne a la date donnee.
	 * 
	 * @param d la date a laquelle l'age de cette personne est calcule.
	 * @return l'age de cette personne  a la date d.
	 */
	public int getAge(Date d) {
		Calendar courant = Calendar.getInstance();
		courant.setTime( d);
		Calendar naissance = Calendar.getInstance();
		naissance.setTime( dateNaissance_);
		return calculAge( naissance, courant);
	}
	
	/**
	 * Renvoie l'age de la personne a la date d'aujourd'hui.
	 * 
	 * @return l'age de cette personne a la date d'aujourd'hui.
	 */
	public int getAge() {
		return getAge( new Date());
	}
	
	/**
	 * Renvoie une representationn textuelle de la personne.
	 * 
	 * @return une representation de la personne sous forme de String.
	 */
	public String toString() { 
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		return prenom_ + " " + nom_ + " (" + formater.format( dateNaissance_) + ")"; 
	}
	
	/**
	 * Renvoie une valeur de hachage pour la personne.
	 * 
	 * @return une valeur de hachage pour cette personne.
	 * @see #equals(java.lang.Object)
	 */
	public int hashCode() { 
		return Objects.hash( nom_, prenom_, dateNaissance_); 
	}
	
	/**
	 * Indique si un autre objet est egal a cette personne.
	 * 
	 * @param o
	 * @return {@code true} si cette personne est la même que
	 *          l'argument o, {@code false} sinon.
	 * @see #hashCode()
	 * @see #compareTo(Personne)
	 */
	public boolean equals(Object o) {
		return (o != null && (o instanceof Personne)
				&& nom_.equals(((Personne)o).nom_) 
				&& prenom_.equals(((Personne)o).prenom_)
				&& dateNaissance_.equals(((Personne)o).dateNaissance_));
	}
	
	/**
	 * Compare deux personnes par ordre lexicographique de leurs noms
	 * si elles ont des noms differents, par ordre lexicographique de
	 * leurs prenoms sinon. Et si les personnes sont homonymes, les personnes
	 * sont comparées par date de naissance croissante.
	 * 
	 * @param 	autrePersonne l'autre personne a comparer a cette personne
	 * @return 	la valeur <code>0</code> si l'argument autrePersonne est egal
	 * 			a cette personne, une valeur inferieure a <code>0</code> si
	 * 			cette personne est inferieure a l'argument autrePersonne, et
	 * 			une valeur superieure a <code>0</code> si cette personne est 
	 * 			superieure a l'argument autrePersonne.
	 * @see #equals(java.lang.Object)
	 */
	public int compareTo(Personne autrePersonne) {
        int comparaisonNoms = nom_.compareTo(autrePersonne.nom_);
        if ( comparaisonNoms != 0 ) return comparaisonNoms;
        else {
        	int comparaisonsPrenoms = prenom_.compareTo(autrePersonne.prenom_);
        	return ( comparaisonsPrenoms != 0 ? comparaisonsPrenoms 
        									  : dateNaissance_.compareTo(autrePersonne.dateNaissance_) );
        }
     }
}