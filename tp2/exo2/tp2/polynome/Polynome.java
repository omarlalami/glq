package tp2.polynome;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>Polynome est une classe permettant de representer des polynomes</b>
 * <p>Un polynome peut etre cree a l'aide de 3 constructeurs :
 * <ul><li>le constructeur sans parametres cree le polynome nul</li>
 * <li>un constructeur avec 2 entiers a et b en parametres cree le polynome reduit au
 * monome de coefficient a et de degre b</li>
 * <li>un constructeur de copie avec un polynome en parametre</li></ul>
 * <p>Un polynome implemente un ensemble de methodes :<ul>
 * <li>plus pour renvoyer un polynome resultat de l'addition du polynome courant 
 * avec le polynome en parametre</li>
 * <li>fois pour renvoyer un polynome resultat de la multiplication du polynome courant 
 * avec le polynome en parametre</li>
 * <li>moins pour renvoyer un polynome resultat de la soustraction du polynome courant 
 * avec le polynome en parametre</li>
 * <li>equals pour tester si le polynome courant est égal à l'objet en parametre</li>
 * <li>degre pour obtenir le degre du polynome</li></ul>
 * </p>
 * @author L. Torres
 * @version 1.0,Janvier 2019
 */
public class Polynome {
	
	private class Monome {
        private int degre; 
        private int coefficient;
        
        public Monome(int coef, int deg) {
        	if ( coef == 0) throw new IllegalArgumentException();
            this.coefficient = coef;
            this.degre = deg;
        }
        
        @Override
        public boolean equals(Object o) {
        	if ( o == this) return true;
        	if ( ! (o instanceof Monome)) return false;
        	Monome m = (Monome) o;
            return coefficient == m.coefficient && degre == m.degre;
        }
        public String toString() {
            String s = "";
            if (coefficient < 0) s = "-"; 
            else if (coefficient > 0) s = "+" ;
            if ( Math.abs(coefficient) > 1 || degre == 0 ) {
                s = s + String.valueOf(Math.abs(coefficient));
            }
            if ( degre > 0 ) { s = s + "X"; }
            if ( degre > 1 ) { s = s + "^" + degre;}
            return s;
        }
     }
	
	
    private List<Monome> contenu; // liste decroissante (par degres) des monomes
    
    public Polynome() {
    	contenu = new LinkedList();
    }

    public Polynome(int coef, int expo) {
    	contenu = new LinkedList();
    	if ( coef != 0 ) {
     		contenu.add(new Monome(coef,expo));
    	}
    }
    
    public Polynome(int [] coefficients) {
    	contenu = new LinkedList();
    	int j = 0;
    	for ( int i : coefficients ) {
    		if ( i != 0 )
    			contenu.add(new Monome(i,coefficients.length-1-j));
     		j++;
    	}
    }

    public Polynome(Polynome p) {
    	contenu = new LinkedList();
    	for(Monome m : p.contenu)
    		contenu.add(new Monome(m.coefficient,m.degre));
    }
    
    public boolean nul() { return contenu.isEmpty(); }
    
    public int degre() {
    	if ( nul() ) return 0;
    	return contenu.get(0).degre;
    }
    
    public Polynome plus(Polynome p) {
    	if ( nul() ) return new Polynome(p);
    	if ( p.nul() ) return new Polynome(this);
    	Polynome resultat = new Polynome();
    	Monome courant1, courant2;
    	int i, j;
    	for( i=0, j=0; i < contenu.size() && j < p.contenu.size(); i++, j++ ) {
       		courant1 = contenu.get(i);
       		courant2 = p.contenu.get(j);
    		if (courant2.degre > courant1.degre ) {
    			resultat.contenu.add(p.contenu.get(j));
    			i--;
    		}
    		else if (courant2.degre < courant1.degre ) {
    			resultat.contenu.add(contenu.get(i));
    			j--;
    		} else {
    			resultat.contenu.add(new Monome(courant1.coefficient+courant2.coefficient, courant1.degre));
    		}
    	}	
       	while( i < contenu.size()) { resultat.contenu.add(contenu.get(i));i++; }
       	while( j < p.contenu.size()) { resultat.contenu.add(p.contenu.get(j));j++; }
       	return resultat;
    }
    
    public Polynome fois(Polynome p) {
    	if ( nul() || p.nul() ) return new Polynome();
    	Polynome resultat = new Polynome();
    	for(Monome m1 : contenu) {
    		for(Monome m2 : p.contenu) {
    			Polynome temp = new Polynome(m1.coefficient*m2.coefficient, m1.degre+m2.degre);
    			resultat = resultat.plus(temp);  			
    		}
    	}
    	return resultat;
    }

    public Polynome moins(Polynome p) {
    	return plus(p.fois(new Polynome(-1,0)));
    }

    @Override
    public boolean equals(Object o) {
    	if ( o == this) return true;
    	if (! (o instanceof Polynome)) return false;
    	return contenu.equals(((Polynome)o).contenu);
    }
    
	public String toString() {
		if ( nul() ) return "0";
		String s = "";
		for( Monome m : contenu) s+= m.toString();
		return s;
	}
}