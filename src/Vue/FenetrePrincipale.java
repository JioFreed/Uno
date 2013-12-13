package Vue;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import Controleur.Controleur;
import Modele.Carte;
//import Modèle.FenetreParametres;
import Modele.Joueur;
import Modele.Partie;
import Modele.Manche;

public class FenetrePrincipale extends JFrame implements Observer
{

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
	
	final static int MIN_HORIZONTAL = 1350;
	
	final static int MIN_VERTICAL = 730;
	
	//private Controleur controleur;
	
	public FenetrePrincipale (Controleur controleur)
	{
		super("1000 bornes express");
		
		this.controleur = controleur;
		this.controleur.ajouterObserver(this);
		this.controleur.commencerLaPartie();
		
		this.pack();
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension (MIN_HORIZONTAL,MIN_VERTICAL));
		
		this.setLayout(new BorderLayout());
		//this.add(new PanneauPrincipal(this.controleur), BorderLayout.CENTER);		
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
	}
	
	
	public void piocherDansLaPioche ()
	{
		this.controleur.piocherCartePioche();
	}
	
	
	public void piocherDansLaDefausse ()
	{
		this.controleur.piocherCarteDefausse();
	}	
	
	
	public void setCarteActuelle (Carte carte)
	{
		this.controleur.mettreLesCibles(carte);
	}
	
	public void jeterCarte ()
	{
		this.controleur.jeterCarte();
	}
	
	
	public void jouerCarte (Joueur joueur)
	{
		this.controleur.jouerCarte(joueur);
	}

	
	public void update(Observable arg0, Object arg1) 
	{
		if (((Partie) arg0).getJoueurGagnant() != null)
		{
			JOptionPane d = new JOptionPane();  
			String textes[]= {"Au revoir !"}; 
			int retour = d.showOptionDialog(this, ((Partie) arg0).getTypeFin(), "Wouhou !", 0, 0, new ImageIcon(), textes, textes[0]); 
			System.exit(0);			
		}
		else if (((Partie) arg0).getCoupFourreEnCours())
			JOptionPane.showMessageDialog(this, ((Partie) arg0).getJoueurCourant() + " fait un coup fourré !");
	}
	*/
}
