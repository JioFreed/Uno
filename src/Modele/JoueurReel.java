package Modele;

import java.util.Scanner;

public class JoueurReel extends Joueur{
	
	public JoueurReel(String nom)
	{
		super(nom);
	}
	public void passerSonTour(Talon t)
	{
		this.setPeutJouer(false);
	}
	public int choisirCouleur(Talon t,Joueur j)
	{
		int choix = -1;
		while (choix != 0 && choix != 1 && choix != 2 && choix !=3) {
			Scanner sc = new Scanner(System.in);
			System.out.println(this.getNom()+ " Veuillez choisir une couleur : [0 - Rouge] [1 - Bleu] [2 - Jaune] [3 - Vert]");
			choix = sc.nextInt();
		}
		return choix;
	}
	
	public int choisirCarte(Talon t,Joueur j)
	{
		
		int choix = 0;
		boolean x=true;
		while (x) {
			Scanner sc = new Scanner(System.in);
			System.out.println(this.getNom()+ " Veuillez choisir une carte   : "+ this.getMain());
			choix = sc.nextInt();
			for (int i=0;i<this.getMain().size();i++)
			{
				if( choix == i)
				{
					choix = i;
					x=false;
				}
			}
		}
		return choix;		
	}
	
	public int choisirAction(Talon t,Joueur j)
	{
		int choix = -1;
		while (choix != 0 && choix != 1 && choix != 2) {
			Scanner sc = new Scanner(System.in);
			System.out.println(this.getNom()+ " Veuillez choisir une action  : [0 - Jouer] [1- Piocher] [2- Passer son tour]");
			choix = sc.nextInt();
		}
		return choix;		
	}
	

}
