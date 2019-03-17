package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import temperature.ModeleTemperature;

class ModeleTemperatureTest {
	public static double DELTA = 0.00001;
	protected ModeleTemperature modele;
	
	@BeforeEach
	void setUp() throws Exception {
		modele = new ModeleTemperature();
	}

	@AfterEach
	void tearDown() throws Exception {
		modele = null;
	}
	
	@Test
	void testConsistanceMinMax() {
		assertTrue( ModeleTemperature.MIN_CELSIUS < ModeleTemperature.MAX_CELSIUS);
		assertTrue( ModeleTemperature.MIN_CELSIUS < ModeleTemperature.DEFAUT_CELSIUS);
		assertTrue( ModeleTemperature.DEFAUT_CELSIUS < ModeleTemperature.MAX_CELSIUS);
		assertTrue( ModeleTemperature.ALARME_CELSIUS < ModeleTemperature.MAX_CELSIUS);
	}

	/**
	 * Test de {@link ModeleTemperature#fahrenheitToCelsius()}
	 */
	@Test
	void testFahrenheitToCelsius() {
		assertEquals(100,ModeleTemperature.fahrenheitToCelsius(212), DELTA);	
		assertEquals(0,ModeleTemperature.fahrenheitToCelsius(32), DELTA);
	}
	
	/**
	 * Test de {@link ModeleTemperature#celsiusToFahrenheit()}
	 */
	@Test
	void testCelsiusToFahrenheit() {
		assertEquals(212, ModeleTemperature.celsiusToFahrenheit(100), DELTA);	
		assertEquals(32, ModeleTemperature.celsiusToFahrenheit(0), DELTA);
	}
	
	private void invariant() {
		double temperature = modele.getTemperatureEnDegresCelsius();
		assertTrue( ModeleTemperature.MIN_CELSIUS <= temperature);
		assertTrue( temperature <= ModeleTemperature.MAX_CELSIUS);
	}
	
	/**
	 * Test de {@link ModeleTemperature#ModeleTemperature()}
	 */
	@Test
	 void testModeleTemperature() {
		invariant();
		assertEquals(ModeleTemperature.DEFAUT_CELSIUS, modele.getTemperatureEnDegresCelsius(), DELTA);
	}

	/**
	 * Test de {@link ModeleTemperature#setTemperatureEnDegresCelsius()}
	 */
	@Test
	void testSetTemperatureEnDegresCelsius() {
		double temperature = (ModeleTemperature.MIN_CELSIUS + ModeleTemperature.MAX_CELSIUS) / 2;
		modele.setTemperatureEnDegresCelsius( temperature);
		assertEquals( temperature, modele.getTemperatureEnDegresCelsius(), DELTA);
		invariant();

		modele.setTemperatureEnDegresCelsius( ModeleTemperature.MAX_CELSIUS + 1);
		assertEquals( ModeleTemperature.MAX_CELSIUS, modele.getTemperatureEnDegresCelsius(), DELTA);
		invariant();

		modele.setTemperatureEnDegresCelsius( ModeleTemperature.MIN_CELSIUS - 1);
		assertEquals( ModeleTemperature.MIN_CELSIUS, modele.getTemperatureEnDegresCelsius(), DELTA);
		invariant();
	}

}