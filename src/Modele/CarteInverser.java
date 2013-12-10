package Modele;

import java.util.ArrayList;
import java.util.Collections;

public class CarteInverser extends Carte{

	public CarteInverser(int couleur) {
		super(couleur, 14, -1);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void effetCarte(Joueur joueur, Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t) {
		Collections.reverse(j);
		
	}

}
