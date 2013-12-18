package Modele;

import java.util.ArrayList;
import java.util.Collections;

public class CarteInverser extends Carte{

	public CarteInverser(int couleur) {
		super(couleur, 14, -1,20);
	}



	@Override
	public void effetCarte(Joueur joueur, Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		if (j.size() <3)
			joueurAffecte.passerSonTour(null);
		else{
			Collections.reverse(j);
			joueur.setPeutJouer(true);
		}
		
	}

}
