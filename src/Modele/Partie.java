package Modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import Vue.*;

/**
 * Class représentant la partie
 * 
 * @author Youssef, Ananias
 *
 */
public class Partie extends Observable{
	
	/**
	 * la manche en cours
	 */
	private Manche manche;
	/**
	 * le score gagnant de la partie
	 */
	public static int scoreGagnant = 500;
	
	/**
	 * Liste des joueurs participants 
	 */
	public ArrayList<Joueur> joueursParticipants = new ArrayList<Joueur>();

	/**
	 * Liste des observers
	 */
	public ArrayList<Observer> listeObservers = new ArrayList<Observer>();

	
	/**
	 * Construction de la partie à partir des paramètres
	 * @param p
	 * 		parametres de la partie
	 */
	public Partie(ParametrePartie p) {
		scoreGagnant = p.getScoreGagnant();
		this.joueursParticipants = p.getJoueurs();
	}
	
	/**
	 * Méthode permettant de créer une nouvelle manche et de lui affecter une liste de joueurs
	 */
	public void init()
	{	
		this.manche= new Manche();
		this.manche.joueurs = this.joueursParticipants;
	}

	/**
	 * Méthode permettant de démarer une partie
	 */
	public void demarerPartie() {
		manche.commencerManche();
	}
	
	public ArrayList<Joueur> getJoueursParticipants() {
		return joueursParticipants;
	}
	public void setJoueursParticipants(ArrayList<Joueur> joueursParticipants) {
		this.joueursParticipants = joueursParticipants;
	}
	
	public void ajouterJoueur(Joueur j) {
		manche.ajouterJoueur(j);
	}
	public void ajouterObserver (Observer observer)
	{
		this.listeObservers.add(observer);
	}

	public Manche getManche() {
		return this.manche;
	}

	public void setManche(Manche manche) {
		this.manche = manche;
	}

	public static int getScoreGagnant() {
		return scoreGagnant;
	}

	public static void setScoreGagnant(int scoreGagnant) {
		Partie.scoreGagnant = scoreGagnant;
	}


}
