package Modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import Vue.*;

public class Partie extends Observable{
	private ParametrePartie parametres;
	private Manche manche;
	private boolean partieEstFinie = false;
	public static int scoreGagnant = 500;
	public ArrayList<Observer> listeObservers = new ArrayList<Observer>();

	public Partie(ParametrePartie p) {
		this.parametres = p;
		scoreGagnant = p.getScoreGagnant();
		manche = new Manche();
		this.manche.joueurs=p.getJoueurs();
	}

	public void ajouterJoueur(Joueur j) {
		manche.ajouterJoueur(j);
	}
	public void ajouterObserver (Observer observer)
	{
		this.listeObservers.add(observer);
	}
	

	public void demarerPartie() {
		this.partieEstFinie();
		if(!this.partieEstFinie)
		{
			manche.commencerPartie();
			this.partieEstFinie();
		}
	}

	public Manche getManche() {
		return manche;
	}

	public void setManche(Manche manche) {
		this.manche = manche;
	}

	public void partieEstFinie() {
		if (!this.partieEstFinie) {
			if (this.manche.getScoreTotal() >= getScoreGagnant()) {
				this.partieEstFinie = true;
				System.out.println(this.manche.getJoueurGagnant().getNom()
						+ " a gagné la partie ");
				this.setChanged();
			}
		}
	}

	public boolean isPartieEstFinie() {
		return partieEstFinie;
	}

	public void setPartieEstFinie(boolean partieEstFinie) {
		this.partieEstFinie = partieEstFinie;
	}

	public static int getScoreGagnant() {
		return scoreGagnant;
	}

	public static void setScoreGagnant(int scoreGagnant) {
		Partie.scoreGagnant = scoreGagnant;
	}
	public void notifierObservers (boolean nvlePioche)
	{
		for (Observer observerCourant : this.listeObservers)
			observerCourant.update(this, nvlePioche);
	}
	
	public void setChanged ()
	{
		this.notifierObservers(false);
	}

}
