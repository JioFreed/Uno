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
 * Panel g�rant la d�fausse de la partie
 * 
 * @author Yann, Youssef
 *
 */
public class PanneauTalon extends JPanel implements Observer
{
	private JLabel labelImage = new JLabel ();
	private Talon talon;
	
	public PanneauTalon (Talon talon)
	{
		super();
		
		talon.ajouterObserver(this);
		this.talon = talon;
		this.mettreAJourImage ();
		this.add(labelImage, BorderLayout.NORTH);
	}
	
	/**
	 * Met � jour l'image de la derni�re carte de la d�fausse
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

