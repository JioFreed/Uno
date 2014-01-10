package Vue;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Manche;
import Modele.Partie;

public class FenetrePartie extends JFrame implements Observer, ActionListener{
	final static int TAILLE_HORIZONTALE = 1100;
	final static int TAILLE_VERTICALE = 280;
	private Controleur controleur;
	private JButton boutonCible = new JButton("Fermer!");

	public FenetrePartie(Controleur controleur)
	{
		this.controleur= controleur;
		this.add(new JPanel());
		this.setVisible(true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(false);
		this.dispose();
		this.controleur.init();
        new FenetreParametre(this.controleur);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
		
	}
	
}
