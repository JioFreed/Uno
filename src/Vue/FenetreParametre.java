package Vue;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controleur.Controleur;
import Modele.*;

public class FenetreParametre extends JFrame implements Observer
{

	final static int MIN_HORIZONTAL = 1350;
	final static int MIN_VERTICAL = 730;
	private Controleur controleur;
	public FenetreParametre(Controleur controleur)
	{
		super("Uno ");
		
		this.controleur = controleur;
		this.controleur.ajouterObserver(this);
		this.controleur.demarerLaPartie();
		
		this.pack();
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension (MIN_HORIZONTAL,MIN_VERTICAL));
		
		this.setLayout(new BorderLayout());
		this.add(new PanneauPrincipal(this.controleur), BorderLayout.CENTER);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
	}
	
	public void jouerCarte (Carte c)
	{
		this.controleur.jouerCarte(c);
	}
	
	public void jouerCarte (Joueur j)
	{
		this.controleur.jouerCarte(j);
	}
	
	public void piocherCarte()
	{
		this.controleur.piocherCarte();
	}
	public void jouerCarte()
	{
		this.controleur.jouerCarte();
	}
	public void passerTour()
	{
		this.controleur.passerTour();
	}
	public void setCarteActuelle(Carte c)
	{
		this.controleur.setCarteActuelle(c);
	}
	public void update(Observable arg0, Object arg1) 
	{
		if (((Manche) arg0).isMancheEstFinie())
		{
			JOptionPane.showMessageDialog(this, ((Manche) arg0).getJoueurGagnant2().getNom() + " a gagner la manche!");

			System.exit(0);			
		}
		else if (((Manche) arg0).getUno() && ((Manche) arg0).getJoueurReelExistant())
			JOptionPane.showMessageDialog(this, ((Manche) arg0).getJoueurCourant().getNom() + " déclare Uno !!");
	}
}
