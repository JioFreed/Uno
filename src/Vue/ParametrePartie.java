package Vue;

import Modele.*;
import java.util.ArrayList;



public class ParametrePartie 
{
	
	private int scoreGagnant;
	private ArrayList<Joueur> joueursParticipants;
	
	public ParametrePartie ()
	{
		this.scoreGagnant = 500;	
		this.joueursParticipants = new ArrayList<Joueur> ();
	}
	
	public boolean parametresSontValides ()
	{
		return (this.joueursParticipants.size() >= 2 && this.joueursParticipants.size() <= 7) ? true: false;
	}
	
	public void ajouterJoueur (Joueur joueurAjoute)
	{
		if (joueurAjoute == null)
			return ;
		if (!peutAjouterJoueur(joueurAjoute.getNom()))
			return ;
		else
			this.joueursParticipants.add(joueurAjoute);
	}
	
	public boolean peutAjouterJoueur (String nom)
	{
		if (nom.length() < 1)
			return false;
		
		if (this.joueursParticipants.size() > 7)
			return false;
		
		if (!this.joueursParticipants.isEmpty())
		{
			for (Joueur joueurCourant : this.joueursParticipants)
			{
				if (joueurCourant.getNom().equals(nom))
					return false;
			}
		}
		
		return true;
	}
	
	public int getNombreJoueurs ()
	{
		return this.joueursParticipants.size();
	}
	
	public boolean supprimerJoueur (String nomJoueur)
	{
		if (!this.joueursParticipants.isEmpty())
		{
			for (Joueur joueurCourant : this.joueursParticipants)
			{
				if (joueurCourant.getNom().equals(nomJoueur))
					return this.joueursParticipants.remove(joueurCourant);
			}
		}
		return false;
	}
	
	
	public ArrayList<Joueur> getJoueurs ()
	{
		
		if (!this.parametresSontValides())
			return null;
		
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
		for (int i = 0; i < this.joueursParticipants.size(); i++)
			joueurs.add(0,this.joueursParticipants.get(i));
		return joueurs;		
	}
	

	public int getScoreGagnant() 
	{
		return scoreGagnant;
	}
	
	public void setScoreGagnant(int scoreGagnant) 
	{
		this.scoreGagnant = scoreGagnant;
	}
	

	
}
