package Modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Modele.Carte;
import Modele.TasCartes;


public abstract class TasCartes extends Observable{
	
	protected ArrayList<Carte> listeCarte;
	private ArrayList<Observer>listeObservers = new ArrayList<Observer>();
	

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

	public Carte retirerDerniereCarte () 
	{
		if (this.listeCarte.isEmpty())
			return null;
		
		Carte derniereCarte = this.listeCarte.get(0);
		this.listeCarte.remove(0);
		return derniereCarte;
	}
	
	
	
}
