package tp2.compteur;

public class Compteur {
	
	private int valeur;
	private int pas;
	
	public static int nombreDInstances = 0;
	
	public Compteur(int n, int p) { this.valeur = n; this.pas = p; nombreDInstances++; }
	public Compteur(int n) { this(n,1); }
	public Compteur() { this(0); }
	
	public void incremente() { this.valeur+=this.pas; }
	public int valeur() { return this.valeur; }
	public void remetAZero() { this.valeur = 0; }
	
	public static int getNbInstance() {return nombreDInstances;}
}
