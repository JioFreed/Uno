package Modele;

import java.util.ArrayList;

public class CarteJoker extends Carte {

	public CarteJoker(int couleur) {
		super(couleur, 13, -1,50);
	}

	@Override
	public void effetCarte(Joueur joueur, Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		int choix = joueur.choisirCouleur(t,joueur,joueurAffecte);
		if (choix == 0)
			this.setCouleur(RED);
		if (choix == 1)
			this.setCouleur(BLUE);
		if (choix == 2)
			this.setCouleur(YELLOW);
		if (choix == 3)
			this.setCouleur(GREEN);
	}

}
