package Modele;



import java.util.ArrayList;

import javax.swing.JOptionPane;

import Vue.Images;


/**
 * Classe représentant la carte plus Quatre
 * @author Pret
 *
 */
public class CartePlusQuatre extends Carte {

	/**
	 * Création de la carte plus quatre
	 * @param couleur
	 * 			couleur de la carte
	 */
	public CartePlusQuatre(int couleur) {
		super(couleur, 12, 4, 50);
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
			if (choix == 1)
				this.setCouleur(BLUE);
			if (choix == 2)
				this.setCouleur(YELLOW);
			if (choix == 3)
				this.setCouleur(GREEN);
		}
		if (t.listeCarte.size() > 1) {
			if (joueurAffecte.douter()) {
				if (joueur.verifierCouleur(t)) {
					if(joueurAffecte instanceof JoueurReel)
						JOptionPane.showMessageDialog(null, joueur.getNom()
							+ " a bien bluffé", "alert",
							JOptionPane.ERROR_MESSAGE);
					joueur.ajouterCarte(p.retirerQuatreDernieresCartes(t));
				} else {
					if(joueurAffecte instanceof JoueurReel)
						JOptionPane.showMessageDialog(null, joueurAffecte.getNom()
							+ " Dommage vous vous êtes trompé", "alert",
							JOptionPane.ERROR_MESSAGE);
					joueurAffecte.ajouterCarte(p
							.retirerQuatreDernieresCartes(t));
					joueurAffecte.ajouterCarte(p.retirerDeuxDernieresCartes(t));
					joueurAffecte.passerSonTour(null);
				}
			} else {
				joueurAffecte.ajouterCarte(p.retirerQuatreDernieresCartes(t));
				joueurAffecte.passerSonTour(null);
			}

		} else {
			joueur.ajouterCarte(p.retirerQuatreDernieresCartes(t));
			joueur.passerSonTour(null);
		}
	}

	@Override
	public String getImageAssociee() {
		// TODO Auto-generated method stub
		return Images.plusFour;
	}
}
