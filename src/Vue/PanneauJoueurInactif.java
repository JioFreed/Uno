package Vue;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import Modele.Joueur;

public class PanneauJoueurInactif extends JLabel{

	final static int X_MAX = 80;
	final static int Y_MAX = 40;
	private ImageIcon image;
	private TitledBorder titre;

	public PanneauJoueurInactif(Joueur joueurConcerne) {
		super();

		titre = new TitledBorder(joueurConcerne.getNom());
		this.setBorder(titre);
		this.image = Images.redimensionnerMoy(Images.CACHEE);
		this.setIcon(this.image);

	}

}
