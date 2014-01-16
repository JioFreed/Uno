package Vue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Joueur;

/**
 * Panel principal de la fenetre principale du jeu, il gère le positionnement des panels internes
 * 
 * 
 * @author Youssef,Ananias
 * 
 */
public class PanelPrincipal extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Contraintes pour le GridBagLayout
	 */
	private GridBagConstraints contraintes;
	/**
	 * Panel du joueur Courant
	 */
	private JPanel panneauJoueur;
	/**
	 * Liste des joueurs participants
	 */
	private ArrayList<Joueur> joueurs;
	
	/**
	 * Panel de la pioche
	 */
	private JPanel panneauPioche;
	
	/**
	 * Panel du talon
	 */
	private JPanel panneauTalon;
	/**
	 * Panel couleur de la partie
	 */
	private JPanel panneauCouleur;
	/**
	 * Controleur de la partie
	 */
	private Controleur controleur;

	/**
	 * Crée et initiliase le panel principal de la FenetrePrincipale
	 * 
	 * @param controleur
	 * @throws InterruptedException
	 */
	public PanelPrincipal(Controleur controleur) {
		super();

		this.joueurs = controleur.getJoueurs();
		for (Joueur j : joueurs)
			j.ajouterObserver(this);
		this.controleur = controleur;
		this.controleur.ajouterObserver(this);

		this.setLayout(new GridBagLayout());
		this.contraintes = new GridBagConstraints();
		for (Joueur j : this.joueurs) {
			if (j.isEstJoueurActuel()) {
				this.panneauJoueur = new PanelJoueur(j);
				this.setContraintes(0, 4, 100, 1, GridBagConstraints.SOUTH);
				this.add(panneauJoueur, this.contraintes);
			}
		}
		this.toutMettreAJour();
	}

	/**
	 * Change les contraintes du GridBagLayout
	 * 
	 * @param xDebut
	 *            Indice horizontal de début
	 * @param yDebut
	 *            Indice vertical de début
	 * @param xTaille
	 *            Indice de la taille horizontale
	 * @param yTaille
	 *            Indice de la taille verticale
	 */
	public void setContraintes(int xDebut, int yDebut, int xTaille, int yTaille) {
		this.contraintes.gridx = xDebut;
		this.contraintes.gridy = yDebut;
		this.contraintes.gridwidth = xTaille;
		this.contraintes.gridheight = yTaille;
	}

	/**
	 * Change les contraintes du GridBagLayout
	 * 
	 * @param xDebut
	 *            Indice horizontal de début
	 * @param yDebut
	 *            Indice vertical de début
	 * @param xTaille
	 *            Indice de la taille horizontale
	 * @param yTaille
	 *            Indice de la taille verticale
	 * @param positionInitiale
	 *            Position initiale où le composant doit être placé
	 */
	public void setContraintes(int xDebut, int yDebut, int xTaille,
			int yTaille, int positionInitiale) {
		this.setContraintes(xDebut, yDebut, xTaille, yTaille);
		this.contraintes.anchor = positionInitiale;
	}
	
	/**
	 * Mettre à jour le panneau concernant les informations sur les joueurs : le nom et le score
	 */
	public void mettreAJourPanneauGeneral()
	{
		PanelInformation panneauGeneral = new PanelInformation(joueurs);
		this.setContraintes(6, 0, 3, 1);
		this.add(panneauGeneral, this.contraintes);	
	}
	
	/**
	 * Mettre à jour le panneau concernant la pioche
	 */
	public void mettreAJourPioche()
	{
		this.panneauPioche = new PanelPioche(this.controleur.getPioche());
		this.setContraintes(1, 3, 1, 1, GridBagConstraints.NORTH);
		this.add(panneauPioche, this.contraintes);
	}
	
	/**
	 * Mettre à jour le panneau concernant le talon
	 */
	public void mettreAJourTalon()
	{
		this.panneauTalon = new PanelTalon(this.controleur.getTalon());
		this.setContraintes(3, 3, 1, 1, GridBagConstraints.NORTH);
		this.add(panneauTalon, this.contraintes);
	}
	
	/**
	 * Mettre à jour le panneau concernant la couleur du jeu
	 */
	public void mettreAJourCouleur()
	{
		this.panneauCouleur = new PanelCouleurJeu(this.controleur.getTalon());
		this.setContraintes(6, 3, 1, 1, GridBagConstraints.NORTH);
		this.add(panneauCouleur, this.contraintes);
	}
	
	/**
	 * Mettre à jour le panneau concernant le joueur courant
	 */
	public void mettreAJourJoueur() {
		this.panneauJoueur.removeAll();
		for (Joueur j : this.joueurs) {
			if (j.isEstJoueurActuel()) {
				this.panneauJoueur = new PanelJoueur(j);
				this.setContraintes(0, 4, 100, 1, GridBagConstraints.SOUTH);
				this.add(panneauJoueur, this.contraintes);
			}
		}
		this.panneauJoueur.validate();
	}
	
	/**
	 * Mettre à jour les différents panneau qui constitue le panneauPrincipal
	 */
	public void toutMettreAJour()
	{
		this.removeAll();
		this.mettreAJourPanneauGeneral();
		this.mettreAJourPioche();
		this.mettreAJourTalon();
		this.mettreAJourCouleur();
		this.mettreAJourJoueur();
		this.validate();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.toutMettreAJour();
	}
}
