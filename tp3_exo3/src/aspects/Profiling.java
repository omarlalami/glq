package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
/*
@Aspect
public class Profiling {
	@Pointcut("execution( public * *.*(..))")
	protected void profile() {}
	
	@Around("profile()")
	public Object aroundInterestingMethods(ProceedingJoinPoint thisJoinPoint)
	            throws Throwable {
	  final long debut, fin;
	  debut = System.nanoTime();
	  Object resultat = thisJoinPoint.proceed();
	  fin = System.nanoTime();
		System.out.println( "--Profiling--" +thisJoinPoint.getSignature() +" "
				+ (fin-debut) + " nanosecondes");
		return resultat;
	}
}
*/