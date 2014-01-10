package Vue;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Modele.Joueur;

public class PanneauInformationChoix extends JPanel {
	public PanneauInformationChoix(ArrayList<Joueur> joueurs) {
		super();

		BoxLayout layout = new BoxLayout(this, BoxLayout.LINE_AXIS);
		this.setLayout(layout);
		for (Joueur joueurCourant : joueurs) {
			this.add(new PanneauChoixJoueur(joueurCourant));
		}
	}
}
