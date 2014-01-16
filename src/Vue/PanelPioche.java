package Vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Pioche;

/**
 * Panel gérant la pioche de la partie
 * 
 * @author Youssef, Ananias
 *
 */
public class PanelPioche extends JPanel implements Observer, ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JLabel labelImage = new JLabel ();
	
	/**
	 * Bouton permettant de piocher une carte
	 */
	private JButton boutonPioche = new JButton("<html>Prendre dans <br/> la pioche</html>");
	
	/**
	 * Pioche de la partie
	 */
	private Pioche pioche;
	
	/**
	 * Crée une panneau contenant un label de carte cachée et un bouton permettant de piocher
	 * @param pioche
	 */
	public PanelPioche (Pioche pioche)
	{
		super();
		
		pioche.ajouterObserver(this);
		this.pioche = pioche;
			
		
		this.boutonPioche.setEnabled(false);
		this.boutonPioche.addActionListener(this); 
		
		this.add(this.labelImage, BorderLayout.NORTH);
		this.add(this.boutonPioche, BorderLayout.NORTH);		
		this.mettreAJourImage ();
		this.mettreAJourBouton();
	}
	
	/**
	 * Met à jour le label contenant l'image de la dernière carte de la pioche
	 */
	public void mettreAJourImage ()
	{
		this.labelImage.setIcon(Images.redimensionnerMax(Images.CACHEE));
	}
	/**
	 * Met à jour le bouton permettant de piocher
	 */
	public void mettreAJourBouton ()
	{
		if (this.pioche.isPiochable()&& !this.pioche.getListeCarte().isEmpty())
			this.boutonPioche.setEnabled(true);
		else
			this.boutonPioche.setEnabled(false);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) 
	{
		this.mettreAJourImage();
		this.mettreAJourBouton();
	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) 
	{
		Images.getFenetre(this).piocherCarte();
	}
}

