package Modele;

import java.util.Observer;

/**
 * Class repr�sentant un talon qui h�rite de la classe tas de carte
 * @author Youssef,Ananias
 *
 */

public class Talon extends TasCartes {
	public Talon() {
		super();
	}

	/**
	 * M�thode qui permet de vider le talon dans la pioche
	 * @param tas
	 * 		tas � remplir
	 */
	public void viderDans (TasCartes tas)
	{
		while (!this.listeCarte.isEmpty())
			tas.ajouterCarte(this.retirerDerniereCarte());
		super.setChanged();
	}
	
	public Carte getDerniereCarte()
	{
		return listeCarte.get(0);
	}
	
	public void ajouterCarte(Carte c){
		super.listeCarte.add(0, c);
		super.setChanged();
	}

	@Override
	public void notifierObservers() {
		for (Observer observerCourant : super.getListeObservers())
			observerCourant.update(this, null);
		
	}
}
