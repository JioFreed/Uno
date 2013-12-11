package Modele;

public class TestUno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Joueur j = new JoueurVirtuel("Youssef",new Aggressif());
		Joueur j1 = new JoueurVirtuel("Ayoub",new Normal());
		Joueur j2 = new JoueurVirtuel("Hamza",new Aggressif());
		//Joueur j3 = new Joueur("Ilyass");
		Partie p = new Partie();
		p.ajouterJoueur(j);
		p.ajouterJoueur(j1);
		p.ajouterJoueur(j2);
		//p.ajouterJoueur(j3);
		p.commencerPartie();
		//p.mancheSuivante();
		//System.out.println(j1.getMain());
		//System.out.println(j.getMain());

	}
	

}
