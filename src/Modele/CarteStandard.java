package Modele;

import java.util.ArrayList;

public class CarteStandard extends Carte {

	public CarteStandard(int couleur, int valeur) {
		super(couleur, valeur, 0,valeur);
	}

	@Override
	public void effetCarte(Joueur joueur,Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		
	}

	

}
