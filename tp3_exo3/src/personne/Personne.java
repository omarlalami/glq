package personne;

public class Personne {
	
	private String nom;
	
	public Personne(String n) { nom = n; }
	
	public void bonjour() { System.out.println( nom + " : Bonjour !"); }
	public void auRevoir() { System.out.println( nom  + " : Au revoir..."); }
	public void parle(String message) { System.out.println( nom  + " : " + message); }
	
	@Override public String toString() { return nom; }
	
	public static void main(String[] args){
		Personne paul = new Personne("Paul");
		paul.bonjour();
		paul.parle("J'aime les aspects.");
		paul.auRevoir();
	}
	
}