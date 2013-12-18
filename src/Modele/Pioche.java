package Modele;

import java.util.ArrayList;
import java.util.Collections;


public class Pioche extends TasCartes {

	public Pioche(){
		super();
	}
	
	public void melangerCarte(){
		Collections.shuffle(super.listeCarte);
	}
	
	public void refairePioche(Talon t) {
		Carte derniereCarteTalon = t.retirerDerniereCarte();
		t.viderDans(this);
		Collections.shuffle(this.listeCarte);
		t.ajouterCarte(derniereCarteTalon);
		}
	
	public ArrayList<Carte> retirerDeuxDernieresCartes(Talon t)
	{
		if (this.listeCarte.size()< 4){
			this.refairePioche(t);
			return null;
		}
		ArrayList<Carte> liste = new ArrayList<Carte>();
		for(int i=0;i<2;i++)
		{
			liste.add(0, this.listeCarte.get(0));
			this.listeCarte.remove(0);
		}
		
		return liste;
		
	}
	
	public ArrayList<Carte> retirerQuatreDernieresCartes(Talon t)
	{
		if (this.listeCarte.size()< 6)
			return null;
		ArrayList<Carte> liste = new ArrayList<Carte>();
		for(int i=0;i<4;i++)
		{
			liste.add(0, this.listeCarte.get(0));
			this.listeCarte.remove(0);
		}
		
		return liste;
		
	}
}
