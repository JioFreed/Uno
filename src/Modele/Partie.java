package Modele;

import java.util.Scanner;

public class Partie {
	private Manche manche;
	private boolean partieEstFinie = false;
	public static int scoreGagnant = 10000;

	public Partie() {
		manche = new Manche();

	}

	public void ajouterJoueur(Joueur j) {
		manche.ajouterJoueur(j);
	}

	public void affichageDebutPartie() {
		System.out
				.println("**************************************************************************\n"
						+ "******                                                              ******\n"
						+ "******                        Bienvenue                             ******\n"
						+ "******                           Uno                                ******\n"
						+ "******                                                              ******\n"
						+ "**************************************************************************");
	}

	public void parametrePartie() {
		int choix = 0;
		while (choix < 1) {
			System.out.println("Veuillez choisir le nombre de joueurs : ");
			Scanner sc = new Scanner(System.in);
			choix = sc.nextInt();
			for (int i = 0; i < choix; i++) {
				System.out.println("Veuillez choisir le nom du joueur " + i + " :");
				String nom = sc.next();
				int j = 0;
				while (j != 1 && j != 2) {
					System.out.println("Veuillez choisir le type du joueur : 1 - JoueurReel  2- JoueurVirtuel");
					j = sc.nextInt();
					if (j == 1)
						ajouterJoueur(new JoueurReel(nom));
					else if(j==2) {
						int k = 0;
						while (k != 1 && k != 2 && k != 3) {
							System.out.println("Veuillez choisir le type du joueur virtuel : 1- Aggressif  2- Imprevisible  3- Normal");
							k=sc.nextInt();
							if (k == 1)
								ajouterJoueur(new JoueurVirtuel(nom,new Aggressif()));
							else if (k == 2)
								ajouterJoueur(new JoueurVirtuel(nom,new Imprevisible()));
							else if(k == 3)
								ajouterJoueur(new JoueurVirtuel(nom,new Avance()));
						}
					}

				}
			}
		}
	}

	public void demarerPartie() {
		this.affichageDebutPartie();
		this.parametrePartie();
		this.partieEstFinie();
		int i = 1;
		while (!partieEstFinie) {
			if (VerificationParametrePartie()) {
				System.out.println("Début de la Manche " + i + " :");
				manche.commencerPartie();
				this.partieEstFinie();
				i++;
			} else {
				System.out.println("Les paramètres de la partie ne sont pas valides");
				this.setPartieEstFinie(true);
			}
		}
	}

	public Manche getManche() {
		return manche;
	}

	public void setManche(Manche manche) {
		this.manche = manche;
	}

	public boolean VerificationParametrePartie() {
		return manche.joueurs.size() >= 2 && manche.joueurs.size() <= 7 ? true
				: false;

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
