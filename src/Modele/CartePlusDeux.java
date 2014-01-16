package Modele;

import java.util.ArrayList;

import Vue.Images;

/**
 * Classe représentant la carte plus deux
 * @author Youssef,Ananias
 *
 */

public class CartePlusDeux extends Carte{

	/**
	 * Instanciation de la carte plus deux 
	 * @param couleur
	 * 		Couleur de la carte
	 */
	public CartePlusDeux(int couleur) {
		super(couleur, 11, 2,20);
	}

	@Override
	public void effetCarte(Joueur joueur,Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
			joueurAffecte.ajouterCarte(p.retirerDeuxDernieresCartes(t));
			joueurAffecte.passerSonTour(null);
		}

	@Override
	public String getImageAssociee() {
		if(super.getCouleur() == 1) //Rouge
			return Images.redPlusTwo;
		else if(super.getCouleur() == 2) // Green
			return Images.greenPlusTwo;
		else if (super.getCouleur() == 3) // Blue
			return Images.bluePlusTwo;
		else if(super.getCouleur() == 4) // Yellow
			return Images.jaunePlusTwo;
		return null;
	}

}
