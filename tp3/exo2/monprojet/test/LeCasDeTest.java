package monprojet.test;

import static monjunit.MonAssert.monAssertEquals;

import monjunit.MonBeforeAll;
import monjunit.MonAfterAll;
import monjunit.MonBeforeEach;
import monjunit.MonTest;
import monprojet.src.Entier;

public class LeCasDeTest {
	
	private Entier a, b,c;
	
	@MonBeforeAll
	public void init4() {
		System.out.println( ">init4");
	}
	
	@MonAfterAll
	public void terminal1() {
		System.out.println( ">terminaison1");
	}
	
	@MonBeforeEach
	public void init1() { 
		System.out.println( ">init1");
		a = new Entier(31); 
		b =  new Entier(-1652); 
		c = new Entier(0); 
	}
	@MonBeforeEach
	public void init2(int i) { 
		System.out.println( ">init2");
	}
	@MonBeforeEach
	public void init3() { 
		System.out.println( ">init3");
	}
	
	@MonTest
	public void test1() { 
		System.out.println( "test1");
		monAssertEquals( 31, a.valeurAbsolue()); 
		monAssertEquals( 1652, b.valeurAbsolue()); 
		monAssertEquals( 0, c.valeurAbsolue()); 
	}
	@MonTest
	public void test2() { 
		System.out.println( "test2");
		monAssertEquals( 93, a.triple()); 
		monAssertEquals( -4956, b.triple()); 
		monAssertEquals( 0, c.triple()); 
	}
	@MonTest
	public void test3() { 
		System.out.println( "test3");
		monAssertEquals( 2, a.divisePar(15)); 
		monAssertEquals( 413, b.divisePar(-4)); 
		monAssertEquals( 0, c.divisePar(1)); 
	}
	@MonTest("ArithmeticException")
	public void test4() { 
		System.out.println( "test4");
		a.divisePar(0); 
	}
	@MonTest
	public int test5() { 
		System.out.println( "test5");
		return 0;
	}
	
}
