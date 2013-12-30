package Modele;

import java.util.ArrayList;

import Vue.Images;

public class CarteJoker extends Carte {

	public CarteJoker(int couleur) {
		super(couleur, 13, -1,50);
	}

	@Override
	public void effetCarte(Joueur joueur, Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		int choix = joueur.choisirCouleur(t,joueur,joueurAffecte);
		if (choix == 0)
			this.setCouleur(RED);
		else if (choix == 1)
			this.setCouleur(BLUE);
		else if (choix == 2)
			this.setCouleur(YELLOW);
		else if (choix == 3)
			this.setCouleur(GREEN);
		
		if(t.listeCarte.size() == 1)
			joueur.passerSonTour(null);
			
	}

	@Override
	public String getImageAssociee() {
		return Images.joker;
	}
	

}
