package Modele;

import java.util.ArrayList;

public class CarteStop extends Carte{

	public CarteStop(int couleur) {
		super(couleur, 10,-1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effetCarte(Joueur joueur,Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		joueurAffecte.passerSonTour(null);
		
	}

	

}
