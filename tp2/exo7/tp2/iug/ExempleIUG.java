package tp2.iug;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ExempleIUG extends JFrame {

	private JTextField texte;
	
	private void donneNomAuComposantPourTests( Component c, String nom) {
		c.setName(nom);
	}
	
	private void initMenu() {
		JMenuBar menu = new JMenuBar();
		JMenu couleur = new JMenu("Couleur");
		JMenuItem rouge = new JMenuItem("rouge");
		JMenuItem vert = new JMenuItem("vert");

		setJMenuBar(menu);
		couleur.add(rouge);
		couleur.add(vert);
		menu.add(couleur);
		donneNomAuComposantPourTests(rouge,"rouge");
		donneNomAuComposantPourTests(vert,"vert");
		
		rouge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rougeActionPerformed(e);				
			} }); 
		
		vert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vertActionPerformed(e);				
			} }); 
	}	
	
	private void initPanneau() {
		JPanel panneau = new JPanel();
		setContentPane( panneau);

		JButton bouton = new JButton("?");
		bouton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boutonActionPerformed(e);				
			} }); 
		donneNomAuComposantPourTests(bouton,"quoi");
		panneau.add(bouton);
		
		panneau.add( new JSeparator());
		
		texte = new JTextField("Bonjour");
		texte.setPreferredSize(new Dimension(200,25));
		donneNomAuComposantPourTests(texte,"texte");
		
		texte.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				texteActionPerformed(e);				
			} }); 
		panneau.add(texte);
	}
	
	private void boutonActionPerformed(ActionEvent e) {
		JTextArea zone = new JTextArea(texte.getText()+"...");
		zone.setColumns(20);
		zone.setLineWrap(true);
		zone.setBackground(null);
		zone.setEditable(false);
		JOptionPane.showMessageDialog(this,  zone);
	}
	
	private void texteActionPerformed(ActionEvent e) {
		texte.setText(texte.getText()+" !");
	}


	private void rougeActionPerformed(ActionEvent e) {
		texte.setForeground(Color.RED);
	}

	private void vertActionPerformed(ActionEvent e) {
		texte.setForeground(Color.GREEN);
	}
			
	public ExempleIUG() {
		super("Exemple");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,100);
		initMenu();
		initPanneau();
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new ExempleIUG();
            }
        });	
	}
}