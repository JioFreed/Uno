package Modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Modele.Carte;
import Modele.TasCartes;

/**
 * Class abstraite représentant les différents tas de carte
 * @author Youssef, Ananias
 *
 */
public abstract class TasCartes extends Observable{
	
	/**
	 * Liste des cartes dans le tas
	 */
	protected ArrayList<Carte> listeCarte;
	
	/**
	 * Liste des observers
	 */
	private ArrayList<Observer>listeObservers = new ArrayList<Observer>();


	/**
	 * Initiation d'un tas de carte vide
	 */
	public TasCartes() {
		this.listeCarte = new ArrayList <Carte> ();
	}

	public ArrayList<Carte> getListeCarte() {
		return listeCarte;
	}
	
	public void ajouterObserver (Observer observer)
	{
		this.listeObservers.add(observer);
	}
	
	public abstract void notifierObservers ();
	
	public void setChanged ()
	{
		this.notifierObservers();
	}

	public void setListeCarte(ArrayList<Carte> listeCarte) {
		this.listeCarte = listeCarte;
	}
	
	public void ajouterCarte(Carte c){
		this.listeCarte.add(0, c);
	}
	
	public ArrayList<Observer> getListeObservers() {
		return listeObservers;
	}

	public void setListeObservers(ArrayList<Observer> listeObservers) {
		this.listeObservers = listeObservers;
	}

	/**
	 * Retirer la derniere carte du tas
	 * @return Carte
	 */
	public Carte retirerDerniereCarte () 
	{
		if (this.listeCarte.isEmpty())
			return null;
		
		Carte derniereCarte = this.listeCarte.get(0);
		this.listeCarte.remove(0);
		return derniereCarte;
	}
	
	
	
}
