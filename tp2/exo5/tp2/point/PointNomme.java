package tp2.point;

public class PointNomme extends Point {
	
	private String nom;
	
	public PointNomme(int a, int b, String n) {
		super(a,b);
		this.nom = n;
	}
	public PointNomme(int a, String n) {
		this(a,a,n);
	}
	public PointNomme(String n) {
		this(0,0,n);
	}
	
	public String toString() {
		return this.nom + super.toString();
	}
}