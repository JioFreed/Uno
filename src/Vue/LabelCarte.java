package Vue;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Modele.Carte;

/**
 * Label contenant une carte
 * 
 * @author Yann, Youssef
 *
 */
public class LabelCarte extends JLabel implements MouseListener
{

	private Carte carte;

	private ImageIcon image;

	private GestionnaireMain gestionnaire;
	
	public LabelCarte (Carte carte, String taille, GestionnaireMain gestionnaire)
	{
		super();
		if (taille == "moy")
			this.image = Images.redimensionnerMoy(carte.getImageAssociee());
		else
			this.image = Images.redimensionnerMax(carte.getImageAssociee());
		this.setIcon(this.image);
		
		this.carte = carte;
		this.gestionnaire = gestionnaire;
		
		this.gestionnaire.ajouterLabel(this);
		this.addMouseListener(this);
	}
	
	/**
	 * Applique le focus sur le label
	 */
	public void mettreFocus ()
	{
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	/**
	 * Enlève le focus sur le label
	 */
	public void enleverFocus ()
	{
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	/**
	 * Indique  la carte du label
	 * 
	 * @return Instance de la carte du label
	 */
	public Carte getCarte ()
	{
		return this.carte;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent arg0) 
	{
		// On indique au gestionnaire que c'est ce label qui doit avoir le focus
		Window window = SwingUtilities.windowForComponent(this);
		FenetreParametre frame = (FenetreParametre) window;
		this.gestionnaire.mettreFocus(this, frame);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}
