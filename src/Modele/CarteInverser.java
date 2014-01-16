package Modele;

import java.util.ArrayList;
import java.util.Collections;

import Vue.Images;


/**
 * Classe représentant la carte inverser
 * @author Youssef, Ananias
 *
 */
public class CarteInverser extends Carte{

	/**
	 * Constructeur de la carte Inverser 
	 * @param couleur
	 * 		couleur de la carte
	 */
	public CarteInverser(int couleur) {
		super(couleur, 14, -1,20);
	}
	

	public void effetCarte(Joueur joueur, Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		if (j.size() <3){
			joueurAffecte.passerSonTour(null);
			joueurAffecte.setEstJoueurActuel(false);
			joueur.setEstJoueurActuel(true);
		}
		else
			Collections.reverse(j);
		
	}



	@Override
	public String getImageAssociee() {
		if(super.getCouleur() == 1) //Rouge
			return Images.InverserRed;
		else if(super.getCouleur() == 2) // Green
			return Images.Inversergreen;
		else if (super.getCouleur() == 3) // Blue
			return Images.Inverserblue;
		else if(super.getCouleur() == 4) // Yellow
			return Images.Inverserjaune;
		return null;
	}

}
