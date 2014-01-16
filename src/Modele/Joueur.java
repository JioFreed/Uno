package Modele;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Modele.Carte;

/**
 * Class représentant le joueur
 * @author Youssef, Ananias
 *
 */

public abstract class Joueur extends Observable {
	
	/**
	 * Nom du joueur
	 */
	private String nom;
	
	/**
	 * main du joueur contenant une liste de carte
	 */
	protected ArrayList <Carte> main = new ArrayList <Carte> ();
	
	/**
	 * boolean pour verifier le joueur actuel
	 */

	private boolean estJoueurActuel;
	
	/**
	 * boolean peut jouer
	 */
	private boolean peutJouer ;
	
	/**
	 * boolean si le joueur a une carte jouable
	 */
	private boolean aUneCarteJouable = false;
	
	/**
	 * boolean verifier si le joueru a piocher
	 */
	private boolean aPiocher= false;
	/**
	 * score du joueur 
	 */
	private int score=0;
	
	/**
	 * liste des observers
	 */
	private ArrayList<Observer>listeObservers = new ArrayList<Observer>();
	
	/**
	 * Constructeur du joueur
	 * @param nom
	 * 		nom du joueur
	 */
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

	/**
	 * Vérifier si le joueur peut joueur
	 * @return
	 * 		true s'il peut jouer
	 * 		False sinon
	 */
	public boolean isPeutJouer() {
		return peutJouer;
	}

	public void setPeutJouer(boolean peutJouer) {
		this.peutJouer = peutJouer;
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
	
	/**
	 * Ajouter une carte à la main du joueur
	 * @param c
	 * 	
	 *		Carte à ajouter
	 */
	public void ajouterCarte(Carte c){
		this.main.add(0,c);
		this.setChanged();
	}
	
	/**
	 * 
	 * Ajouter une liste de carte à la main du joueur
	 * @param c
	 * 		Liste de carte à ajouter
	 */
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
	
	/**
	 * Verifier si la carte à la meme couleur que l'avant derniere carte dans la pioche 
	 * dans le cas d'une carte +4
	 * @param t
	 * 		Talon de la partie
	 * @return
	 */
	public boolean verifierCouleur(Talon t)
	{
		for (int i=0;i<this.main.size();i++)
		{
			if(this.main.get(i).getCouleur() == t.listeCarte.get(1).getCouleur())
				return true;
		}
		return false;
	}
	
	/**
	 * Retirer une carte de la main du joueur courant
	 * @param carteASup
	 * 		Carte à supprimer
	 */
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

	/**
	 * Vérifier si le joueur est le joueurActuel
	 * @return
	 */
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
	
	
	public Carte getDerniereCarte()
	{
		return this.main.get(0);
	}
	
	public Carte getCarteChoisie(int i)
	{
		return this.main.get(i);
	}
	
	/**
	 * Vérifier si un joueur à une carte jouable
	 * @return
	 * 		True si c'est le cas
	 * 		False sinon
	 */
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

	/**
	 * Vérifier si le joueur choisi de revoir le coup du joueur précédent
	 * dans le cas de la carte +4
	 * @return
	 */
	public abstract boolean douter();
	
	/**
	 * Permettre au joueur de passer son tour
	 * @param
	 * 		Talon de la partie 
	 */
	public abstract void passerSonTour(Talon t);
	
	/**
	 * Permettre au joueur de choisir une couleur 
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @param j2
	 * 		Joueur suivant
	 * 
	 * @return
	 * 
	 * 		la couleur choisie
	 */
	public abstract int choisirCouleur(Talon t,Joueur j, Joueur j2);
	
	/**
	 * Choisir la carte à jouer
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @param j2
	 * 		Joueur suivant
	 * @return
	 * 		l'indice de la carte à jouer
	 */
	public abstract int choisirCarte(Talon t,Joueur j, Joueur j2);
	
	/**
	 * Choisir l'action a effectuer
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @param j2
	 * 		Joueur suivant
	 * @return
	 */
	public abstract int choisirAction(Talon t,Joueur j, Joueur j2);
	
	

}

