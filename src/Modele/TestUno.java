package Modele;

public class TestUno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Il existe deux manières pour lancer la partie :
		 * - Vous pouvez commencer par créer une partie et appeler la méthode demarerPartie() à ce moment tout se fera en console
		 * (création des joueurs et le nombre de point gagnant)
		 * -Vous pouvez aussi commencer pas créer les joueurs et les ajouter dans la partie avec la méthode ajouterJoueur() et 
		 * par la suite appeler la méthode demarerPartie()
		 */
		
		
		/*Joueur j = new JoueurVirtuel("Youssef",new Imprevisible());
		Joueur j1 = new JoueurVirtuel("Ayoub",new Avance());
		Joueur j2 = new JoueurVirtuel("Hamza",new Avance());	
		Joueur j3 = new JoueurVirtuel("Ilyass",new Aggressif());*/
		Partie p = new Partie();
		/*p.ajouterJoueur(j);
		p.ajouterJoueur(j1);
		p.ajouterJoueur(j2);
		p.ajouterJoueur(j3);*/
		p.demarerPartie();

	}
	

}
