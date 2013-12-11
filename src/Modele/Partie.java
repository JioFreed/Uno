package Modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;



import Modele.Carte;
import Modele.Talon;
import Modele.Joueur;
import Modele.Pioche;
import Modele.TasCartes;

public class Partie {
	private Manche manche;
	private boolean partieEstFinie=false;
	
	public Partie(Manche m){
		manche= m;
	}
	
	public void ajouterJoueur(Joueur j)
	{
		manche.ajouterJoueur(j);
	}
	public void demarerPartie()
	{
		this.partieEstFinie();
		while(!partieEstFinie)
		{
			manche.commencerPartie();this.partieEstFinie();}
	}
	
	public void partieEstFinie()
	{
		if (!this.partieEstFinie) {
				if (this.manche.getScoreTotal() >=500) {
					this.partieEstFinie = true;
					System.out.println(this.manche.getJoueurGagnant().getNom()+ " a gagné la partie ");
				
				}
			}
		}
	
	public boolean isPartieEstFinie() {
		return partieEstFinie;
	}

	public void setPartieEstFinie(boolean partieEstFinie) {
		this.partieEstFinie = partieEstFinie;
	}
	
	
}
