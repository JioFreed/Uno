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
			if(parametrePartie())
			{
				manche.commencerPartie();this.partieEstFinie();}
			else
			{
				System.out.println("Les param�tres de la partie ne sont pas valides");
				this.setPartieEstFinie(true);
			}
		}
	}
	
	public boolean parametrePartie()
	{
		 return manche.joueurs.size() >2 && manche.joueurs.size() <7 ? true : false;
		
	}
	public void partieEstFinie()
	{
		if (!this.partieEstFinie) {
				if (this.manche.getScoreTotal() >=500) {
					this.partieEstFinie = true;
					System.out.println(this.manche.getJoueurGagnant().getNom()+ " a gagn� la partie ");
				
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
