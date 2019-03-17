package temperature;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Observable;

/** 
 * Classe abstraite definissant une vue de type IUG avec boutons avec laquelle 
 * l'utilisateur peut interagir. Toutes les vues representent la meme temperature
 * sous des formes differentes. La modification d'une vue doit modifier automatiquement
 * les autres vues.
 * NB : Pour ajouter une vue qui est une IUG sous forme de thermometre (JSlider), 
 * il est preferable de ne pas faire heriter la nouvelle vue de cette classe abstraite.
 * Voir https://csis.pace.edu/~bergin/mvc/mvcgui.html
 */
public  class  VueTemperatureCurseur extends VueTemperature {
	private  JSlider  curseur;
	
	public VueTemperatureCurseur(ControleurTemperature c, String  titre , int posX , int  posY) {
		super(c, titre, posX, posY);
			
		curseur = new  JSlider((int)ModeleTemperature.MIN_CELSIUS,
				(int)ModeleTemperature.MAX_CELSIUS, (int)controleur.donneTemperature());
		update(null,null);
		addChangeListener(new  ChangeListener () {
			@Override
			public void stateChanged(ChangeEvent e) {
				controleur.affecteDegres(curseur.getValue());		
			}});
		
		fenetre.add(curseur, BorderLayout.CENTER );
		fenetre.setVisible(true);
	}
	
	public  void  activeCouleurDAvertissement () {
		curseur.setBackground(Color.RED);
	}
	public  void  desactiveCouleurDAvertissement () {
		curseur.setBackground(Color.WHITE);
	}
	public  double  getAffichage() {
		return  curseur.getValue();
	}
	public  void  addChangeListener(ChangeListener c){  curseur.addChangeListener(c);}
	public  void  update(Observable s, Object o) {
		int v = (int)controleur.donneTemperature();
		if ( v > ModeleTemperature.ALARME_CELSIUS ) activeCouleurDAvertissement();
		else desactiveCouleurDAvertissement();
		curseur.setValue(v);
	}
}