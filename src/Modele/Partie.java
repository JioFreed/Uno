package Modele;

import java.util.Scanner;
import Vue.*;

public class Partie {
	private ParametrePartie parametres;
	private Manche manche;
	private boolean partieEstFinie = false;
	public static int scoreGagnant = 500;

	public Partie(ParametrePartie p) {
		this.parametres = p;
		scoreGagnant = p.getScoreGagnant();
		manche = new Manche();
		this.manche.joueurs=p.getJoueurs();
	}

	public void ajouterJoueur(Joueur j) {
		manche.ajouterJoueur(j);
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

	public void partieEstFinie() {
		if (!this.partieEstFinie) {
			if (this.manche.getScoreTotal() >= getScoreGagnant()) {
				this.partieEstFinie = true;
				System.out.println(this.manche.getJoueurGagnant().getNom()
						+ " a gagné la partie ");

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

}
