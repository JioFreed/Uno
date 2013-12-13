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
	
	
	
}
