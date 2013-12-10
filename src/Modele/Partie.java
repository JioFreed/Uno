package Modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


import Modele.Carte;
import Modele.Talon;
import Modele.Joueur;
import Modele.Pioche;
import Modele.TasCartes;

public class Partie {
	final static Color[] COULEURS = { Color.RED, Color.MAGENTA, Color.BLUE,
			Color.GREEN };

	private ArrayList<Joueur> listeJoueurs;
	private Joueur joueurCourant;
	private Joueur joueurSuivant;
	private TasCartes Tas;
	private Carte carteCourante;
	private ArrayList<Joueur> joueurs;
	private Talon talon = new Talon();
	public Pioche pioche = new Pioche();
	private boolean partieEstFinie = false;
	private boolean refairePioche = false;
	private boolean uno=false;

	public void remplirPioche() {

		ArrayList<Carte> carte = new ArrayList<Carte>();
		for (int i = 0; i < 10; i++) {
			carte.add(new CarteStandard(Donnees.BLUE, i));
			carte.add(new CarteStandard(Donnees.BLUE, i));
			carte.add(new CarteStandard(Donnees.RED, i));

			carte.add(new CarteStandard(Donnees.RED, i));
			carte.add(new CarteStandard(Donnees.GREEN, i));
			carte.add(new CarteStandard(Donnees.GREEN, i));
			carte.add(new CarteStandard(Donnees.YELLOW, i));
			carte.add(new CarteStandard(Donnees.YELLOW, i));

		}

		
		  for (int i = 0; i < 2; i++) {
			  carte.add(new CarteStop(Donnees.BLUE));
			  carte.add(new CarteStop(Donnees.RED));
			  carte.add(new CarteStop(Donnees.GREEN)); 
			  carte.add(new CarteStop(Donnees.YELLOW));
			  carte.add(new CartePlusDeux(Donnees.BLUE)); 
			  carte.add(new	CartePlusDeux(Donnees.RED));
			  carte.add(new CartePlusDeux(Donnees.GREEN));
			  carte.add(new CartePlusDeux(Donnees.YELLOW));
		 }
		 

		for (int i = 0; i < 4; i++) {
			carte.add(new CarteJoker(Donnees.BLACK));
			carte.add(new CartePlusQuatre(Donnees.BLACK));
		}

		
		  for (int i = 0; i < 2; i++) { carte.add(new
		  CarteInverser(Donnees.BLUE)); carte.add(new
		  CarteInverser(Donnees.RED));  carte.add(new
		 CarteInverser(Donnees.GREEN)); carte.add(new
		  CarteInverser(Donnees.YELLOW));
		 
		 }
		 

		for (int i = 0; i < carte.size(); i++) {
			this.pioche.ajouterCarte(carte.get(i));
		}
		System.out.println(this.pioche.getListeCarte());
	}

	public void ajouterJoueur(Joueur j) {
		this.joueurs.add(j);
	}

	public void refairePioche() {

		if (this.pioche.getListeCarte().size() < 6) {
			Carte derniereCarteTalon = this.talon.retirerDerniereCarte();
			this.talon.viderDans(this.pioche);
			Collections.shuffle(this.pioche.listeCarte);
			this.talon.ajouterCarte(derniereCarteTalon);
		}

	}

	public void distribuerCartes() {
		this.remplirPioche();
		this.pioche.melangerCarte();

		for (int i = 0; i < 7; i++) {
			for (Joueur joueurCourant : this.joueurs) {
				joueurCourant.ajouterCarte(this.pioche.retirerDerniereCarte());
			}
		}
		for (Joueur joueurCourant : this.joueurs) {
			System.out.println("le joueur " + joueurCourant.getNom()
					+ " a les cartes suivantes " + joueurCourant.getMain());
		}
		this.talon.ajouterCarte(this.pioche.retirerDerniereCarte());
		System.out.println("le Talon est :  " + this.talon.getListeCarte());
	}

	public void ordonnerJoueur(int choix) {
		for (int i = choix + 1; i < this.joueurs.size(); i++)
			listeJoueurs.add(this.joueurs.get(i));
		for (int i = 0; i < choix + 1; i++)
			listeJoueurs.add(this.joueurs.get(i));
		this.joueurs = this.listeJoueurs;
	}

	public int choixDistributeur() {
		this.remplirPioche();
		this.pioche.melangerCarte();
		int max = 0;
		int indice = 0;
		String top = "";
		for (int i = 0; i < this.joueurs.size(); i++) {
			this.joueurCourant = this.joueurs.get(i);
			this.joueurCourant.ajouterCarte(this.pioche.retirerDerniereCarte());
			System.out.println("le joueur " + this.joueurCourant.getNom()
					+ " a la carte " + this.joueurCourant.getMain());
			if (this.joueurCourant.getDerniereCarte() instanceof CartePlusDeux
					|| this.joueurCourant.getDerniereCarte() instanceof CarteJoker
					|| this.joueurCourant.getDerniereCarte() instanceof CarteInverser
					|| this.joueurCourant.getDerniereCarte() instanceof CarteStop
					|| this.joueurCourant.getDerniereCarte() instanceof CartePlusQuatre)
				this.joueurCourant.getDerniereCarte().setValeur(0);
			if (this.joueurCourant.getDerniereCarte().getValeur() > max) {
				max = this.joueurCourant.getDerniereCarte().getValeur();
				top = this.joueurCourant.getNom();
				indice = i;

			}

		}
		for (int i = 0; i < this.joueurs.size(); i++)
			this.joueurs.get(i).retirerCarteMain(0);
		System.out.println("la plus grosse carte est " + max
				+ " elle appartient a " + top + " l'indice est : " + indice);
		this.pioche.listeCarte.clear();
		return indice;
	}

	public void commencerPartie() {
		this.ordonnerJoueur(this.choixDistributeur());
		this.distribuerCartes();
		this.joueurCourant = this.joueurs.get(0);
		this.joueurSuivant = this.joueurCourant;
		if (!(this.talon.getDerniereCarte() instanceof CarteInverser)) 
			this.talon.getDerniereCarte().effetCarte(this.joueurCourant, this.joueurCourant, this.pioche, this.joueurs,this.talon);
		else{
			Collections.reverse(this.joueurs);
			this.joueurSuivant = this.joueurs.get(0);
		}
		System.out.println(this.pioche.listeCarte.size());
		this.mancheSuivante();

	}

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

	public void mancheSuivante() {
		this.partieEstFinie();
		while (!this.partieEstFinie) {
			this.getRefairePioche();
			if (refairePioche)
				this.refairePioche();
			this.joueurCourant=this.joueurSuivant;
			if (this.joueurSuivant.isPeutJouer())
				this.joueurCourant=this.joueurSuivant;
			else
			{		
				this.joueurCourant.setPeutJouer(true);
				this.joueurCourant=this.choixJoueur();
			}
			System.out.println("le talon : " + this.talon.getDerniereCarte());
			System.out.println(this.joueurCourant.getNom()
					+ " a les cartes suivantes : "
					+ this.joueurCourant.getMain());

			int choix = this.joueurCourant.choisirAction(this.talon);
			if (choix == 1)
			{
				Carte cartePiochee = this.pioche.retirerDerniereCarte();
				this.joueurCourant.ajouterCarte(cartePiochee);
				if(this.talon.getDerniereCarte().comparerCarte(cartePiochee))
				{
					System.out.println(this.joueurCourant.getNom() + " a les cartes suivantes : " +this.joueurCourant.getMain());
					this.joueurCourant.choisirAction(this.talon);
				}
			}
			else if (choix == 2)
				this.joueurCourant.passerSonTour(this.talon);

			else if (choix == 0) {
				int str = this.joueurCourant.choisirCarte(this.talon);
				this.carteCourante = this.joueurCourant.getCarteChoisie(str);

				while (!this.talon.getDerniereCarte().comparerCarte(
						this.carteCourante)) {
					int str1 = this.joueurCourant.choisirCarte(this.talon);
					this.carteCourante = this.joueurCourant
							.getCarteChoisie(str1);
					str = str1;
				}
				this.carteCourante = this.joueurCourant.getCarteChoisie(str);
				this.jouerCarte(this.carteCourante);
			}
			this.choixJoueur();
			this.mancheSuivante();
		}

	}

	public void getRefairePioche() {
		if (this.pioche.listeCarte.size() < 6)
			refairePioche = true;
	}

	public void jouerCarte(Carte c) {
		this.joueurCourant.retirerCarteMain(c);
		this.talon.ajouterCarte(c);
		if (this.joueurCourant.getMain().size() == 1)
			this.setUno();
		c.effetCarte(this.joueurCourant,this.choixJoueur(), this.pioche, this.joueurs,this.talon);
		

		
	}

	public void partieEstFinie() {
		if (!this.partieEstFinie) {
			for (Joueur joueurCourant : this.joueurs) {
				if (joueurCourant.getMain().isEmpty()) {
					this.partieEstFinie = true;
					System.out.println(joueurCourant.getNom()
							+ " a gagné la partie ");

				}
			}

		}
	}

	public Joueur getJoueurGagant() {
		if (this.partieEstFinie) {
			for (Joueur joueurCourant : this.joueurs) {
				if (joueurCourant.getMain().isEmpty()) {
					System.out.println(joueurCourant.getNom()
							+ " a gagné la partie ");
					return joueurCourant;
				}
			}

		}
		return null;
	}

	public Partie() {
		this.joueurs = new ArrayList<Joueur>();
		this.listeJoueurs = new ArrayList<Joueur>();

	}

	public void setUno()
	{
		System.out.println(this.joueurCourant.getNom() + " UNO !!!! ");
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

	public void setTalon(Talon defausse) {
		this.talon = defausse;
	}

	public Pioche getPioche() {
		return pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	public boolean isPartieEstFinie() {
		return partieEstFinie;
	}

	public void setPartieEstFinie(boolean partieEstFinie) {
		this.partieEstFinie = partieEstFinie;
	}

}
