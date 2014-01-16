package Modele;


import java.util.ArrayList;
import javax.swing.JOptionPane;

import Vue.Images;

/**
 * Classe représentant la carte Joker
 * @author Youssef, Ananias
 *
 */
public class CarteJoker extends Carte {
	
	/**
	 *	Instanciation de la carte joker
	 * @param couleur
	 * 		couleur de la carte
	 */
	public CarteJoker(int couleur) {
		super(couleur, 13, -1, 50);
	}

	@Override
	public void effetCarte(Joueur joueur, Joueur joueurAffecte, Pioche p,
			ArrayList<Joueur> j, Talon t) {
		if (joueur instanceof JoueurReel) {
			Object[] possibleValues = { "Rouge", "Bleu", "Vert", "Jaune" };
			Object selectedValue = JOptionPane.showInputDialog(null,

			"Choix Couleur", "Veuillez choisir une Couleur : ",

			JOptionPane.INFORMATION_MESSAGE, null,

			possibleValues, possibleValues[0]);
			if (selectedValue == "Rouge")
				this.setCouleur(RED);
			else if (selectedValue == "Bleu")
				this.setCouleur(BLUE);
			else if (selectedValue == "Vert")
				this.setCouleur(GREEN);
			else if (selectedValue == "Jaune")
				this.setCouleur(YELLOW);
			else
				this.setCouleur(RED);
		} else {
			int choix = joueur.choisirCouleur(t, joueur, joueurAffecte);
			if (choix == 0)
				this.setCouleur(RED);
			else if (choix == 1)
				this.setCouleur(BLUE);
			else if (choix == 2)
				this.setCouleur(YELLOW);
			else if (choix == 3)
				this.setCouleur(GREEN);

			if (t.listeCarte.size() == 1)
				joueur.passerSonTour(null);
		}

	}

	@Override
	public String getImageAssociee() {
		return Images.joker;
	}

}
