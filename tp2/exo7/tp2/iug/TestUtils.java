package tp2.iug;


import java.awt.Component;
import java.awt.Container;
import java.awt.Window;

import javax.swing.JMenu;

/**
 * Classes utilitaire qui fournit les methodes de parcours de la hierarchie
 * des composants graphiques pour retrouver un composant avec une signature 
 * particuliere (classe, ordre, nom, ...)
 *
 */
public class TestUtils {
	
	private static int compteur;
	
	public static Component getEnfantNomme(Component parent, String nom) {
		if (nom.equals(parent.getName())) return parent;
		if ( parent instanceof Container) {
			Component [] enfants = (parent instanceof JMenu) ?
					((JMenu) parent).getMenuComponents() :
					((Container)parent).getComponents();
			for(Component c : enfants) {
				Component enfant = getEnfantNomme(c, nom);
				if (enfant != null) return enfant;
			}
		}
		return null;
	}
	public static Component getEnfantIndexe(Component parent, String nom, int index) {
		compteur = 0;
		if (parent instanceof Window) {
			Component [] enfants = ((Window)parent).getOwnedWindows();
			for (Component c : enfants) {
				if (c instanceof Window && ! ((Window)c).isActive()) continue;
				Component enfant = getEnfantIndexeInterne( c, nom, index);
				if (enfant != null) return enfant;
			}
		}
		return null;
	}
	public static Component getEnfantIndexeInterne(Component parent, String nom, int index) {
		if (parent.getClass().toString().endsWith(nom)) {
			if ( compteur == index) return parent;
			++compteur;
		}
		if ( parent instanceof Container) {
			Component [] enfants = (parent instanceof JMenu) ?
					((JMenu) parent).getMenuComponents() :
					((Container)parent).getComponents();
			for(Component c : enfants) {
				Component enfant = getEnfantIndexeInterne(c, nom, index);
				if (enfant != null) return enfant;
			}
		}
		return null;
	}

}