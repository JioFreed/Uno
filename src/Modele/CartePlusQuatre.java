package Modele;

import java.util.ArrayList;

public class CartePlusQuatre extends Carte {

	public CartePlusQuatre(int couleur) {
		super(couleur,12,4);
	}

	@Override
	public void effetCarte(Joueur joueur,Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		joueurAffecte.ajouterCarte(p.retirerQuatreDernieresCartes());
		joueurAffecte.passerSonTour(null);
		int choix = joueur.choisirCouleur(t,joueur);
		if (choix == 0)
			this.setCouleur(RED);
		if (choix == 1)
			this.setCouleur(BLUE);
		if (choix == 2)
			this.setCouleur(YELLOW);
		if (choix == 3)
			this.setCouleur(GREEN);
		joueurAffecte.douter();
		for (int i=0;i<joueur.main.size();i++)
		{
			if(joueur.main.get(i).getCouleur() == t.listeCarte.get(1).getCouleur())
				joueur.ajouterCarte(p.retirerQuatreDernieresCartes());
			else
				joueurAffecte.ajouterCarte(p.retirerDeuxDernieresCartes());
		}
	}
		
}

