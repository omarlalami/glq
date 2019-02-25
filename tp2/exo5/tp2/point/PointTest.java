package tp2.point;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTest extends AbstraitePointTest{

	
	@Test
	void testToString() {
		 assertEquals("(2,3)",p3.toString());
	}
	
	@Test
	void testAfficher() {
		fail("Not yet implemented");
	}

	@Override
	protected Point creer() {
		return new Point();
	}

	@Override
	protected Point creer(int i) {
		return new Point(i);
	}

	@Override
	protected Point creer(int i, int j) {
		// TODO Auto-generated method stub
		return new Point(i,j);
	}

}
