package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp2.polynome.PolynomeDuSecondDegre;

class PolynomeDuSecondDegreTest {

	private PolynomeDuSecondDegre p1, p2, p3, p4;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new PolynomeDuSecondDegre(1,1,-2);
		p2 = new PolynomeDuSecondDegre(1,-2,1);
		p3 = new PolynomeDuSecondDegre(1,1,1);
		p4 = new PolynomeDuSecondDegre();
	}

	@Test
	void test() {
		assertEquals( 2, p1.racines().length);
		assertEquals( 1.0, p1.racines()[0]);
		assertEquals( -2.0, p1.racines()[1]);
		assertEquals( 1, p2.racines().length);
		assertEquals( 1.0, p2.racines()[0]);
		assertEquals( 0, p3.racines().length);
	}
	
	@Test
	public void test2() {
		assertEquals( -2, p1.valeur(0));
		assertEquals( 0, p2.valeur(1));
		assertEquals( 1, p3.valeur(-1));
	}
	
	@Test
	public void test3() {
		assertEquals( 0, p4.valeur(158));
		assertEquals( 0, p4.valeur(-15));
		assertEquals( 0, p4.valeur(0));
	}
}
