package temperature;

public  class  ControleurTemperature {
	protected  ModeleTemperature modele;
	public  ControleurTemperature(ModeleTemperature m) {
		modele = m;
	}
	public double donneTemperature() {
		return modele.getTemperatureEnDegresCelsius();
	}
	public void ajouteDegres(double delta){
		modele.setTemperatureEnDegresCelsius(
			modele.getTemperatureEnDegresCelsius() + delta);
	}
	public void affecteDegres(double  tempC) {
		modele.setTemperatureEnDegresCelsius(tempC);
	}
	public VueTemperature nouvelleVueEnDegresCelsius(int x, int y) {
		VueTemperature nouvelle = new VueTemperatureBoutonsCelsius(this, x, y);
		modele.addObserver( nouvelle);
		return nouvelle;
	}
	public VueTemperature nouvelleVueEnDegresFahrenheit(int x, int y) {
		VueTemperature nouvelle = new VueTemperatureBoutonsFehrenheit(this, x, y);
		modele.addObserver( nouvelle);
		return nouvelle;
	}
	public VueTemperature nouvelleVueTemperatureCurseur(int x, int y) {
		VueTemperature nouvelle = new VueTemperatureCurseur(this, "Curseur", x, y);
		modele.addObserver( nouvelle);
		return nouvelle;
	}
}