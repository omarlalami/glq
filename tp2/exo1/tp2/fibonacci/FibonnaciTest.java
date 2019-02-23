package tp2.fibonacci;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FibonnaciTest {

	@Test
	static void test() {
		
		/*Q1
		 * le probleme c'est que les resultats deviennent négatifs
		 * */
		
/*		
		for (int i=0; i<50; i++)
				System.out.println( Fibonnaci.fibonacci(i,0,1));

*/	
		
		/*
		 * q3 : on verifie les 5 premiers termes
		 * */
		
		/*
		assert (Fibonnaci.fibonacci(0,0,1)==0):"ca passe pas pour 0";
		assert (Fibonnaci.fibonacci(1,0,1)==1):"ca passe pas pour 1";
		assert (Fibonnaci.fibonacci(2,0,1)==1):"ca passe pas pour 2";
		assert (Fibonnaci.fibonacci(3,0,1)==2):"ca passe pas pour 3";
		assert (Fibonnaci.fibonacci(4,0,1)==3):"ca passe pas pour 4";
		assert (Fibonnaci.fibonacci(5,0,1)==5):"ca passe pas pour 5";
		*/
		
		
		// test q5
		
		for (int i=0; i<47; i++)
			try {
				System.out.println( Fibonnaci.fibonacci(i,0,1));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
		// le but de assertThrows c'est de confirmer qu'une exception est lever
		// par exemple ici fibonnaci de 46 provoque une exception et le assertThrows l'attrape et la confirme !
		assertThrows(Exception.class, () -> Fibonnaci.fibonacci(46,0,1),"Ici une exception est levé : le assert Throws l'attrape donc et ce message n'aparrait pas" );
		assertThrows(Exception.class, () -> Fibonnaci.fibonacci(4,0,1),"Ici une exception n'est pas levé : le assert Throws n'attrape rien donc et ce message aparrait" );
		
	}
	
	public static void main(String[] args) {
		test();
	}
	
}
