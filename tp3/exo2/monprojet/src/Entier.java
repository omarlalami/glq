package monprojet.src;

public class Entier {
	
	private int valeur;
	
	public Entier( int v) { valeur = v; }
	
	public int valeurAbsolue() {
		if ( valeur >= 0 ) 
			return valeur;
		return -valeur;
	}
	public int triple() {
		return 3*valeur;
	}
	public int divisePar( int v) {
		if (v==0) 
			//throw new ArithmeticException("Division par zero");
			//throw new IndexOutOfBoundsException(); 
			//return 1;
			throw new ArithmeticException("Division par zero");
		return valeur / v;
	}
	
}
