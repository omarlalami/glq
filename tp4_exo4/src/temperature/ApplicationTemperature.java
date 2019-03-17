package temperature;

public  class  ApplicationTemperature {
	public  ApplicationTemperature () {
		ModeleTemperature  modele = new  ModeleTemperature ();
		ControleurTemperature  controleur = new  ControleurTemperature(modele);

		controleur.nouvelleVueEnDegresCelsius(100,300);
		controleur.nouvelleVueEnDegresFahrenheit(100,500);
		controleur.nouvelleVueTemperatureCurseur(100,700);
	}
	public  static  void  main(String  args []) {
		javax.swing.SwingUtilities.invokeLater(new  Runnable () {
			public  void  run() {
				new  ApplicationTemperature();
			}
		});
	}
}
