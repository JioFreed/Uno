package Vue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import Modele.Joueur;

public class PanneauChoixJoueur extends JLabel {
	private ImageIcon image;
	private TitledBorder titre;
	
	public PanneauChoixJoueur(Joueur joueurConcerne) {
		super();

		titre = new TitledBorder(joueurConcerne.getNom());
		this.setBorder(titre);
		this.image = Images.redimensionnerMoy(joueurConcerne.getDerniereCarte().getImageAssociee());
		this.setIcon(this.image);
	}
}
