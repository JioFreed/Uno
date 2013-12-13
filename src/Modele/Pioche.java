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
}
