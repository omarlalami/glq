package monjunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import monprojet.test.LeCasDeTest;

public class MonJUnit {
	public static void main( String[] args ) throws IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, InstantiationException {	
		Class<LeCasDeTest> classe = LeCasDeTest.class ;
		Method [] toutesLesMethodes = classe.getDeclaredMethods();
		ArrayList<Method> methodesTest = new ArrayList<>(); 
		ArrayList<Method> methodesBeforeEach = new ArrayList<>(); 
		ArrayList<Method> methodesBeforeAll = new ArrayList<>(); 
		ArrayList<Method> methodesAfterAll = new ArrayList<>(); 
		
		for ( Method m : toutesLesMethodes ) {
			if ( m.getGenericReturnType() != void.class ) continue;
			if ( m.getParameterTypes().length != 0 ) continue;
			if ( m.getAnnotation(MonTest.class) != null ) 
				methodesTest.add( m);
			if ( m.getAnnotation(MonBeforeEach.class) != null ) 
				methodesBeforeEach.add( m);
			if ( m.getAnnotation(MonBeforeAll.class) != null ) 
				methodesBeforeAll.add( m);
			if ( m.getAnnotation(MonAfterAll.class) != null ) 
				methodesAfterAll.add( m);
		}
		Object o = classe.newInstance();
		for( Method mt : methodesTest ) {
																// Q5 pas fini
			for( Method mb : methodesBeforeEach ) {				// Q4 pas fini
				mb.invoke(o);
			}
			for( Method ma : methodesBeforeAll ) {
				ma.invoke(o);
			}
			for( Method al : methodesAfterAll ) {
				al.invoke(o);
			}
			
			if( mt.getAnnotation(MonTest.class).value().equals("IllegalArgumentException")) {
				
			}else{
				
			}
			
			if ( mt.getAnnotation(MonTest.class).value().equals("ArithmeticException")) {
				try {
					mt.invoke(o);
					throw new AssertionError("Une ArithmeticException aurait du etre levee");
				} catch (InvocationTargetException e) { 
					if (! e.getCause().getClass().equals(ArithmeticException.class))
						throw new AssertionError("Une ArithmeticException aurait du etre levee");
				}
			} else {
				try {
					mt.invoke(o);
				} catch (InvocationTargetException e) { throw new AssertionError(e.getCause().getMessage()); }
			}
			
		}
		
	}
}
