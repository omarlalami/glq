package tp2.point;

import java.util.Objects;

public class Point {
	
	private int abscisse;
	private int ordonnee;
	
	public Point() { this(0,0); }
	public Point(int a) { this(a,a); }
	public Point(int a, int b) { this.abscisse = a; this.ordonnee = b; }
	
	public void translate(int a, int b) { this.abscisse += a; this.ordonnee += b; }
	
	public int abscisse() {
		 return this.abscisse; 
	}
	public int ordonnee() {
		 return this.ordonnee; 
	}
	
	@Override 
	public String toString() {
		return "(" + this.abscisse + "," + this.ordonnee + ")";
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o  instanceof Point)) return false;
		Point p = (Point)o;
 		return this.abscisse == p.abscisse && this.ordonnee == p.ordonnee;
	}
	@Override 
	public int hashCode() {
		return Objects.hash(abscisse,ordonnee);
	}
	
	public void afficher() {
		System.out.print( this);
	}
	public double distance(Point p) {
		int dAbscisse = this.abscisse - p.abscisse;
		int dOrdonnee = this.ordonnee - p.ordonnee;
		return Math.sqrt( dAbscisse * dAbscisse + dOrdonnee * dOrdonnee);
	}
	
}
