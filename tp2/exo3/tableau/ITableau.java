package tableau;

public interface ITableau {

	void ajoute( Object o);
	Object supprime( int i);
	boolean supprime( Object o);
	boolean supprimeTous( Object o);
	void vide();
	boolean contient(Object o);
	int frequence(Object o);
	int taille();
	int indice(Object o);
	public Object remplace(Object e,int indice);
	
}
