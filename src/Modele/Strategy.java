package Modele;

/**
 * Interface strategy pour les différentes stratégie du joueur vitruel
 * @author Youssef, Ananias
 *
 */
public interface Strategy {
	
	/**
	 * Méthode permettant de vérifier la carte jouée par le joueur précédent
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
	 * 		le joueur suivant ou effecté par la carte jouée
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
	 * Choisir la carte à jouer par le joueur
	 * @param t
	 * 		Le Talon de la manche
	 * @param j
	 * 		Le joueur courant
	 * @param j2
	 * 		le joueur suivant ou effecté par la carte jouée
	 * @return
	 * 		Entier pour choisir la couleur du jeu
	 * @return
	 * 	
	 * 		l'indice de la carte à jouer
	 */
	public int choisirCarte(Talon t,Joueur j, Joueur j2);
	
	/**
	 * 
	 * Choisir l'action à effectuer par le joueur
	 * 
	 * 
	 * @param t
	 * 		Le Talon de la manche
	 * @param j
	 * 		Le joueur courant
	 * @param j2
	 * 		le joueur suivant ou effecté par la carte jouée
	 * @return
	 * 		Entier pour choisir la couleur du jeu
	 * @return
	 * 		1- Piocher une carte
	 * 		2- Jouer
	 */
	
	public int choisirAction(Talon t,Joueur j, Joueur j2);

	
}
