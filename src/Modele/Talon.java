package Modele;

import java.util.Observer;


public class Talon extends TasCartes {
	public Talon() {
		super();
	}

	public void viderDans (TasCartes tasARemplir)
	{
		while (!this.listeCarte.isEmpty())
			tasARemplir.ajouterCarte(this.retirerDerniereCarte());
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
