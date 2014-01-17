package Modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observer;

import Modele.Carte;

/**
 * Class pioche
 * @author Youssef, Ananias
 *
 */
public class Pioche extends TasCartes{
	private boolean piochable;
	public Pioche(){
		super();
		piochable=true;
	}
	
	/**
	 * Vérifier si la pioche est piochable
	 * @return
	 * 		boolean
	 */
	public boolean isPiochable() {
		return piochable;
	}

	public void setPiochable(boolean piochable) {
		if (this.piochable != piochable)
		{
			this.piochable = piochable;
				super.setChanged();
		}
	}

	/**
	 * Mélanger les cartes du jeu
	 */
	public void melangerCarte(){
		Collections.shuffle(super.listeCarte);
		super.setChanged();
	}
	
	/**
	 * Refaire la pioche
	 * @param t
	 * 		Talon de la partie
	 */
	public void refairePioche(Talon t) {
		Carte derniereCarteTalon = t.retirerDerniereCarte();
		t.viderDans(this);
		Collections.shuffle(this.listeCarte);
		t.ajouterCarte(derniereCarteTalon);
		}
	
	/**
	 * Retirer deux carte de la pioche,
	 * Vérifier si pioche est bien remplie
	 * @param t
	 * 		Talon de la partie
	 * @return
	 * 		Liste des cartes retirées
	 */
	public ArrayList<Carte> retirerDeuxDernieresCartes(Talon t)
	{
		if (this.listeCarte.size()< 4)
			this.refairePioche(t);
		ArrayList<Carte> liste = new ArrayList<Carte>();
		for(int i=0;i<2;i++)
		{
			liste.add(0, this.listeCarte.get(0));
			this.listeCarte.remove(0);
		}
		
		return liste;
		
	}
	
	
	/**
	 * Retirer quatres cartes de la pioche,
	 * Vérifier si pioche est bien remplie
	 * @param t
	 * 		Talon de la partie
	 * @return
	 * 		Liste des cartes retirées
	 */
	public ArrayList<Carte> retirerQuatreDernieresCartes(Talon t)
	{
		if (this.listeCarte.size()< 6)
			this.refairePioche(t);
		ArrayList<Carte> liste = new ArrayList<Carte>();
		for(int i=0;i<4;i++)
		{
			liste.add(0, this.listeCarte.get(0));
			this.listeCarte.remove(0);
		}
		
		return liste;
		
	}
	public void ajouterCarte(Carte c){
		super.listeCarte.add(0, c);
		super.setChanged();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	/* (non-Javadoc)
	 * @see Modèle.TasCartes#notifierObservers()
	 */
	public void notifierObservers ()
	{
		if (super.getListeObservers().isEmpty())
			return;
		for (Observer observerCourant : super.getListeObservers())
			observerCourant.update(this, null);
	}
}
