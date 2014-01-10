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

public class PanneauCouleurTalon extends JPanel implements Observer {

	private JLabel labelImage = new JLabel();
	private Talon talon;

	public PanneauCouleurTalon(Talon talon) {
		super();

		talon.ajouterObserver(this);
		this.talon = talon;
		this.mettreAJourImage();
		this.add(labelImage, BorderLayout.NORTH);
	}

	/**
	 * Met à jour l'image de la dernière carte de la défausse
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
