package Modele;

import java.util.ArrayList;

import Modele.Carte;



public abstract class Carte 
{
	public final static int BLACK = 0;
	public final static int RED = 1;
	public final static int GREEN = 2;
	public final static int BLUE = 3;
	public final static int YELLOW = 4;
	
	public final static int STOP= 10;
	public final static int DOUBLER = 11;
	public final static int QUADRUPLER= 12;
	public final static int JOKER = 13;
	public final static int INVERSER = 14;
	
	public final static String[] COULEUR={"Black","Red","Green","Blue","Yellow"};
	public final static String[] VALEUR={"0","1","2","3","4","5","6","7","8","9","Stop","+2","+4","Joker","Inverser"};

	
	private int couleur;
	private int valeur;
	private int plus;
	
	 public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(Carte.VALEUR[this.valeur]);
		sb.append(" de ");
		sb.append(Carte.COULEUR[this.couleur]);
		return sb.toString();
	 } 
	 
	public Carte (int couleur, int valeur,int plus)
	{	
		this.couleur = couleur;
		this.valeur= valeur;
		this.plus=plus;
	}
	
	
	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public boolean estEgaleA (Carte carte)
	{
		return (this.couleur == carte.getCouleur() && this.valeur == carte.getValeur());
	}
	
	
	public abstract void effetCarte (Joueur joueur, Joueur joueurAffecte, Pioche p, ArrayList<Joueur> j,Talon t);
	
	public boolean comparerCarte(Carte c)
	{
		if((this.couleur == c.couleur) || (this.valeur == c.valeur))
			return true;
		else if (c instanceof CarteJoker || c instanceof CartePlusQuatre)
			return true;
		
		return false;
		
	}
	

	
}
