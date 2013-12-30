package Controleur;

import java.util.ArrayList;
import java.util.Observer;

import Modele.Carte;
import Modele.Talon;
//import Modele.FenetreParametres;
import Modele.Joueur;
import Modele.Partie;
import Modele.Pioche;


public class Controleur
{
	private Partie partie;
	
	
	public Controleur (Partie partie)
	{
		this.partie = partie;
	}
	
	
	public void demarerLaPartie ()
	{
		this.partie.demarerPartie();
	}
	
	public void setCarteActuelle(Carte c)
	{
		this.partie.getManche().setCarteActuelle(c);
	}
	public void piocherCarte()
	{
		this.partie.getManche().piocherCarte();
	}

	public void jouerCarte (Carte c)
	{
		this.partie.getManche().jouerCarte(c);
	}
	public void jouerCarte()
	{
		this.partie.getManche().jouerCarte();
	}
	
	public void passerTour()
	{
		this.partie.getManche().passerTour();
	}
	public void jouerCarte (Joueur j)
	{
		this.partie.getManche().jouerCarte(j);
	}
	
	public void ajouterObserver (Observer o)
	{
		this.partie.getManche().ajouterObserver(o);
	}
	public ArrayList<Joueur> getJoueurs ()
	{
		return this.partie.getManche().getJoueurs();
	}
	
	
	public Pioche getPioche ()
	{
		return this.partie.getManche().getPioche();
	}
	
	public Talon getTalon ()
	{
		return this.partie.getManche().getTalon();
	}
	
	public Joueur getJoueurCourant()
	{
		return this.partie.getManche().getJoueurCourant();
	}
}

