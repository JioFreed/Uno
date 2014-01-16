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
 * @author Youssef, Ananias
 *
 */
public class LabelCarte extends JLabel implements MouseListener
{
	/**
	 * la carte concernée
	 */
	private Carte carte;

	/**
	 * l'image associée à la carte
	 */
	private ImageIcon image;

	/**
	 * Gestionnaire de la main du joueur
	 */
	private GestionnaireMain gestionnaire;
	
	/**
	 * Instancie le label de la carte en associant une taille et une image à la carte en question
	 * @param carte
	 * 			Carte concernée
	 * @param taille
	 * 			La taille choisi pour l'affichage
	 * @param gestionnaire
	 * 			le gestionnaire de la main
	 */
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
	 * Met le focus sur le label
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
		Window window = SwingUtilities.windowForComponent(this);
		FenetreJeu frame = (FenetreJeu) window;
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
