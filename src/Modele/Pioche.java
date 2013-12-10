package Modele;

import java.util.Collections;

import Modele.Carte;

public class Pioche extends TasCartes {

	public Pioche(){
		super();
	}
	
	public void melangerCarte(){
		Collections.shuffle(super.listeCarte);
	}
}
