package aspects;

import org.aspectj.lang.ProceedingJoinPoint;

/*

public aspect Profiling {

	private final static boolean ACTIF = true;

	pointcut publicOperation() : if (Profiling.ACTIF) && execution(public * *.*(..));
	
	Object around () :
		publicOperation() {
			long debut = System.nanoTime();
			Object ret = proceed();
			long fin = System.nanoTime();
			System.out.println( "--Profiling--"+ thisJoinPoint.getSignature() +" "
				+ (fin-debut) + " nanosecondes");
			return ret;
	}
	
}

*/