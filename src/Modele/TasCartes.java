package Modele;

import java.util.ArrayList;

import Modele.Carte;
import Modele.TasCartes;


public class TasCartes{
	
	protected ArrayList<Carte> listeCarte;
	

	public TasCartes() {
		this.listeCarte = new ArrayList <Carte> ();
	}

	public ArrayList<Carte> getListeCarte() {
		return listeCarte;
	}
	
	public Carte getDerniereCarte()
	{
		return listeCarte.get(0);
	}

	public void setListeCarte(ArrayList<Carte> listeCarte) {
		this.listeCarte = listeCarte;
	}
	
	public void ajouterCarte(Carte c){
		this.listeCarte.add(0, c);
	}
	
	public Carte retirerDerniereCarte () 
	{
		if (this.listeCarte.isEmpty())
			return null;
		
		Carte derniereCarte = this.listeCarte.get(0);
		this.listeCarte.remove(0);
		return derniereCarte;
	}
	
	public ArrayList<Carte> retirerDeuxDernieresCartes()
	{
		if (this.listeCarte.isEmpty())
			return null;
		ArrayList<Carte> liste = new ArrayList<Carte>();
		for(int i=0;i<2;i++)
		{
			liste.add(0, this.listeCarte.get(0));
			this.listeCarte.remove(0);
		}
		
		return liste;
		
	}
	
	public ArrayList<Carte> retirerQuatreDernieresCartes()
	{
		if (this.listeCarte.isEmpty())
			return null;
		ArrayList<Carte> liste = new ArrayList<Carte>();
		for(int i=0;i<4;i++)
		{
			liste.add(0, this.listeCarte.get(0));
			this.listeCarte.remove(0);
		}
		
		return liste;
		
	}
	public void viderDans (TasCartes tasARemplir)
	{
		while (!this.listeCarte.isEmpty())
			tasARemplir.ajouterCarte(this.retirerDerniereCarte());
	}
	
	
	
}
