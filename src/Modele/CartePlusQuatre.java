package Modele;

import java.util.ArrayList;

public class CartePlusQuatre extends Carte {

	public CartePlusQuatre(int couleur) {
		super(couleur,12,4,50);
	}

	@Override
	public void effetCarte(Joueur joueur,Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		int choix = joueur.choisirCouleur(t,joueur,joueurAffecte);
		if (choix == 0)
			this.setCouleur(RED);
		if (choix == 1)
			this.setCouleur(BLUE);
		if (choix == 2)
			this.setCouleur(YELLOW);
		if (choix == 3)
			this.setCouleur(GREEN);
		if(t.listeCarte.size() > 1)
		{
			if(joueurAffecte.douter())
			{
				if (joueur.verifierCouleur(t))
				{
					System.out.println(joueur.getNom() + " a bien bluffé !! ");
					joueur.ajouterCarte(p.retirerQuatreDernieresCartes(t));
				}
				else{
					System.out.println(joueurAffecte.getNom() + "Dommage vous vous êtes trompé");
					joueurAffecte.ajouterCarte(p.retirerQuatreDernieresCartes(t));
					joueurAffecte.ajouterCarte(p.retirerDeuxDernieresCartes(t));
					joueurAffecte.passerSonTour(null);
				}
			}
			else
			{
				joueurAffecte.ajouterCarte(p.retirerQuatreDernieresCartes(t));
				joueurAffecte.passerSonTour(null);
			}
			
		}
		else
		{
			joueur.ajouterCarte(p.retirerQuatreDernieresCartes(t));
			joueur.passerSonTour(null);
		}
	}
}


