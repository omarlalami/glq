package tp2.polynome;

public class PolynomeDuSecondDegre {
	
	private double a, b, c;
	
	public PolynomeDuSecondDegre(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b ;
		this.c = c;
	}
	public PolynomeDuSecondDegre() {
	}
	
	public double valeur(double x) {
		return a * x * x + b * x + c;
	}
	
	private double discriminant() { 
		return b*b-4*a*c; 
	}
	
	public double[] racines() {
		double delta = discriminant();
		double [] racines;
		if ( delta == 0 ) {
			racines = new double[1];
			racines[0] = -b / (2 * a);
		} else if ( delta > 0 ){
			double racineDeDelta = Math.sqrt( delta);
			racines = new double[2];
			racines[0] = (-b + racineDeDelta) / (2 * a);
			racines[1] = (-b - racineDeDelta) / (2 * a);
		} else {
			racines = new double [0];
		}
		return racines;
	}

}