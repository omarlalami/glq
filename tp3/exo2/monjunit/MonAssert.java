package monjunit;

public class MonAssert {
	public static void monAssertEquals( int v1, int v2) { 
		if ( v1 != v2 )
			throw new AssertionError("Valeur obtenue : " + v2 + " au lieu de valeur attendue : " + v1);
	}
	
	public static void monAssertTrue (boolean b ) {				// Q6 fini
		if ( b != true )
			throw new AssertionError("attendu resultat Vrai ! mais recu resultat False");
	}
	
	public static void monAssertFalse (boolean b ) {
		if ( b != false )
			throw new AssertionError("attendu resultat False ! mais recu resultat Vrai");
	}
}