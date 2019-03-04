package exo1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import exo1.AFaire.NIVEAU;
import exo1.AFaire;

public class Question_2_a {

	static void afficheTachesAFaire( Class<?> c, AFaire.NIVEAU n) {
		
		AFaire annotation = c.getClass().getAnnotation(AFaire.class);
		
		//if(annotation!=null)	// si c n'est pas annoté de l'annotation AFaire on quitte
		//	System.exit(-1);
		
		// avec declared on accéede a ceux hérité aussi

		Field[] tableauDeChamps = c.getClass().getDeclaredFields();
		Method[] tableauDeMethodes = c.getClass().getDeclaredMethods();
		//System.out.println(tableauDeChamps);
		
		for(Field f : tableauDeChamps) {
		//if ( f.getAnnotation(AFaire.class)!= null )
				//System.out.println(f.getName());
		}
		for(Method m : tableauDeMethodes) {
			//if ( annotation.niveau() == (m.getAnnotation(AFaire.class)).niveau() )
			System.out.println(m.getName());
		}
		
	}
	
	public static void main(String[] args) {

		TestAFaire t = new TestAFaire();
		afficheTachesAFaire(t.getClass(), NIVEAU.NORMAL);
		
		
	}
}
