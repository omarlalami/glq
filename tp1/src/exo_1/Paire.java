package exo_1;

import java.util.Collection;
import java.util.List;

public class Paire<A, B> {
	
	A a;
	B b;
	private static Integer nbInstances=0;
	
	public Paire() { nbInstances++;	}
		
	public Paire(A a, B b){
		this.a = a;
		this.b = b;
		this.nbInstances++;
	}

	public static int getNbInstances() { return nbInstances; }

	public A getPremier() {
		return a;
	}

	public void setPremier(A a) {
		this.a = a;
	}

	public B getSecond() {
		return b;
	}

	public void setSecond(B b) {
		this.b = b;
	}
	
	public static <X,Y> void copiePremier( Paire <X,Y> p , X [] tab , int indice ) {
		tab[indice]=p.getPremier();
	}
	
	public <X,Y> boolean memePremier( Paire <X,Y> p ) {
		if ( p == null )
			return false;
		
		assert ( this.getPremier() !=null );
		
		return getPremier().equals(p.getPremier());
	}
	
	// Q 8
	/*
	public void prendPremier(List i)
	{
		((Paire<Object,?>)this).setPremier(i.get(0));
	}
	*/
	public <X extends A> void prendPremier(List<X> l){
	    setPremier(l.get(0));
   	}
	
	// Q 9 on a X integer on veut le mettre soit dans X soit dans un truc super a X
	public static <X> void copiePremier(Paire <X,?> p , Collection <? super X> c){
		c.add(p.getPremier());
	}
	

	@Override
	public String toString() {
		//return "Paire [a=" + a + ", b=" + b + "]";
		return "("+ a + "," + b + ")";
	}
	
}
