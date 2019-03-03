package tp2.iug;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExempleIUGTest {
	
	ExempleIUG fenetre;
	JTextField texte;

	
	@BeforeEach void setup() {
		fenetre = new ExempleIUG();
		texte = (JTextField) TestUtils.getEnfantNomme(fenetre,"texte");
		assertNotNull(texte);	
	}
	
	@AfterEach void tearDown() {
		sleep(2000);
		fenetre.dispose();
	}
	
	private void sleep(long millis) {
		try  {Thread.sleep(millis); }
		catch(Exception e) { e.printStackTrace(); }
	}


	/**
	 * Methode de test du composant JTextField texte 
	 */
	@Test
	void testDuJTextFieldTexte() {
		texte.setText("Test");
		texte.postActionEvent();
		assertEquals("Test !", texte.getText());
	}
	
	/**
	 * Methode de test des elements rouge et vert du menu Couleur
	 * @throws InterruptedException 
	 */
	@Test
	void testDesElementsRougeEtVertDuMenuCouleur() {
		JMenuItem rouge = (JMenuItem) TestUtils.getEnfantNomme(fenetre,"rouge");
		assertNotNull(rouge);
		JMenuItem vert = (JMenuItem) TestUtils.getEnfantNomme(fenetre,"vert");
		assertNotNull(vert);
		vert.doClick();
		assertEquals(Color.GREEN.toString(), texte.getForeground().toString());
		rouge.doClick();
		assertEquals(Color.RED, texte.getForeground());
		vert.doClick();
		assertEquals(Color.GREEN, texte.getForeground());
	}
	
	/**
	 * Methode de test du bouton ?
	 * @throws InterruptedException 
	 */
	@Test
	void testDuBouton()  {
		JButton bouton = (JButton) TestUtils.getEnfantNomme(fenetre,"quoi");
		assertNotNull( bouton);
		String msg = "Test de la boite de dialogue";
		texte.setText( msg);
		texte.postActionEvent();
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               bouton.doClick();
            }
        });
		
		JButton ok = null;
		JTextArea message = null;
		for (int i = 0; ok == null || message == null; ++i) {
			sleep(1000);
			ok = (JButton)TestUtils.getEnfantIndexe(fenetre, "JButton", 0);
			message = (JTextArea)TestUtils.getEnfantIndexe(fenetre, "JTextArea", 0);
			assertTrue(i < 10);
		}
		assertEquals(UIManager.getString("OptionPane.okButtonText"), ok.getText());
        assertEquals(msg+" !...", message.getText());
        ok.doClick();
	}
}