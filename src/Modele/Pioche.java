package Modele;

import java.util.Collections;


public class Pioche extends TasCartes {

	public Pioche(){
		super();
	}
	
	public void melangerCarte(){
		Collections.shuffle(super.listeCarte);
	}
}
