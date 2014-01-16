package Vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Talon;

/**
 * Panel gérant la défausse de la partie
 * 
 * @author Yann, Youssef
 *
 */
public class PanelTalon extends JPanel implements Observer
{
	/**
	 * Label de la derniere image du talon
	 */
	private JLabel labelImage = new JLabel ();
	
	/**
	 * Talon de la partie
	 */
	private Talon talon;
	
	public PanelTalon (Talon talon)
	{
		super();
		
		talon.ajouterObserver(this);
		this.talon = talon;
		this.mettreAJourImage ();
		this.add(labelImage, BorderLayout.NORTH);
	}
	
	/**
	 * Met à jour l'image de la dernière carte de la défausse
	 */
	public void mettreAJourImage ()
	{
		if (this.talon.getListeCarte().isEmpty())
			this.labelImage.setIcon(Images.redimensionnerMax(Images.CACHEE));
		else
			this.labelImage.setIcon(Images.redimensionnerMax(talon.getDerniereCarte().getImageAssociee()));
	}
	

	public void update(Observable o, Object arg) 
	{
		this.mettreAJourImage();
	}
	
	
}

