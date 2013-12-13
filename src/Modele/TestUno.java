package Modele;

public class TestUno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Joueur j = new JoueurVirtuel("Youssef",new Normal());
		Joueur j1 = new JoueurVirtuel("Ayoub",new Normal());
		Joueur j2 = new JoueurVirtuel("Hamza",new Normal());
		
		Joueur j3 = new JoueurVirtuel("Ilyass",new Normal());
		/*Joueur j4 = new JoueurVirtuel("toto",new Normal());
		Joueur j5 = new JoueurVirtuel("toto1",new Normal());
		Joueur j6 = new JoueurVirtuel("toto2",new Normal());
		Joueur j7 = new JoueurVirtuel("toto3",new Normal());
		Joueur j8 = new JoueurVirtuel("toto4",new Normal());*/
		Manche m= new Manche();
		Partie p = new Partie(m);
		p.ajouterJoueur(j);
		p.ajouterJoueur(j1);
		p.ajouterJoueur(j2);
		p.ajouterJoueur(j3);
		/*p.ajouterJoueur(j4);
		p.ajouterJoueur(j5);
		p.ajouterJoueur(j6);
		p.ajouterJoueur(j7);
		p.ajouterJoueur(j8);*/
		p.demarerPartie();
		//p.mancheSuivante();
		//System.out.println(j1.getMain());
		//System.out.println(j.getMain());

	}
	

}
