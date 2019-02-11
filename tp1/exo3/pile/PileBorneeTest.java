/**
 * 
 */
package pile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author pc
 *
 */
class PileBorneeTest {

	
	PileBornee p=null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testPileBornee();
		testEmpile();
		p.depile();
		p.depile();
}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link pile.PileBornee#PileBornee(int)}.
	 */
	@Test
	void testPileBornee() {
		assertThrows(IllegalArgumentException.class, () -> new PileBornee(-2));
		p = new PileBornee(2);
	}

	/**
	 * Test method for {@link pile.PileBornee#estVide()}.
	 */
	@Test
	void testEstVide() {
		assert(p.estVide());
	}

	/**
	 * Test method for {@link pile.PileBornee#estPleine()}.
	 */
	@Test
	void testEstPleine() {
		p.empile(2);
		p.empile(2);
		assert(p.estPleine());
	}

	/**
	 * Test method for {@link pile.PileBornee#empile(java.lang.Object)}.
	 */
	@Test
	void testEmpile() {
		p.empile(2);
		p.empile(3);
	}

	/**
	 * Test method for {@link pile.PileBornee#sommet()}.
	 */
	@Test
	void testSommet() {
		testEmpile();
		assert ((Integer)p.sommet()) == 3;
	}

	/**
	 * Test method for {@link pile.PileBornee#depile()}.
	 */
	@Test
	void testDepile() {

		testEmpile();
		assert ((Integer)p.depile()) == 3;
		assert ((Integer)p.depile()) == 2;
		assertThrows(IllegalArgumentException.class, () -> p.depile());

	}

	/**
	 * Test method for {@link pile.PileBornee#getNombre()}.
	 */
	@Test
	void testGetNombre() {
		assert(p.getNombre()==0);
	}

	/**
	 * Test method for {@link pile.PileBornee#toString()}.
	 */
	@Test
	void testToString() {
		//fail("Not yet implemented");
	}

}
