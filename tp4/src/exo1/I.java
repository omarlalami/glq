package exo1;


import java.util.Iterator;

public interface I extends Iterable<String> {
	Iterator<String> iterator();
	void methode1() throws Exception;
	int methode2();
	int methode3(int i) throws Exception;
	int methode4(Object o);
}