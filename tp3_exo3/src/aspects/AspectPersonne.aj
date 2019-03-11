package aspects;

import personne.Personne;

/*

public aspect AspectPersonne{ 

	pointcut appelBonjour(Personne p) : 
		call(void personne.Personne.bonjour())
		&& target(p);
	before(Personne p) : appelBonjour(p) { System.out.println( p + " sourit."); }

	pointcut appelAuRevoir(Personne p) : 
		call(void personne.Personne.auRevoir())
		&& target(p);
	after(Personne p) : appelAuRevoir(p) { System.out.println( p + " salue de la main."); }

	pointcut appelParle(Personne p, String msg) : 	
 		call(void personne.Personne.parle(String)) 
 		&& args(msg) 
 		&& target(p);
 	after(Personne p, String msg) : appelParle(p, msg) { 
		System.out.println( p + " repete : " + msg);
		}

 	pointcut appel() : call(* personne.*.*(..));
	before() : appel(){ 
		System.out.println("> AVANT appel de la methode "
				+thisJoinPoint.getSignature().getName());
		} 
	after() : appel(){ 
		System.out.println("> APRES appel de la methode "
				+thisJoinPoint.getSignature().getName());
		}
		
}

*/