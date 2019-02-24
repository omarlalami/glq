package tp2.compteur;

public class CompteurSingleton {
	
	private int valeur;
	
	private static CompteurSingleton instance;
	
	public static CompteurSingleton instance() {
		if (instance == null) 
			instance = new CompteurSingleton();
		return instance;
	}
	private CompteurSingleton() { this.valeur = 0; }
	
	public void incremente() { this.valeur+= 10; }
	public int valeur() { return this.valeur; }
	public void remetAZero() { this.valeur = 0; }
	
}
