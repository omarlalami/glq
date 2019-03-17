package temperature;

import java.util.Observable;

public  class  ModeleTemperature extends Observable {
	/**
	 * Temperature minimale autorisee (en degres Celsius)
	 */
	public final static double MIN_CELSIUS = 0;

	/**
	 *   Temperature maximale autorisee (en degres Celsius)
	 */
	public final static double MAX_CELSIUS = 100;
		
	/**
	 *  Temperature par defaut (en degres Celsius)
	 */
	public final static double DEFAUT_CELSIUS = 20;
	
	/**
	 *  Temperature au-dessus de laquelle une alarme est signalee (en degres Celsius)
	 */
	public final static double ALARME_CELSIUS = 40;
	
	/**
     * Les valeurs minimales et maximales doivent être differentes et la valeur par defaut
     * doit etre strictement comprise entre le minimum et le maximum.<br>
	 */
	public final static boolean INVARIANT = (MIN_CELSIUS < MAX_CELSIUS) &&
		(DEFAUT_CELSIUS > MIN_CELSIUS) && (DEFAUT_CELSIUS < MAX_CELSIUS);

	/**
	 * @param f est la temperature en degres Fahrenheit
	 * @return la temperature en degres Celsius
	 */
	public static double fahrenheitToCelsius(double f){
		return (f - 32.0) * 5.0 / 9.0;
	}

	/**
	 * @param c est la temperature en degres Celsius
	 * @return la temperature en degres Fahrenheit
	 */
	public static double celsiusToFahrenheit(double c){
		return (c * 9.0 / 5.0) + 32;
	}
	
	/**
	 * Temperature courante exprimee ne degres Celsius.
	 */
	private  double  temperatureEnDegresCelsius;
	
	/**
	 * Construit un modele
	 */
	public ModeleTemperature() {
		temperatureEnDegresCelsius = DEFAUT_CELSIUS;
	}
	
	/**
	 * @return la temperature courante en degres Celsius
	 */
	public  double  getTemperatureEnDegresCelsius(){
		return  temperatureEnDegresCelsius;
	}
	
	/**
	 * Modifie la temperature courante avec la valeur donnee en parametre, exprimee
	 * en degres Celsius. La methode doit informer les observateurs du
	 * modele que la temperature a change.
	 * @param tempC est la nouvelle temperature exprimee en degres Celsius.
	 */
	public  void  setTemperatureEnDegresCelsius(double  tempC){
		temperatureEnDegresCelsius = tempC;
		if (temperatureEnDegresCelsius > MAX_CELSIUS) 
			temperatureEnDegresCelsius = MAX_CELSIUS;
		else if (temperatureEnDegresCelsius < MIN_CELSIUS) 
			temperatureEnDegresCelsius = MIN_CELSIUS;
		setChanged();
		notifyObservers();
	}
}