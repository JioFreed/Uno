package Vue;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import Modele.Joueur;

/**
 * Panel de la liste des joueurs inactif 
 * @author Pret
 *
 */
public class PanelJoueurInactif extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * l'image est une carte cachée
	 */
	private ImageIcon image;
	
	/**
	 * Nom et score des joueurs
	 */
	private TitledBorder titre;

	
	/**
	 * Crée un panel avec le nom et le score des joueurs inactifs
	 * @param joueurConcerne
	 */
	public PanelJoueurInactif(Joueur joueurConcerne) {
		super();

		titre = new TitledBorder(joueurConcerne.getNom()+ " : " + joueurConcerne.getScore());
		this.setBorder(titre);
		this.image = Images.redimensionnerMoy(Images.CACHEE);
		this.setIcon(this.image);

	}

}
