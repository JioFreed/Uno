package Modele;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Modele.Carte;



public abstract class Joueur extends Observable {
	
	
	private String nom;
	
	protected ArrayList <Carte> main = new ArrayList <Carte> ();

	private boolean estJoueurActuel;
	
	private boolean peutJouer ;
	
	private boolean aUneCarteJouable = false;
	
	private boolean aPiocher= false;

	private int score=0;
	private ArrayList<Observer>listeObservers = new ArrayList<Observer>();
	

	public Joueur (String nom)
	{
		this.nom = nom;
		this.setEstJoueurActuel(false);
		this.setPeutJouer(true);
		this.setaUneCarteJouable(false);
		this.aPiocher= false;
	}

	public boolean getAPiocher()
	{
		return this.aPiocher;
	}
	
	public void setAPiocher(boolean x)
	{
		if(this.aPiocher != x)
		{
			this.aPiocher= x;
			this.setChanged();
		}
	}
	public void ajouterObserver (Observer observer)
	{
		this.listeObservers.add(observer);
	}
	
	public void notifierObservers (boolean nouveauTour)
	{
		for (Observer observerCourant : this.listeObservers)
			observerCourant.update(this, nouveauTour);
	}
	public void setChanged ()
	{
		this.notifierObservers(false);
	}

	public boolean isPeutJouer() {
		return peutJouer;
	}

	public void setPeutJouer(boolean peutJouer) {
		this.peutJouer = peutJouer;
		//this.setEstJoueurActuel(false);
		this.setChangedTurn();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Carte> getMain() {
		return main;
	}
	
	public void ajouterCarte(Carte c){
		this.main.add(0,c);
		this.setChanged();
	}
	public void ajouterCarte(ArrayList<Carte> c){
		for(int i=0;i<c.size();i++)
			this.main.add(0,c.get(i));
		this.setChanged();
	}
	public int getScore()
	{
		return this.score;
	}
	
	public void setScore(int s)
	{
		this.score+=s;
	}
	public boolean verifierCouleur(Talon t)
	{
		for (int i=0;i<this.main.size();i++)
		{
			if(this.main.get(i).getCouleur() == t.listeCarte.get(1).getCouleur())
				return true;
		}
		return false;
	}
	public void retirerCarteMain (Carte carteASup)
	{
		int indice = 0;
		for (Carte carteCourante : this.main)
		{
			if (carteASup.estEgaleA(carteCourante))
			{
				this.main.remove(indice);
				this.setChanged();
				return ;
			}
			indice++;
		}
		this.setChanged();
	}
	
	public void ajouterCarte(Carte c, int i)
	{
		for (int j=0;j<i;j++)
		{
			this.ajouterCarte(c);
		}
		this.setChanged();
	}

	public void setMain(ArrayList<Carte> main) {
		this.main = main;
	}

	public boolean isEstJoueurActuel() {
		return estJoueurActuel;
	}

	public void setEstJoueurActuel(boolean estJoueurActuel) 
	{
		if (this.estJoueurActuel != estJoueurActuel)
		{
			this.estJoueurActuel = estJoueurActuel;
			if (estJoueurActuel)
				this.setChangedTurn();
			else
				this.setChanged();
		}
	}
	public void setChangedTurn ()
	{
		this.notifierObservers(true);
	}
	public Carte retirerCarteMain (int placeCarte)
	{
		if (this.main.size() == 0)
			return null;
		else
		{
			Carte carteRetiree = this.main.get(placeCarte);
			this.main.remove(placeCarte);
			this.setChanged();
			return carteRetiree;
		}
		
	}
	
	public Carte getDerniereCarte()
	{
		return this.main.get(0);
	}
	
	public Carte getCarteChoisie(int i)
	{
		return this.main.get(i);
	}
	
	public boolean carteJouable(Talon t)
	{
		for (Carte c : this.main){
			if(t.getDerniereCarte().comparerCarte(c))
				return true;
		}
		return false;
	}
	
	public boolean isaUneCarteJouable() {
		return aUneCarteJouable;
	}

	public void setaUneCarteJouable(boolean aUneCarteJouable) {
		if (this.aUneCarteJouable  !=  aUneCarteJouable)
		{
			this.aUneCarteJouable = aUneCarteJouable;
			this.setChanged();
		}
		
		
		
	}

	public abstract boolean douter();
	public abstract void passerSonTour(Talon t);;
	public abstract int choisirCouleur(Talon t,Joueur j, Joueur j2);
	
	public abstract int choisirCarte(Talon t,Joueur j, Joueur j2);
	
	public abstract int choisirAction(Talon t,Joueur j, Joueur j2);
	
	

}

