package temperature;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

/** 
 * Classe abstraite definissant une vue de type IUG avec boutons avec laquelle 
 * l'utilisateur peut interagir. Toutes les vues representent la meme temperature
 * sous des formes differentes. La modification d'une vue doit modifier automatiquement
 * les autres vues.
 * NB : Pour ajouter une vue qui est une IUG sous forme de thermometre (JSlider), 
 * il est preferable de ne pas faire heriter la nouvelle vue de cette classe abstraite.
 * Voir https://csis.pace.edu/~bergin/mvc/mvcgui.html
 */
public  abstract  class  VueTemperatureBoutons  extends VueTemperature {
	private  JTextField  affichage;
	private  JButton  boutonPlus;
	private  JButton  boutonMoins;
	protected static final DecimalFormat format = new DecimalFormat("#.##");

	public VueTemperatureBoutons(ControleurTemperature c, String  titre , int posX , int  posY, String unites) {
		super(c, titre, posX, posY);
		affichage = new  JTextField();
		fenetre.add(affichage , BorderLayout.CENTER );
		fenetre.add( new JLabel(unites), BorderLayout.EAST);
		JPanel  panelbuttons = new  JPanel ();
		boutonPlus = new  JButton("+");
		boutonMoins = new  JButton("-");
		panelbuttons.add(boutonMoins );
		panelbuttons.add(boutonPlus );
		fenetre.add(panelbuttons , BorderLayout.SOUTH);
		fenetre.setVisible(true);
	}
	public  void  setAffichage(String s) {
		affichage.setText(s);
		if (controleur.donneTemperature() > ModeleTemperature.ALARME_CELSIUS)
			activeCouleurDAvertissement();
		else
			desactiveCouleurDAvertissement();
	}
	public  void  activeCouleurDAvertissement () {
		affichage.setBackground(Color.RED);
	}
	public  void  desactiveCouleurDAvertissement () {
		affichage.setBackground(Color.WHITE);
	}
	public  double  getAffichage() {
		double  result = 0.0;
		try {
			result = Double.valueOf(affichage.getText()).doubleValue();
		}
		catch (NumberFormatException e) {}
		return  result;
	}
	public  void  ajouteAffichageListener(ActionListener a){  affichage.addActionListener(a);}
	public  void  ajouteBoutonPlusListener(ActionListener a){  boutonPlus.addActionListener(a);}
	public  void  ajouteBoutonMoinsListener(ActionListener a){  boutonMoins.addActionListener(a);}
}