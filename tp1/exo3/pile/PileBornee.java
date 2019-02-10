package pile;

/** Une pile bornée
 * @author L. Torres
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
    	tableau = new Object[max];
    	nombre = 0;
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
    	tableau[nombre] = o;
    	nombre++;
    }

    /** Renvoie l'élément au sommet de la pile.
     * @return l'élément au sommet de la pile.
     */
    public Object sommet() {
        return tableau[nombre-1];
    }

    /** Supprime l'élément au sommet de la pile et le renvoie.
     * @return l'élément supprimé.
     */
    public Object depile() {
       	Object o = tableau[nombre-1];
       	tableau[nombre-1] = null; // GC !
    	nombre--;
    	return o;
    }

    /** Renvoie le nombre d'éléments dans la pile.
     * @return le nombre d'éléments dans la pile.
     */
    public int getNombre() {
        return nombre;
    }
    
    @Override public String toString() {
    	String res="";
    	for (int i = 0; i < nombre; i++)
    		res += "[" + this.tableau[i] + "]";
        return res;
    }
}