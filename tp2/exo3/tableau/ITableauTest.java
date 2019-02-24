package tableau;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exo3.tableau.*;

class ITableauTest {
	Tableau1 t1;
	Tableau2 t2;
	
		// C'EST PEUT ETRE PAS FONCTIONNEL A 100 % MAIS C'EST DEJA PAS MAL
	//ps : je n'ai pas fait les test avec les 6 classes de Tableau
	
	@BeforeEach
	void setUp() throws Exception {
		t1 = new Tableau1(5);
		t2 = new Tableau2(0);
		t1.ajoute(5);
		t1.ajoute("ko");
	}

	@Test
	void testAjoute() {
				
		t1.ajoute(new Integer(6));
		assertEquals(t1.taille(),3);
		assert(t1.contient(6));
		
		Object o=null;
		t2.ajoute(o);
		System.out.println(t2.taille());
		assert(0==t2.taille());
	}

	@Test
	void testSupprimeInt() {
		t1.supprime(0);
		assertFalse(t1.contient(5));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> t1.supprime(-2));
	}

	@Test
	void testSupprimeObject() {
		t1.supprime("ko");
		assertFalse(t1.supprime("suprime un objet qui n'existe pas"));

	}

	@Test
	void testSupprimeTous() {
		assertFalse(t1.supprimeTous("suprime tous les objets qui n'existe pas"));
}

	@Test
	void testVide() {
		t1.vide();
		assertEquals(t1.taille(),0);
		assert(!t1.contient(5));
		assert(!t1.contient("blabla"));
}

	@Test
	void testFrequence() {
		assertEquals(t1.frequence(2),0);
	}

	@Test
	void testIndice() {
		assertEquals(t1.indice(5),0);
		assertEquals(t2.indice("koulou"),-1);
	}

	@Test
	void testRemplace() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> t1.remplace("dl",-2));
	}

}
