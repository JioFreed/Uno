package Modele;

import java.util.Scanner;

public class JoueurVirtuel extends Joueur {
	
	public JoueurVirtuel(String nom)
	{
		super(nom);
	}
	
	public void passerSonTour(Talon t)
	{
		this.setEstJoueurActuel(false);
	}
	public int choisirCouleur(Talon t)
	{
		
		return 0;
	}
	
	public int choisirCarte(Talon t)
	{
		for (int i=0; i<this.main.size();i++)
		{
			if (this.main.get(i).comparerCarte(t.getDerniereCarte()))
				return i;
		}
		return 0;		
	}
	
	public int choisirAction(Talon t)
	{
		for (int i=0; i<this.main.size();i++)
		{
			if (this.main.get(i).comparerCarte(t.getDerniereCarte()))
				return 0;
		}
		return 1;		
	}
	
}
