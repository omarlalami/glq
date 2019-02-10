package exo_1_prof;

import java.util.Collection;
import java.util.List;

public class Paire<A, B> {
	  private A premier;
	  private B second;
	  private static int nbInstances = 0;
	  
	  public Paire(A a, B b) {
	    premier = a;
	    second = b;
	    nbInstances++;
	  }
	  public Paire() { nbInstances++;	}

	  public static int getNbInstances() { return nbInstances; }
	  public A getPremier() { return premier; }
	  public void setPremier(A a) { premier = a; }
	  public B getSecond() { return second; }
	  public void setSecond(B b) { second = b; }
	  @Override public String toString() { return "("+premier+","+second+")"; }

	  public static <X,Y> void copiePremier( Paire<X,Y> p, X [] tab, int i) {
	    tab[i]=p.getPremier();
	  }
	  public static <X> void copiePremier2( Paire<X,?> p, X [] tab, int i) {
	    tab[i]=p.getPremier();
	  }
	  public static <X,Y> void copiePremier( Paire<X,Y> p, Collection<? super X> c) {
	    c.add( p.getPremier());
	  }
	  public static <X> void copiePremier2( Paire<X,?> p, Collection<? super X> c) {
	    c.add( p.getPremier());
	  }

	  public <X extends A> void prendPremier(List<X> l){
	    setPremier(l.get(0));
	  }
	  public void prendPremier2(List<? extends A> l){
	    setPremier(l.get(0));
	  }

	  public <X,Y> boolean memePremier( Paire<X,Y> p) {
	    return getPremier().equals(p.getPremier());
	  }
	  public <X> boolean memePremier2( Paire<X,?> p) {
	    return getPremier().equals(p.getPremier());
	  }

}
