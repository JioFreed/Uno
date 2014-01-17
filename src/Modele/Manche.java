package Modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import Modele.Carte;
import Modele.Talon;
import Modele.Joueur;
import Modele.Pioche;
import Modele.TasCartes;

public class Manche extends Observable {
	
	/**
	 * le Joueur courant dans la manche
	 */
	public Joueur joueurCourant;
	/**
	 * Le joueur suivant dans la manche
	 */
	public Joueur joueurSuivant;
	/**
	 * le tas de carte
	 */
	public TasCartes Tas;
	/**
	 * La carte courante du joueur
	 */
	public Carte carteCourante;
	/**
	 * Liste des joueurs participant à la partie
	 */
	public ArrayList<Joueur> joueurs;
	/**
	 * Le talon de la partie
	 */
	private Talon talon = new Talon();
	/**
	 * La pioche de la partie
	 */
	public Pioche pioche = new Pioche();
	/**
	 * Boolean verifier si la manche est fini
	 */
	private boolean mancheEstFinie;
	/**
	 * Boolean pour refaire la manche
	 */
	private boolean refairePioche = false;
	
	/**
	 * score final de la manche
	 */
	public int score = 0;
	/**
	 * Uno
	 */
	private boolean uno = false;
	
	/**
	 * Verifier si un joueur réel est existant
	 */
	private boolean joueurReelExistant = false;
	
	/**
	 * Joueur gagnant
	 */
	private Joueur joueurGagnant;
	
	/**
	 * Liste des observers
	 */
	private ArrayList<Observer> listeObservers = new ArrayList<Observer>();

	/**
	 * Initiation de la manche
	 */
	public Manche() {
		this.carteCourante = null;
		this.joueurCourant = null;
		this.joueurSuivant = null;
		this.setMancheEstFinie(false);
	}

	/**
	 * Méthode permettant d'initialiser toutes les cartes et remplir la pioche
	 */
	public void remplirPioche() {

		ArrayList<Carte> carte = new ArrayList<Carte>();
		for (int i = 0; i < 1; i++) {
			carte.add(new CarteStandard(Carte.BLUE, i));
			carte.add(new CarteStandard(Carte.RED, i));
			carte.add(new CarteStandard(Carte.GREEN, i));
			carte.add(new CarteStandard(Carte.YELLOW, i));
		}
		for (int i = 1; i < 10; i++) {
			carte.add(new CarteStandard(Carte.BLUE, i));
			carte.add(new CarteStandard(Carte.BLUE, i));
			carte.add(new CarteStandard(Carte.RED, i));
			carte.add(new CarteStandard(Carte.RED, i));
			carte.add(new CarteStandard(Carte.GREEN, i));
			carte.add(new CarteStandard(Carte.GREEN, i));
			carte.add(new CarteStandard(Carte.YELLOW, i));
			carte.add(new CarteStandard(Carte.YELLOW, i));

		}

		for (int i = 0; i < 2; i++) {
			carte.add(new CarteStop(Carte.BLUE));
			carte.add(new CarteStop(Carte.RED));
			carte.add(new CarteStop(Carte.GREEN));
			carte.add(new CarteStop(Carte.YELLOW));
			carte.add(new CartePlusDeux(Carte.BLUE));
			carte.add(new CartePlusDeux(Carte.RED));
			carte.add(new CartePlusDeux(Carte.GREEN));
			carte.add(new CartePlusDeux(Carte.YELLOW));
			carte.add(new CarteInverser(Carte.BLUE));
			carte.add(new CarteInverser(Carte.RED));
			carte.add(new CarteInverser(Carte.GREEN));
			carte.add(new CarteInverser(Carte.YELLOW));
		}

		for (int i = 0; i < 2; i++) {
			carte.add(new CarteJoker(Carte.BLACK));
			carte.add(new CartePlusQuatre(Carte.BLACK));
		}

		for (int i = 0; i < carte.size(); i++) {
			this.pioche.ajouterCarte(carte.get(i));
		}
	}

	/**
	 * Méthode permettant d'ajouter un joueur
	 * @param j
	 */
	public void ajouterJoueur(Joueur j) {
		this.joueurs.add(j);
	}

	/**
	 * Méthode pour refaire la pioche
	 */
	public void refairePioche() {
		this.getRefairePioche();
		if (this.refairePioche) {
			Carte derniereCarteTalon = this.talon.retirerDerniereCarte();
			this.talon.viderDans(this.pioche);
			Collections.shuffle(this.pioche.listeCarte);
			this.talon.ajouterCarte(derniereCarteTalon);
		}

	}

	/**
	 * Méthode permettant de distribuer les cartes aux joueurs
	 */
	public void distribuerCartes() {
		this.remplirPioche();
		this.pioche.melangerCarte();

		for (int i = 0; i < 7; i++) {
			for (Joueur joueurCourant : this.joueurs) {
				joueurCourant.ajouterCarte(this.pioche.retirerDerniereCarte());
			}
		}
		this.talon.ajouterCarte(this.pioche.retirerDerniereCarte());
	}

	/**
	 * Méthode permettant de définir l'ordre des joueurs
	 * @param choix
	 */
	public void ordonnerJoueur(int choix) {
		ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
		;
		for (int i = choix + 1; i < this.joueurs.size(); i++)
			listeJoueurs.add(this.joueurs.get(i));
		for (int i = 0; i < choix + 1; i++)
			listeJoueurs.add(this.joueurs.get(i));
		this.joueurs = listeJoueurs;
	}

	/**
	 * Méthode permettant de définir le joueur qui va distribuer les cartes
	 * @return
	 * 		l'indice du distributeur
	 */
	public int choixDistributeur() {
		for (Joueur j : this.joueurs) {
			if (j instanceof JoueurReel)
				this.setJoueurReelExistant(true);
		}
		this.remplirPioche();
		this.pioche.melangerCarte();
		int max = 0;
		int indice = 0;
		for (int i = 0; i < this.joueurs.size(); i++) {
			this.joueurCourant = this.joueurs.get(i);
			this.joueurCourant.ajouterCarte(this.pioche.retirerDerniereCarte());
			if(this.joueurReelExistant)
			 JOptionPane.showMessageDialog(null,
			 joueurs.get(i).getNom() + " a la carte  "
			 +joueurs.get(i).getDerniereCarte().toString(), "alert",
			 JOptionPane.ERROR_MESSAGE);
			if (!(this.joueurCourant.getDerniereCarte() instanceof CarteStandard))
				this.joueurCourant.getDerniereCarte().setValeur(0);
			if (this.joueurCourant.getDerniereCarte().getValeur() > max) {
				max = this.joueurCourant.getDerniereCarte().getValeur();
				indice = i;
			}

		}
		if(this.joueurReelExistant)
		 JOptionPane.showMessageDialog(null,
		 " La plus grosse carte appartient à " + joueurs.get(indice).getNom()
		 + " c'est a lui de distribuer les cartes " , "alert",
		 JOptionPane.ERROR_MESSAGE);
		
		for (int i = 0; i < this.joueurs.size(); i++)
			this.joueurs.get(i).main.remove(0);
		this.pioche.listeCarte.clear();
		return indice;
	}

	/**
	 * 
	 * Méthode pour commencerla manche
	 */
	public void commencerManche() {
		this.ordonnerJoueur(this.choixDistributeur());
		this.distribuerCartes();
		this.setMancheEstFinie(false);
		this.joueurCourant = this.joueurs.get(0);
		this.joueurSuivant = this.joueurCourant;
		this.joueurCourant.setEstJoueurActuel(true);
		if (!(this.talon.getDerniereCarte() instanceof CarteInverser))
			this.talon.getDerniereCarte().effetCarte(this.joueurCourant,
					this.joueurCourant, this.pioche, this.joueurs, this.talon);
		else {
			this.talon.getDerniereCarte().effetCarte(this.joueurCourant,
					this.joueurCourant, this.pioche, this.joueurs, this.talon);
			this.mancheSuivante();
		}
		this.mancheSuivante();

	}

	/**
	 * Méthode pour piocher une carte
	 */
	public void piocherCarte() {
		this.joueurCourant.ajouterCarte(this.pioche.retirerDerniereCarte());
		this.joueurCourant.setAPiocher(true);
		this.pioche.setPiochable(false);
	}

	/**
	 * Définir la carte actuelle
	 * @param c
	 * 		la cate à définir
	 */
	public void setCarteActuelle(Carte c) {

		if (this.talon.getDerniereCarte().comparerCarte(c))
			this.joueurCourant.setaUneCarteJouable(true);
		else
			this.joueurCourant.setaUneCarteJouable(false);
		this.carteCourante = c;

	}

	/**
	 * Méthode permettant de choisir le prochain joueur à jouer
	 * @return
	 * 	Joueur à jouer
	 */
	public Joueur choixJoueur() {
		for (int i = 0; i < this.joueurs.size(); i++) {
			if (this.joueurs.get(i) == this.joueurCourant) {
				if (i == this.joueurs.size() - 1) {
					this.joueurSuivant = this.joueurs.get(0);
					return this.joueurSuivant;
				} else {
					this.joueurSuivant = this.joueurs.get(i + 1);
					return this.joueurSuivant;
				}
			}
		}
		return this.joueurSuivant;
	}

	/**
	 * Vérifie que la manche n'est pas finie et demande au joueur de jouer
	 */
	public void mancheSuivante() {
		this.mancheEstFinie();
		if (!this.mancheEstFinie) {
			this.getRefairePioche();
			if (refairePioche)
				this.refairePioche();
			this.pioche.setPiochable(true);
			this.joueurCourant.setAPiocher(false);
			this.joueurCourant = this.joueurSuivant;
			if (this.joueurSuivant.isPeutJouer())
				this.joueurCourant = this.joueurSuivant;
			else {
				this.joueurCourant.setPeutJouer(true);
				this.joueurCourant = this.choixJoueur();
			}
			for (Joueur joueur : joueurs)
				joueur.setEstJoueurActuel(false);
			this.joueurCourant.setEstJoueurActuel(true);
			this.choixJoueur();
			
			
			if (this.joueurCourant instanceof JoueurVirtuel) {
				int choix = this.joueurCourant.choisirAction(this.talon,
						this.joueurCourant, this.choixJoueur());
				if (choix == 1) {
					this.piocherCarte();
					this.carteCourante = this.joueurCourant.getMain().get(0);
					if (this.talon.getDerniereCarte().comparerCarte(
							this.carteCourante)) {
						this.jouerCarte();
					} else
						this.passerTour();
				} else if (choix == 0) {
					int str = this.joueurCourant.choisirCarte(this.talon,
							this.joueurCourant, this.choixJoueur());
					this.carteCourante = this.joueurCourant
							.getCarteChoisie(str);
					this.jouerCarte();
				}
			}

		}
	}

	/**
	 *  Méthode permettant de jouer
	 */
	public void jouerCarte() {
		this.joueurCourant.retirerCarteMain(this.carteCourante);
		this.talon.ajouterCarte(this.carteCourante);
		if (this.joueurCourant.getMain().size() == 1)
			this.setUno(true);
		this.carteCourante.effetCarte(this.joueurCourant, this.choixJoueur(),
				this.pioche, this.joueurs, this.talon);
		if (this.carteCourante instanceof CarteInverser)
			this.choixJoueur();
		this.mancheSuivante();
	}

	/**
	 * Vérifier si la manche est finie
	 * 
	 */
	public void mancheEstFinie() {
		if (!this.mancheEstFinie) {
			for (Joueur joueurCourant : this.joueurs) {
				if (joueurCourant.getMain().isEmpty()) {
					for (Joueur joueurCourant2 : this.joueurs) {
						for (int i = 0; i < joueurCourant2.main.size(); i++) {
							score += joueurCourant2.main.get(i).getPoint();
						}
					}
					joueurCourant.setScore(score);
					this.getScoreTotal();
					this.setJoueurGagnant(joueurCourant);
					this.setMancheEstFinie(true);
					break;

				}

			}
		}

	}
	
	/**
	 * 
	 * @param mancheEstFinie
	 */
	public void setMancheEstFinie(boolean mancheEstFinie) {
		this.mancheEstFinie = mancheEstFinie;
		if (this.mancheEstFinie) {

			for (Joueur joueurCourant : this.joueurs)
				joueurCourant.main.clear();
			this.setChanged();
		}

	}
	
	/**
	 * Récuperer le score total
	 */
	public int getScoreTotal() {
		int max = 0;
		Joueur joueur = joueurs.get(0);
		for (Joueur joueurCourant : this.joueurs) {
			if (joueurCourant.getScore() >= joueur.getScore())
				max = joueurCourant.getScore();
		}
		return max;
	}
	
	/**
	 * 
	 * @return Le joueur gagnant
	 */
	public Joueur getJoueurGagnant() {
		for (Joueur joueurCourant : this.joueurs) {
			if (joueurCourant.getScore() >= Partie.getScoreGagnant())
				return joueurCourant;
		}
		return null;
	}

	/**
	 * Définir si le joueur à une carte 
	 * @param v
	 */
	public void setUno(boolean v) {
		this.uno = v;
		if (this.uno) 
			this.setChanged();
	}
	
	public void setJoueurGagnant(Joueur j) {
		this.joueurGagnant = j;
	}

	public Joueur getJoueurGagnant2() {
		return this.joueurGagnant;
	}

	


	public boolean getUno() {
		return this.uno;
	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public void setJoueurCourant(Joueur joueurCourant) {
		this.joueurCourant = joueurCourant;
	}

	public Joueur getJoueurSuivant() {
		return joueurSuivant;
	}

	public void setJoueurSuivant(Joueur joueurSuivant) {
		this.joueurSuivant = joueurSuivant;
	}

	public TasCartes getTas() {
		return Tas;
	}

	public void setMain(TasCartes T) {
		Tas = T;
	}

	public Carte getCarteCourante() {
		return carteCourante;
	}

	public void setCarteCourante(Carte carteCourante) {
		this.carteCourante = carteCourante;
	}

	public Talon getTalon() {
		return talon;
	}

	public void setTalon(Talon talon) {
		this.talon = talon;
	}

	public Pioche getPioche() {
		return pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	public boolean isMancheEstFinie() {
		return mancheEstFinie;
	}

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public void ajouterObserver(Observer observer) {
		this.listeObservers.add(observer);
	}

	/**
	 * Méthode pour notifier les observers
	 */
	public void notifierObservers(boolean nvlePioche) {
		for (Observer observerCourant : this.listeObservers)
			observerCourant.update(this, nvlePioche);
	}

	public void setChanged() {
		this.notifierObservers(false);
	}

	public void setChangedNouvellePioche() {
		this.notifierObservers(true);
	}
	public void setJoueurReelExistant(boolean joueur) {
		this.joueurReelExistant = joueur;
		this.setChanged();
	}

	public boolean getJoueurReelExistant() {
		return this.joueurReelExistant;
	}
	public ArrayList<Observer> getListeObservers() {
		return listeObservers;
	}

	public void setListeObservers(ArrayList<Observer> listeObservers) {
		this.listeObservers = listeObservers;
	}
	public void permettreDePiocher() {
		this.pioche.setPiochable(true);
	}

	public void passerTour() {
		this.mancheSuivante();
	}

	public void getRefairePioche() {
		if (this.pioche.listeCarte.isEmpty())
			refairePioche = true;
	}
}
