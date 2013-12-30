package Modele;

import java.util.ArrayList;

import Vue.Images;

public class CarteStandard extends Carte {

	public CarteStandard(int couleur, int valeur) {
		super(couleur, valeur, 0,valeur);
	}

	@Override
	public void effetCarte(Joueur joueur,Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		
	}

	@Override
	public String getImageAssociee() {
		if(super.getCouleur() == 1)
		{
			if(super.getValeur() == 0)
				return Images.redNone;
			else if(super.getValeur() == 1)
				return Images.redOne;
			else if(super.getValeur() == 2)
				return Images.redTwo;
			else if(super.getValeur() == 3)
				return Images.redThree;
			else if(super.getValeur() == 4)
				return Images.redFour;
			else if(super.getValeur() == 5)
				return Images.redFive;
			else if(super.getValeur() == 6)
				return Images.redSix;
			else if(super.getValeur() == 7)
				return Images.redSeven;
			else if(super.getValeur() == 8)
				return Images.redEight;
			else if(super.getValeur() == 9)
				return Images.redNine;
		}
		else if(super.getCouleur() == 2)
		{
			if(super.getValeur() == 0)
				return Images.greenNone;
			else if(super.getValeur() == 1)
				return Images.greenOne;
			else if(super.getValeur() == 2)
				return Images.greenTwo;
			else if(super.getValeur() == 3)
				return Images.greenThree;
			else if(super.getValeur() == 4)
				return Images.greenFour;
			else if(super.getValeur() == 5)
				return Images.greenFive;
			else if(super.getValeur() == 6)
				return Images.greenSix;
			else if(super.getValeur() == 7)
				return Images.greenSeven;
			else if(super.getValeur() == 8)
				return Images.greenEight;
			else if(super.getValeur() == 9)
				return Images.greenNine;
		}
		else if(super.getCouleur() == 3)
		{
			if(super.getValeur() == 0)
				return Images.blueNone;
			else if(super.getValeur() == 1)
				return Images.blueOne;
			else if(super.getValeur() == 2)
				return Images.blueTwo;
			else if(super.getValeur() == 3)
				return Images.blueThree;
			else if(super.getValeur() == 4)
				return Images.blueFour;
			else if(super.getValeur() == 5)
				return Images.blueFive;
			else if(super.getValeur() == 6)
				return Images.blueSix;
			else if(super.getValeur() == 7)
				return Images.blueSeven;
			else if(super.getValeur() == 8)
				return Images.blueEight;
			else if(super.getValeur() == 9)
				return Images.blueNine;
		}
		else if(super.getCouleur() == 4)
		{
			if(super.getValeur() == 0)
				return Images.jauneNone;
			else if(super.getValeur() == 1)
				return Images.jauneOne;
			else if(super.getValeur() == 2)
				return Images.jauneTwo;
			else if(super.getValeur() == 3)
				return Images.jauneThree;
			else if(super.getValeur() == 4)
				return Images.jauneFour;
			else if(super.getValeur() == 5)
				return Images.jauneFive;
			else if(super.getValeur() == 6)
				return Images.jauneSix;
			else if(super.getValeur() == 7)
				return Images.jauneSeven;
			else if(super.getValeur() == 8)
				return Images.jauneEight;
			else if(super.getValeur() == 9)
				return Images.jauneNine;
		}
		return null;
	}

	

}
