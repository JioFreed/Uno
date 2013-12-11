package Modele;

import java.util.ArrayList;



public class CartePlusDeux extends Carte{

	
	public CartePlusDeux(int couleur) {
		super(couleur, 11, 2);
	}

	@Override
	public void effetCarte(Joueur joueur,Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
			joueurAffecte.ajouterCarte(p.retirerDeuxDernieresCartes());
			joueurAffecte.passerSonTour(null);
		}

}
