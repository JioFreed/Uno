package Modele;

import java.util.ArrayList;

import Vue.Images;

public class CarteStop extends Carte{

	public CarteStop(int couleur) {
		super(couleur, 10,-1,20);
	}

	
	public void effetCarte(Joueur joueur,Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		joueurAffecte.passerSonTour(null);
		
	}


	@Override
	public String getImageAssociee() {
		if(super.getCouleur() == 1) //Rouge
			return Images.StopRed;
		else if(super.getCouleur() == 2) // Green
			return Images.Stopgreen;
		else if (super.getCouleur() == 3) // Blue
			return Images.Stopblue;
		else if(super.getCouleur() == 4) // Yellow
			return Images.Stopjaune;
		return null;
	}

	

}
