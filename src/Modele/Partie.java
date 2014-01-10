package Modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import Vue.*;

public class Partie extends Observable{
	private Manche manche;
	public static boolean partieEstFinie = false;
	public static int scoreGagnant = 500;
	public boolean nextRound= false;

	public ArrayList<Observer> listeObservers = new ArrayList<Observer>();

	public Partie(ParametrePartie p) {
		scoreGagnant = p.getScoreGagnant();
		manche = new Manche();
		this.manche.joueurs=p.getJoueurs();
	}
	public boolean isNextRound() {
		return nextRound;
	}
	public void init()
	{
		this.manche.setMancheEstFinie(false);
		this.manche.setUno(false);
		this.manche.setJoueurCourant(null);
		this.manche.setCarteCourante(null);
	}

	public void setNextRound(boolean nextRoun) {
		nextRound = nextRoun;
		this.setChanged();
	}


	public void ajouterJoueur(Joueur j) {
		manche.ajouterJoueur(j);
	}
	public void ajouterObserver (Observer observer)
	{
		this.listeObservers.add(observer);
	}
	

	public void demarerPartie() {
		manche.commencerPartie();
	}

	public Manche getManche() {
		return manche;
	}

	public void setManche(Manche manche) {
		this.manche = manche;
	}

	public boolean isPartieEstFinie() {
		return partieEstFinie;
	}

	public void setPartieEstFinie(boolean partieEstFini) {
		partieEstFinie = partieEstFini;
	}

	public static int getScoreGagnant() {
		return scoreGagnant;
	}

	public static void setScoreGagnant(int scoreGagnant) {
		Partie.scoreGagnant = scoreGagnant;
	}


}
