package Modele;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;



import Modele.Carte;
import Modele.Talon;
import Modele.Joueur;
import Modele.Pioche;
import Modele.TasCartes;

public class Manche extends Observable{
	final static Color[] COULEURS = { Color.RED, Color.YELLOW, Color.BLUE,
			Color.GREEN };

	public Joueur joueurCourant;
	public Joueur joueurSuivant;
	public TasCartes Tas;
	public Carte carteCourante;
	public ArrayList<Joueur> joueurs;
	private Talon talon = new Talon();
	public Pioche pioche = new Pioche();
	private boolean mancheEstFinie;
	private boolean refairePioche = false;
	public int score=0;
	private boolean uno =false;
	private boolean joueurReelExistant=false;
	private Joueur joueurGagnant;
	private ArrayList<Observer> listeObservers = new ArrayList<Observer>();
	
	public Manche() {
		//this.joueurs = new ArrayList<Joueur>();
		this.carteCourante=null;
		this.joueurCourant=null;
		this.joueurSuivant=null;
		this.mancheEstFinie = false;

	}
	
	public void setJoueurReelExistant(boolean joueur)
	{
		this.joueurReelExistant= joueur;
		this.setChanged();
	}
	public boolean getJoueurReelExistant()
	{
		return this.joueurReelExistant;
	}
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
			  carte.add(new	CartePlusDeux(Carte.RED));
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

	public void ajouterJoueur(Joueur j) {
		this.joueurs.add(j);
	}
	
	

	public void refairePioche() {
		this.getRefairePioche();
		if (this.refairePioche) {
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
		ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();;
		for (int i = choix + 1; i < this.joueurs.size(); i++)
			listeJoueurs.add(this.joueurs.get(i));
		for (int i = 0; i < choix + 1; i++)
			listeJoueurs.add(this.joueurs.get(i));
		this.joueurs = listeJoueurs;
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
		for(Joueur j : this.joueurs)
		{
			if(j instanceof JoueurReel)
				this.setJoueurReelExistant(true);
		}
		this.mancheEstFinie = false;
		this.joueurCourant = this.joueurs.get(0);
		this.joueurSuivant = this.joueurCourant;
		this.joueurCourant.setEstJoueurActuel(true);
		if(! (this.talon.getDerniereCarte() instanceof CarteInverser))
			this.talon.getDerniereCarte().effetCarte(this.joueurCourant, this.joueurCourant, this.pioche, this.joueurs,this.talon);
		else
		{
			this.talon.getDerniereCarte().effetCarte(this.joueurCourant, this.joueurCourant, this.pioche, this.joueurs,this.talon);
			this.mancheSuivante();
		}
		this.mancheSuivante();
		
	}
	public void piocherCarte()
	{
		this.joueurCourant.ajouterCarte(this.pioche.retirerDerniereCarte());
		this.joueurCourant.setAPiocher(true);
		this.pioche.setPiochable(false);
	}

	public ArrayList<Observer> getListeObservers() {
		return listeObservers;
	}

	public void setListeObservers(ArrayList<Observer> listeObservers) {
		this.listeObservers = listeObservers;
	}
	
	public void setCarteActuelle(Carte c)
	{
		
		if(this.talon.getDerniereCarte().comparerCarte(c))
			this.joueurCourant.setaUneCarteJouable(true);
		else
			this.joueurCourant.setaUneCarteJouable(false);
		this.carteCourante = c;	
		
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
		this.mancheEstFinie();
		if (!this.mancheEstFinie) {
			this.getRefairePioche();
			if (refairePioche)
				this.refairePioche();
			this.pioche.setPiochable(true);
			this.joueurCourant.setAPiocher(false);
			this.joueurCourant=this.joueurSuivant;
			if (this.joueurSuivant.isPeutJouer())
				this.joueurCourant=this.joueurSuivant;
			else
			{		
				this.joueurCourant.setPeutJouer(true);
				this.joueurCourant=this.choixJoueur();
			}
			for(Joueur joueur : joueurs)
				joueur.setEstJoueurActuel(false);
			this.joueurCourant.setEstJoueurActuel(true);
			
			this.choixJoueur();
			if(this.joueurCourant instanceof JoueurVirtuel)
			{
				int choix = this.joueurCourant.choisirAction(this.talon,this.joueurCourant,this.choixJoueur());
                if (choix == 1)
                {
                       	this.piocherCarte();
                       	this.carteCourante= this.joueurCourant.getMain().get(0);
                        if(this.talon.getDerniereCarte().comparerCarte(this.carteCourante))
                        {
                                System.out.println(this.joueurCourant.getNom() + " a les cartes suivantes : " +this.joueurCourant.getMain());
                                this.jouerCarte();
                        }
                        else
                        	this.passerTour();
                }
                else if (choix == 0) {
                        int str = this.joueurCourant.choisirCarte(this.talon,this.joueurCourant,this.choixJoueur());
                        this.carteCourante = this.joueurCourant.getCarteChoisie(str);

                        while (!this.talon.getDerniereCarte().comparerCarte(this.carteCourante)) {
                                int str1 = this.joueurCourant.choisirCarte(this.talon,this.joueurCourant,this.choixJoueur());
                                this.carteCourante = this.joueurCourant .getCarteChoisie(str1);
                                str = str1;
                        }
                        this.carteCourante = this.joueurCourant.getCarteChoisie(str);
                        this.jouerCarte();
                }
			}
			
		}

	}
	public void permettreDePiocher ()
	{
		this.pioche.setPiochable(true);
	}
	
	public void passerTour()
	{
		this.mancheSuivante();
	}
	public void getRefairePioche() {
		if (this.pioche.listeCarte.isEmpty())
			refairePioche = true;
	}

	public void jouerCarte(Carte c) {
		this.joueurCourant.retirerCarteMain(c);
		this.talon.ajouterCarte(c);
		if (this.joueurCourant.getMain().size() == 1)
			this.setUno();
		c.effetCarte(this.joueurCourant,this.choixJoueur(), this.pioche, this.joueurs,this.talon);
		this.mancheSuivante();
	}
	public void jouerCarte(Joueur j) {
		this.joueurCourant.retirerCarteMain(this.carteCourante);
		this.talon.ajouterCarte(this.carteCourante);
		if (this.joueurCourant.getMain().size() == 1)
			this.setUno();
		this.carteCourante.effetCarte(this.joueurCourant,this.choixJoueur(), this.pioche, this.joueurs,this.talon);
		this.mancheSuivante();
	}

	public void jouerCarte()
	{
		this.joueurCourant.retirerCarteMain(this.carteCourante);
		this.talon.ajouterCarte(this.carteCourante);
		if (this.joueurCourant.getMain().size() == 1)
			this.setUno();
		this.carteCourante.effetCarte(this.joueurCourant,this.choixJoueur(), this.pioche, this.joueurs,this.talon);
		if (this.carteCourante instanceof CarteInverser)
			this.choixJoueur();
		this.mancheSuivante();
	}
	public void mancheEstFinie() {
		if (!this.mancheEstFinie) {
			for (Joueur joueurCourant : this.joueurs) {
				if (joueurCourant.getMain().isEmpty()) {
					score=0;
					
					//this.mancheEstFinie = true;				
					for (Joueur joueurCourant2 : this.joueurs)
					{
						for(int i=0;i<joueurCourant2.main.size();i++)
						{
							score+=joueurCourant2.main.get(i).getPoint();
						}
					}
					joueurCourant.setScore(score);
					System.out.println(joueurCourant.getNom()+ " a gagné la Manche avec " + this.score);
					this.setJoueurGagnant(joueurCourant);
					this.setMancheEstFinie(true);
					break;
				
				}
				
			}
				
			}
		if(this.mancheEstFinie)
		{
			for (Joueur joueurCourant : this.joueurs) 
			{
				
				System.out.println(joueurCourant.getNom()+ " a  " + joueurCourant.getScore());
				joueurCourant.main.clear();
			}
			this.talon.listeCarte.clear();
			this.pioche.listeCarte.clear();
			this.setChanged();
		}
	}
	
	public void setJoueurGagnant(Joueur j)
	{
		this.joueurGagnant = j;
	}
	
	public Joueur getJoueurGagnant2()
	{
		return this.joueurGagnant;
	}
	public int getScoreTotal()
	{
		int max=0;
		Joueur joueur= joueurs.get(0);
		for (Joueur joueurCourant : this.joueurs) 
		{
			if( joueurCourant.getScore() >= joueur.getScore())
				max= joueurCourant.getScore();
		}
		return max;
	}

	public Joueur getJoueurGagnant() {
		for (Joueur joueurCourant : this.joueurs) 
		{
			if( joueurCourant.getScore() >= Partie.getScoreGagnant())
				return joueurCourant;
		}
		return null;
	}

	public void setUno()
	{
		this.uno=true;
		this.setChanged();
		System.out.println(this.joueurCourant.getNom() + " UNO !!!! ");
	}
	public boolean getUno()
	{
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

	public void setTalon(Talon defausse) {
		this.talon = defausse;
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

	public void setMancheEstFinie(boolean mancheEstFinie) {
		this.mancheEstFinie = mancheEstFinie;
	}
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public void ajouterObserver (Observer observer)
	{
		this.listeObservers.add(observer);
	}
	
	/**
	 * Méthode pour notifier les observers
	 */
	public void notifierObservers (boolean nvlePioche)
	{
		for (Observer observerCourant : this.listeObservers)
			observerCourant.update(this, nvlePioche);
	}
	
	public void setChanged ()
	{
		this.notifierObservers(false);
	}
	
	public void setChangedNouvellePioche ()
	{
		this.notifierObservers(true);
	}
}

