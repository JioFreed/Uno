package Modele;

import java.util.Scanner;

import Vue.ParametrePartie;

public class Partie {
	private ParametrePartie parametres;
	private Manche manche;
	private boolean partieEstFinie = false;
	public static int scoreGagnant = 500;

	public Partie(/* ParametrePartie parametres */) {
		// if (parametres.parametresSontValides())
		// {
		manche = new Manche();
		// this.parametres = parametres;
		// this.manche.joueurs = parametres.getJoueurs();
		// scoreGagnant = parametres.getScoreGagnant();

		// }
		// else
		// System.out.println("Erreur");

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
		Scanner sc = new Scanner(System.in);
		while (choix < 1) {
			System.out.println("Veuillez choisir le nombre de joueurs : ");
			choix = sc.nextInt();
			for (int i = 0; i < choix; i++) {
				int j = 0;
				while (j != 1 && j != 2) {
					System.out.println("Veuillez choisir le type du joueur "
							+ i + " : 1 - JoueurReel  2- JoueurVirtuel");
					j = sc.nextInt();
					if (j == 1) {
						System.out.println("Veuillez choisir le nom du joueur "
								+ i + " :");
						String nom = sc.next();
						ajouterJoueur(new JoueurReel(nom));
					} else if (j == 2) {
						int k = 0;
						while (k != 1 && k != 2 && k != 3) {
							System.out
									.println("Veuillez choisir le type du joueur virtuel : 1- Aggressif  2- Imprevisible  3- Normal");
							k = sc.nextInt();
							if (k == 1)
								ajouterJoueur(new JoueurVirtuel(new Aggressif()));
							else if (k == 2)
								ajouterJoueur(new JoueurVirtuel(
										new Imprevisible()));
							else if (k == 3)
								ajouterJoueur(new JoueurVirtuel(new Avance()));
						}
					}

				}
			}
		}
		int s = 0;
		while (s != 1 && s != 2) {
			System.out.println("le score gagnant est " + getScoreGagnant()
					+ " points, Voulez vous le changer ? : 1- Oui  2- Non");
			s = sc.nextInt();
			if (s == 1) {
				int sf = -1;
				while (sf < 0) {
					System.out
							.println("D�finissez le nouveau score gagnant  : ");
					sf = sc.nextInt();
				}
				setScoreGagnant(sf);

			} else if (s == 2)
				continue;
		}
	}

	public void demarerPartie() {
		this.affichageDebutPartie();
		this.parametrePartie();
		this.partieEstFinie();
		int i = 1;
		while (!partieEstFinie) {
			if (VerificationParametrePartie()) {
				System.out.println("D�but de la Manche " + i + " :");
				manche.commencerPartie();
				this.partieEstFinie();
				i++;
			} else {
				System.out
						.println("Les param�tres de la partie ne sont pas valides");
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
						+ " a gagn� la partie ");

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
