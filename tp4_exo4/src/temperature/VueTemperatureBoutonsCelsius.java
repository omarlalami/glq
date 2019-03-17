package temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public  class  VueTemperatureBoutonsCelsius  extends  VueTemperatureBoutons {
	
	public  VueTemperatureBoutonsCelsius( ControleurTemperature  controleur , int posX , int  posY) {
		super(controleur, "Temperature Celsius", posX , posY, "°C ");
		update(null,null);
		int pas = 1;
		
		ajouteBoutonPlusListener(new  ActionListener () {
			public  void  actionPerformed(ActionEvent e) {
				controleur.ajouteDegres(pas);
			}});
		ajouteBoutonMoinsListener(new  ActionListener () {
			public  void  actionPerformed(ActionEvent e) {
				controleur.ajouteDegres(-pas);
			}});
		ajouteAffichageListener(new  ActionListener () {
			public  void  actionPerformed(ActionEvent e) {
				double  tempC = getAffichage();
				controleur.affecteDegres(tempC);
			}});
	}
	public  void  update(Observable s, Object o) {
		setAffichage("" + format.format(controleur.donneTemperature()));
	}
}
