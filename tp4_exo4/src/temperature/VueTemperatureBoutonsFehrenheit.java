package temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public  class  VueTemperatureBoutonsFehrenheit  extends  VueTemperatureBoutons {
	
	public  VueTemperatureBoutonsFehrenheit(ControleurTemperature  controleur , int posX , int  posY) {
		super(controleur, "Temperature Fahrenheit", posX , posY, "°F ");
		update(null,null);
		int pas = 5;
		double deltaEnDegresCelsiusPourUnDegreFahrenheit = 5.0/9;
		
		ajouteBoutonPlusListener(new  ActionListener() {
			public  void  actionPerformed(ActionEvent e) {
				controleur.ajouteDegres(pas*deltaEnDegresCelsiusPourUnDegreFahrenheit);
			}});
		ajouteBoutonMoinsListener(new  ActionListener() {
			public  void  actionPerformed(ActionEvent e) {
				controleur.ajouteDegres(-pas*deltaEnDegresCelsiusPourUnDegreFahrenheit);
			}});
		ajouteAffichageListener(new  ActionListener () {
			public  void  actionPerformed(ActionEvent e) {
				controleur.affecteDegres(ModeleTemperature.fahrenheitToCelsius(getAffichage()));
			}});
	}
	public  void  update(Observable s, Object o) {
		setAffichage("" + format.format(ModeleTemperature.celsiusToFahrenheit(controleur.donneTemperature())));
	}
}
