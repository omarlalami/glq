package temperature;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observer;

import javax.swing.JFrame;

public abstract class VueTemperature implements  Observer {
	protected ControleurTemperature controleur;
	protected  JFrame  fenetre;
	private void sortir() { fenetre.dispose(); System.exit(0); }
	public VueTemperature(ControleurTemperature c, String  titre , int posX , int  posY) {
		controleur = c;
		fenetre = new  JFrame(titre);
		//fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		fenetre.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	            sortir();
	        }
	    });
		fenetre.setSize (300 ,60);
		fenetre.setLocation(posX , posY);
	}
}
