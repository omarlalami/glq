/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp2.stringarray.StringArray;

/**
 * @author pc
 *
 */
class StringArrayTest {

	/**
	 * @throws java.lang.Exception
	 */

	private static String[] slist1={
		"a","b","ccc","ccd","d","e","f","g"
	};
	private static String[] slist2={
		"a","b","ccd","ccc","g","f","e","d"
	};
	private static String[] slist3={
		"a","b","b","b","a","a","b","a"
	};
	private static String[] slist4={
		"b","b","b","a","a","b","a"
	};
	
	private StringArray array1;
	private StringArray array2;
	private StringArray array3;
	private StringArray array4;

	@BeforeEach
	public void setUp() throws Exception {
		array1=new StringArray(slist1);
		array2=new StringArray(slist2);
		array3=new StringArray(slist3);
		array4=new StringArray(slist4);
	}
	
	@Test
	public void testStringArray() {
		assertEquals(8,array1.size());		
		assertEquals(8,array2.size());
		assertEquals("[a, b, ccc, ccd, d, e, f, g]", array1.toString());
		assertEquals("[a, b, ccc, ccd, d, e, f, g]", array2.toString());
		assertEquals("[a, b]", array3.toString());
		assertEquals("[a, b]", array4.toString());
	}
	
	@Test
	public void testgetString() {
		assertEquals("a",array2.getString(0));		
		assertEquals("ccc",array2.getString(2));		
		assertEquals("g",array2.getString(7));		
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(-1,array1.IndexOf("ee"));
		assertEquals(4,array1.IndexOf("d"));
	}
}