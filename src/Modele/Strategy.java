package Modele;

/**
 * Interface strategy pour les diff�rentes strat�gie du joueur vitruel
 * @author Youssef, Ananias
 *
 */
public interface Strategy {
	
	/**
	 * M�thode permettant de v�rifier la carte jou�e par le joueur pr�c�dent
	 * @return si le joueur choisi de douter ou pas
	 */
	public boolean douter();
	
	/**
	 * Choisir la couleur du jeu
	 * @param t
	 * 		Le Talon de la manche
	 * @param j
	 * 		Le joueur courant
	 * @param j2
	 * 		le joueur suivant ou effect� par la carte jou�e
	 * @return
	 * 		Entier pour choisir la couleur du jeu
	 * 		
	 * 			1- Rouge
	 * 			2- Bleu
	 * 			3- Vert
	 * 			4- Jaune
	 */
	public int choisirCouleur(Talon t ,Joueur j, Joueur j2);
	
	/**
	 * Choisir la carte � jouer par le joueur
	 * @param t
	 * 		Le Talon de la manche
	 * @param j
	 * 		Le joueur courant
	 * @param j2
	 * 		le joueur suivant ou effect� par la carte jou�e
	 * @return
	 * 		Entier pour choisir la couleur du jeu
	 * @return
	 * 	
	 * 		l'indice de la carte � jouer
	 */
	public int choisirCarte(Talon t,Joueur j, Joueur j2);
	
	/**
	 * 
	 * Choisir l'action � effectuer par le joueur
	 * 
	 * 
	 * @param t
	 * 		Le Talon de la manche
	 * @param j
	 * 		Le joueur courant
	 * @param j2
	 * 		le joueur suivant ou effect� par la carte jou�e
	 * @return
	 * 		Entier pour choisir la couleur du jeu
	 * @return
	 * 		1- Piocher une carte
	 * 		2- Jouer
	 */
	
	public int choisirAction(Talon t,Joueur j, Joueur j2);

	
}
