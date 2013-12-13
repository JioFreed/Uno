package Modele;

import java.util.ArrayList;

public class CarteStop extends Carte{

	public CarteStop(int couleur) {
		super(couleur, 10,-1,20);
	}

	
	public void effetCarte(Joueur joueur,Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		joueurAffecte.passerSonTour(null);
		
	}

	

}
