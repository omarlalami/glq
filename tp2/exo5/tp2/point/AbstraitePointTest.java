package tp2.point;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class AbstraitePointTest {

	Point p1,p2,p3;

	@Test
	void testHashCode() {
		assertNotEquals(p1.hashCode(),p2.hashCode());
		assertNotEquals(p1.hashCode(),p3.hashCode());
		assertEquals(p2.hashCode(),p2.hashCode());

	}

	@Test
	void testTranslate() {
		p1.translate(2,3);
		assert(p1.equals(p3));
	}

	@Test
	void testAbscisse() {
		assertEquals(p3.abscisse(),2);
		assertNotEquals(p2.abscisse(),9);
	}

	@Test
	void testOrdonnee() {
		assertEquals(p3.ordonnee(),3);
		assertNotEquals(p1.ordonnee(),8);	
	}

	@Test
	void testEqualsObject() {
		assertFalse(p1.equals(p3));
		assertFalse(p2.equals(p3));
		assert(p3.equals(p3));
	}

	@Test
	void testDistance() {
		assertEquals(p1.distance(p2),p2.distance(p1));
		assertNotEquals(p1.distance(p2),p2.distance(p3));
	}

}
