package pile;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/** Une pile bornée.
 * @author L. Torres.
 */

public class PileBornee {

    /** Implementation de la pile par un tableau. */
    private Object[] tableau;

    /** Nombre d'éléments dans la pile. */
    private int nombre;
    
    /** Crée une pile vide de capacité maximale <tt>max</tt>.
     * @param max nombre maximum d'éléments dans la pile.
     */
    public PileBornee(int max) {
    	//assert(max>0):"taille doit etre positif";
    	if (max <0) throw new IllegalArgumentException();
    	tableau = new Object[max];
    	nombre = 0;
    	assert (tableau.length==max);
    }

    /** Cette pile est-elle vide ?
     * @return true si la pile est vide.
     */
    public boolean estVide() {
    	return nombre == 0;
    }

    /** Cette pile est-elle pleine ?
     * @return true si la pile est pleine.
     */
    public boolean estPleine() {
        return nombre == tableau.length;
    }

    /** Met l'élément <tt>o</tt> au sommet de la pile.
     * @param o l'élément à empiler. 
     */
    public void empile(Object o) {
    	assertNotNull("on ne peut pas empiler un object null", o);
    	assert(nombre<tableau.length):"la taille max est atteinte on ne peut plus empiler";
    	tableau[nombre] = o;
    	nombre++;
    	assert(nombre<tableau.length):"la taille max est atteinte on ne pourra plus empiler";
    }

    /** Renvoie l'élément au sommet de la pile.
     * @return l'élément au sommet de la pile.
     */
    public Object sommet() {
    	assertNotEquals("il n'existe pas de sommet !",nombre,0);
        return tableau[nombre-1];
    }

    /** Supprime l'élément au sommet de la pile et le renvoie.
     * @return l'élément supprimé.
     */
    public Object depile() {
    	assert(nombre>0):"on ne peut pas depiler, car la pile est vide";
       	Object o = tableau[nombre-1];
       	tableau[nombre-1] = null; // GC !
    	nombre--;
    	assert(nombre>0):"on ne pourra plus pas depiler, car la pile est vide";
    	return o;
    }

    /** Renvoie le nombre d'éléments dans la pile.
     * @return le nombre d'éléments dans la pile.
     */
    public int getNombre() {
        return nombre;
    }
    
    // override signifie on hérite, si on ne dit pas de quoi on hérite, c'est Object par default
    @Override public String toString() { // par default toSTring hérite de object // quand on ne met pas de quoi sa hérite par défault ca hérite Object
    	String res="";
    	for (int i = 0; i < nombre; i++)
    		res += "[" + this.tableau[i] + "]";
        return res;
    }
}