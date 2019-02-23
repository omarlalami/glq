package tp2.polynome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp2.polynome.Polynome;

class PolynomeTest {

	Polynome p1;
	Polynome p2;
	Polynome p3;
	Polynome p4;
	Polynome p5;
	Polynome p6;
	Polynome p7;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Polynome();
		p2 = new Polynome(3,2);
		p2 = p2.plus(new Polynome(6,1));
		p2 = p2.plus(new Polynome(1,0));
		p3 = new Polynome(1,2);
		p3 = p3.plus(new Polynome(4,1));
		p4 = new Polynome(10,20);
		p4 = p4.plus(new Polynome(4,0));
		p5 =  new Polynome(3,4);
		p6 = new Polynome (new int [] {1,2,3,4,5});
		p7 = new Polynome (new int [] {0,1,0});
	}
	
	@Test
	void testPolynome() {
		assertNotNull(p1);
		assertNotNull(p5);
		assertTrue( p1.nul() );
		assertFalse( p5.nul() );
	}

	@Test
	void testDegre() {
		assertEquals( 0, p1.degre());
		assertEquals( 2, p2.degre());
		assertEquals( 2, p3.degre());
		assertEquals( 20, p4.degre());
		assertEquals( 4, p5.degre());
	}
	
	@Test
	void testToString() {
		assertEquals("0", p1.toString());
		assertEquals("+3X^2+6X+1", p2.toString());
		assertEquals("+X^2+4X", p3.toString());
		assertEquals("+10X^20+4", p4.toString());
		assertEquals("+3X^4", p5.toString());
		assertEquals("+X^4+2X^3+3X^2+4X+5", p6.toString());
		assertEquals("+X", p7.toString());
	}

	@Test
	void testPlus() {
		assertEquals(p2.toString(), p1.plus(p2).toString());
		assertEquals(p2.toString(), p2.plus(p1).toString());
		assertEquals("+4X^2+10X+1", p3.plus(p2).toString());
		assertEquals("+4X^2+10X+1", p2.plus(p3).toString());
		assertEquals("+10X^20+3X^4+4", p4.plus(p5).toString());
		assertEquals("+10X^20+3X^4+4", p5.plus(p4).toString());
		assertEquals("0", p1.toString());
		assertEquals("+3X^2+6X+1", p2.toString());
		assertEquals("+X^2+4X", p3.toString());
		assertEquals("+10X^20+4", p4.toString());
		assertEquals("+3X^4", p5.toString());
		assertEquals("+X^4+2X^3+3X^2+4X+5", p6.toString());
		assertEquals("+X", p7.toString());
	}
	
	@Test
	void testFois() {
		assertEquals("0", p1.fois(p2).toString());
		assertEquals("0", p2.fois(p1).toString());
		assertEquals("+3X^4+18X^3+25X^2+4X", p3.fois(p2).toString());
		assertEquals("+3X^4+18X^3+25X^2+4X", p2.fois(p3).toString());
		assertEquals("+30X^24+12X^4", p4.fois(p5).toString());
		assertEquals("+30X^24+12X^4", p5.fois(p4).toString());		
		assertEquals("0", p1.toString());
		assertEquals("+3X^2+6X+1", p2.toString());
		assertEquals("+X^2+4X", p3.toString());
		assertEquals("+10X^20+4", p4.toString());
		assertEquals("+3X^4", p5.toString());
		assertEquals("+X^4+2X^3+3X^2+4X+5", p6.toString());
		assertEquals("+X", p7.toString());
	}

	@Test
	void testMoins() {
		assertEquals("-3X^2-6X-1", p1.moins(p2).toString());
		assertEquals(p2.toString(), p2.moins(p1).toString());
		assertEquals("+2X^2+2X+1", p2.moins(p3).toString());
		assertEquals("-2X^2-2X-1", p3.moins(p2).toString());
		assertEquals("+10X^20-3X^4+4", p4.moins(p5).toString());
		assertEquals("-10X^20+3X^4-4", p5.moins(p4).toString());		
		assertEquals("0", p1.toString());
		assertEquals("+3X^2+6X+1", p2.toString());
		assertEquals("+X^2+4X", p3.toString());
		assertEquals("+10X^20+4", p4.toString());
		assertEquals("+3X^4", p5.toString());
		assertEquals("+X^4+2X^3+3X^2+4X+5", p6.toString());
		assertEquals("+X", p7.toString());
	}

}