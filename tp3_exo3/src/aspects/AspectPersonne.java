package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import personne.Personne;

@Aspect
public class AspectPersonne { 
	
	@Before ("call(void personne.Personne.bonjour()) && target(p)") 
    public void sourire(Personne p) {
		System.out.println(p + " sourit.");
	}

	@After("call(void personne.Personne.auRevoir()) && target(p)") 
	public void saluer(Personne p) {
		System.out.println(p + " salue de la main.");
	}
	  
   	@After ("call(void personne.Personne.parle(String)) && args(s) && target(p)")
   	public void repeter(Personne p, String s) {
   		System.out.println(p + " repete : " + s);
	}
   	
    @Pointcut ("call(* personne.*.*(..))")
    public void appel() { }

    @Before ("appel()")
    public void avant(JoinPoint pointcut) {
    	System.out.println("> AVANT appel de la methode "
			+pointcut.getStaticPart().getSignature().getName());
	}
    
    @After ("appel()")
    public void apres(JoinPoint pointcut) {
    	System.out.println("> APRES appel de la methode "
			+pointcut.getStaticPart().getSignature().getName());
	}


}