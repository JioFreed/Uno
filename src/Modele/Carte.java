package Modele;

import java.util.ArrayList;

import Modele.Carte;

/**
 * Classe Abstraite décrivant les cartes
 * 
 * @author Youssef, Ananias
 * 
 */

public abstract class Carte {
	/**
	 * Valeur de la couleur black
	 */
	public final static int BLACK = 0;

	/**
	 * Valeur de la couleur red
	 */
	public final static int RED = 1;

	/**
	 * Valeur de la couleur green
	 */
	public final static int GREEN = 2;
	/**
	 * Valeur de la couleur blue
	 */
	public final static int BLUE = 3;
	/**
	 * Valeur de la couleur Yellow
	 */
	public final static int YELLOW = 4;

	/**
	 * Valeur de la carte Stop
	 */
	public final static int STOP = 10;

	/**
	 * Valeur de la carte +2
	 */
	public final static int DOUBLER = 11;

	/**
	 * Valeur de la carte +4
	 */
	public final static int QUADRUPLER = 12;

	/**
	 * Valeur de la carte Joker
	 */
	public final static int JOKER = 13;
	/**
	 * Valeur de la carte Inverser
	 */
	public final static int INVERSER = 14;
	/**
	 * Liste des couleurs possible
	 */
	public final static String[] COULEUR = { "Black", "Red", "Green", "Blue",
			"Yellow" };

	/**
	 * Liste des valeurs de cartes possibles
	 */
	public final static String[] VALEUR = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "Stop", "+2", "+4", "Joker", "Inverser" };

	/**
	 * Couleur de la carte
	 */
	private int couleur;
	/**
	 * Valeur de la carte
	 */
	private int valeur;

	/**
	 * valeur déterminant si la carte est de type +2 ou +4 sinon 0 pour le reste
	 */
	private int plus;
	/**
	 * Valeur de la carte à la fin de la manche
	 */
	private int point;
	
	/**
	 * 
	 * Méthode permettant de récupérer les information de la carte
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(Carte.VALEUR[this.valeur]);
		sb.append(" de ");
		sb.append(Carte.COULEUR[this.couleur]);
		return sb.toString();
	}

	/** 
	 * Instancie une carte
	 * @param couleur
	 * 		Couleur de la carte
	 * @param valeur
	 * 		Valeur de la carte
	 * @param plus
	 * 		Si la carte est +2 faut mettre 2 par exemple
	 * @param point
	 * 		Valeur de la carte en fin de manche
	 */
	public Carte(int couleur, int valeur, int plus, int point) {
		this.couleur = couleur;
		this.valeur = valeur;
		this.plus = plus;
		this.point = point;
	}
	
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Vérifier si les deux cartes sont égales
	 * @param carte
	 * 		Carte à comparer
	 * @return
	 * 		true si les deux cartes sont égales 
	 * 		false sinon
	 */
	public boolean estEgaleA(Carte carte) {
		return (this.couleur == carte.getCouleur() && this.valeur == carte
				.getValeur());
	}


	/**
	 * Méthode comparant les cartes si elle ont la meme couleur ou valeur
	 * @param c
	 * 		Carte à comparer
	 * @return
	 * 		true si les cartes ont la meme couleur ou valeur, ou si la carte à comparer et de type cartejoker ou carte plsu quatre
	 * 		false sinon
	 */
	public boolean comparerCarte(Carte c) {
		if ((this.couleur == c.couleur) || (this.valeur == c.valeur))
			return true;
		else if (c instanceof CarteJoker || c instanceof CartePlusQuatre)
			return true;

		return false;

	}
	
	
	/**
	 * Méthode abstraite définissant l'effet de la carte
	 * @param joueur
	 * 		Joueur courant
	 * @param joueurAffecte
	 * 		Joueur suivant
	 * @param p
	 * 		Pioche de la partie
	 * @param j
	 * 		Liste des joueurs participants
	 * @param t
	 * 		Talon de la partie
	 */
	public abstract void effetCarte(Joueur joueur, Joueur joueurAffecte,
			Pioche p, ArrayList<Joueur> j, Talon t);

	
	/**
	 * Récuperer l'image de la carte
	 * @return
	 * 		L'image associée
	 * 	
	 */
	public abstract String getImageAssociee();

}
