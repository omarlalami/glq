package aspects;

import java.lang.reflect.Field;
import org.aspectj.lang.reflect.FieldSignature;
import observateur.Observable;
import observateur.Observe;

public aspect Observation {
	
	declare error: set(@Observe * (!@Observable *).*) || get(@Observe * (!@Observable *).*) 
	: "@Observed field {joinpoint.signature.name} must be declared in a @Observable class";

	public pointcut change(Object o, Object nouvelleValeur)
	: set(@Observe * (@Observable *).*) && target(o) && args(nouvelleValeur);

	declare soft: IllegalAccessException : adviceexecution() && within(Observation);
		
	void around(Object o, Object nouvelleValeur)
	: change(o, nouvelleValeur) {
		Field champ;
		Object ancienneValeur;
		try {
			champ = ((FieldSignature)thisJoinPointStaticPart.getSignature()).getField();
			champ.setAccessible(true);
			ancienneValeur = champ.get(o);
		} finally {
			proceed(o, nouvelleValeur);
		}
		System.out.println(champ + ":"+ ancienneValeur + "->"+ nouvelleValeur);
	}
}