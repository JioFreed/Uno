package Modele;


import java.util.ArrayList;

import Modele.Carte;



public abstract class Joueur {
	
	
	private String nom;
	
	protected ArrayList <Carte> main = new ArrayList <Carte> ();

	private boolean estJoueurActuel;
	
	private boolean peutJouer ;
	
	private int score=0;
	

	public Joueur (String nom)
	{
		this.nom = nom;
		this.setEstJoueurActuel(true);
		this.setPeutJouer(true);
	}


	public boolean isPeutJouer() {
		return peutJouer;
	}

	public void setPeutJouer(boolean peutJouer) {
		this.peutJouer = peutJouer;
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
	}
	public void ajouterCarte(ArrayList<Carte> c){
		for(int i=0;i<c.size();i++)
			this.main.add(0,c.get(i));
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
				return ;
			}
			indice++;
		}
	}
	
	public void ajouterCarte(Carte c, int i)
	{
		for (int j=0;j<i;j++)
		{
			this.ajouterCarte(c);
		}
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
		}
	}
	public Carte retirerCarteMain (int placeCarte)
	{
		if (this.main.size() == 0)
			return null;
		else
		{
			Carte carteRetiree = this.main.get(placeCarte);
			this.main.remove(placeCarte);
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
	
	public abstract boolean douter();
	public abstract void passerSonTour(Talon t);;
	public abstract int choisirCouleur(Talon t,Joueur j, Joueur j2);
	
	public abstract int choisirCarte(Talon t,Joueur j, Joueur j2);
	
	public abstract int choisirAction(Talon t,Joueur j, Joueur j2);
	
	

}

