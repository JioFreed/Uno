package Modele;


public class Talon extends TasCartes {
	public Talon() {
		super();
	}

	public void viderDans (TasCartes tasARemplir)
	{
		while (!this.listeCarte.isEmpty())
			tasARemplir.ajouterCarte(this.retirerDerniereCarte());
	}
	
	public Carte getDerniereCarte()
	{
		return listeCarte.get(0);
	}
}
