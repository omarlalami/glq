package mesures;

public aspect AspectMesures {
	
	private long debut;
	private static long min = 0, max = 0, nombre = 0;
	private static double somme = 0;

	pointcut methodeMain(): 
		execution(public static void main(String []));
	
	after(): methodeMain() {
		System.out.println( "***min="+min+" max ="+max+" moyenne ="
				+(somme/nombre)+" nombre="+nombre);
	}

	pointcut profileMethodeGetAge(): 
		call(int *.getAge(..));
	
	before(): profileMethodeGetAge() {
		debut = System.currentTimeMillis();
	}
	
	after(): profileMethodeGetAge() {
		long fin = System.currentTimeMillis() - debut;
		somme += fin;
		if ( min > fin) min = fin;
		if ( max < fin) max = fin;
		nombre++;
	}

	/*Object around(): profileMethodeGetAge() {
		
		try { 
			return proceed(); 
		}
		finally {
			long fin = System.currentTimeMillis() - debut;
			System.out.println( fin);
		}
	}*/
}
