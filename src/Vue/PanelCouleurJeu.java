package Vue;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Talon;

public class PanelCouleurJeu extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * label de l'image décrivant la couleur du jeu
	 */
	private JLabel labelImage = new JLabel();
	
	/**
	 * Le talon de la patrie en cours
	 */
	private Talon talon;

	/**
	 * Affecte une image au labelImage selon la couleur du talon
	 * 
	 * @param talon
	 */
	public PanelCouleurJeu(Talon talon) {
		super();

		talon.ajouterObserver(this);
		this.talon = talon;
		this.mettreAJourImage();
		this.add(labelImage, BorderLayout.NORTH);
	}

	/**
	 * Met à jour l'image de la couleur du jeu par rapport à la derniere carte du talon
	 * 
	 */
	public void mettreAJourImage() {
		if (this.talon.getListeCarte().isEmpty())
			this.labelImage.setIcon(Images.redimensionnerMax(Images.CACHEE));
		else {
			int couleur = this.talon.getDerniereCarte().getCouleur();
			if (couleur == 1)
				this.labelImage.setIcon(Images.redimensionnerMax(Images.red));
			else if (couleur == 2)
				this.labelImage.setIcon(Images.redimensionnerMax(Images.green));
			else if (couleur == 3)
				this.labelImage.setIcon(Images.redimensionnerMax(Images.blue));
			else if (couleur == 4)
				this.labelImage.setIcon(Images.redimensionnerMax(Images.jaune));
		}
	}

	public void update(Observable o, Object arg) {
		this.mettreAJourImage();
	}

}
