package exo1;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.anyString;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.isA;

class ITest {

	private I mock, autreMock; 
	private Iterator<String> it;
	
	@BeforeEach
	void setUp() throws Exception {
		mock = mock(I.class);
		autreMock = mock(I.class);
		
		doThrow(new Exception()).when(mock).methode1();
		doNothing().when(autreMock).methode1();
		
		when(mock.methode2()).thenReturn(1,2,3,4);
		
		when(mock.methode3(3)).thenReturn(3);		
		when(mock.methode3(7)).thenReturn(10);
		when(mock.methode3(15)).thenThrow(new Exception());
		
		when(mock.methode4(anyString())).thenReturn(100);
		when(mock.methode4(isA(List.class))).thenReturn(500);
		
		it = mock(Iterator.class);
		when(it.next()).thenReturn("oui").thenReturn("non").thenReturn("bof");
		when(it.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
		when(mock.iterator()).thenReturn(it);
	}
	
	@Test
	void testMethode1a() throws Exception {
		assertThrows(Exception.class, () ->  mock.methode1());
	}
	
	@Test
	void testMethode1b() throws Exception {
		autreMock.methode2();
	}
	
	@Test
	void testMethode2() throws Exception {
		assertEquals(1,mock.methode2());
		assertEquals(2,mock.methode2());
		assertEquals(3,mock.methode2());
		assertEquals(4,mock.methode2());
		verify(mock,times(4)).methode2();
		assertEquals(4,mock.methode2());
		assertEquals(4,mock.methode2());
		assertEquals(4,mock.methode2());
		verify(mock,times(7)).methode2();
	}

	@Test
	void testMethode3a() throws Exception {
		assertEquals(0,mock.methode3(1));
		assertEquals(3,mock.methode3(3));
		assertEquals(10,mock.methode3(7));
		verify(mock,atLeast(1)).methode3(3);
		verify(mock,atLeast(3)).methode3(anyInt());
		verify(mock,never()).methode3(0);
	}
	
	@Test
	void testMethode3b() throws Exception {
		assertThrows( Exception.class, () -> mock.methode3(15));
	}
	
	@Test
	void testMethode4() throws Exception {
		assertEquals(100,mock.methode4(new String("un")));
		assertEquals(500,mock.methode4(new ArrayList<Integer>()));
		assertEquals(100,mock.methode4("deux"));
		assertEquals(500,mock.methode4(new LinkedList<String>()));
	}


	@Test
	void testIterator() throws Exception {
		String obtenue = "";
		for( String s : mock)
			obtenue += s + " ";
		assertEquals("oui non bof ", obtenue);
	}
	
	@Test
	void testSpy() throws Exception {
		List<String> liste = new LinkedList<String>();
		List<String> spy = spy(liste);
		//when(spy.get(0)).thenReturn("ok"); // incorrect : IndexOutOfBoundsException
		doReturn("ok").when(spy).get(0);
		assertEquals("ok", spy.get(0));
	}
}