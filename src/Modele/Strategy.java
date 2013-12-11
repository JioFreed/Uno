package Modele;

public interface Strategy {
	
	public void passerSonTour(Talon t);
	public int choisirCouleur(Talon t ,Joueur j);
	
	public int choisirCarte(Talon t,Joueur j);
	
	public int choisirAction(Talon t,Joueur j);

}
