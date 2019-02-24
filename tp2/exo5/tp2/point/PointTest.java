package tp2.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTest extends AbstraitePointTest{

	@BeforeEach
	void setUp() throws Exception {
		p1 = new Point();
		p2 = new Point(1);
		p3 = new Point(2,3);
	}
	
	@Test
	void testToString() {
		 assertEquals("(2,3)",p3.toString());
	}
	
	@Test
	void testAfficher() {
		fail("Not yet implemented");
	}

}
