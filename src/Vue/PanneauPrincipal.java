package Vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Joueur;
import Modele.Talon;
import Modele.Pioche;

/**
 * Panel principal de la FenetrePrincipale. Gère le positionnement de tous les panels internes.
 * 
 * @author Yann, Youssef
 *
 */
public class PanneauPrincipal extends JPanel implements Observer
{
	/**
	 * Contraintes pour le GridBagLayout
	 */
	private GridBagConstraints contraintes;
	private JPanel panneauJoueur;
	private ArrayList<Joueur> joueurs;
	private Pioche pioche;
	private Talon talon;
	private JPanel panneauPioche;
	private JPanel panneauTalon;
	private JPanel panneauCouleur;
	/**
	 * Crée et initiliase le panel principal de la FenetrePrincipale
	 * 
	 * @param controleur
	 */
	public PanneauPrincipal (Controleur controleur)
	{
		super();

		this.joueurs = controleur.getJoueurs();
		for(Joueur j : joueurs)
			j.ajouterObserver(this);
		this.pioche=controleur.getPioche();
		this.talon=controleur.getTalon();
		
		this.setLayout(new GridBagLayout ());
		this.contraintes = new GridBagConstraints ();
		
		//PanneauInformationsGenerales panneauGeneral = new PanneauInformationsGenerales(joueurs);
		//this.setContraintes(0, 0, 3, 1);
		//this.add(panneauGeneral, this.contraintes);
		
		this.panneauPioche = new PanneauPioche(this.pioche);
		this.setContraintes(1, 3, 1, 1, GridBagConstraints.NORTH);
		this.add(panneauPioche, this.contraintes);
		
		this.panneauTalon = new PanneauTalon(this.talon);
		this.setContraintes(3, 3, 1, 1, GridBagConstraints.NORTH);
		this.add(panneauTalon, this.contraintes);
		
		this.panneauCouleur = new PanneauCouleurTalon(talon);
		this.setContraintes(6, 3, 1, 1, GridBagConstraints.NORTH);
		this.add(panneauCouleur, this.contraintes);
		
		this.panneauJoueur = new PanneauJoueur(controleur.getJoueurCourant());
		this.setContraintes(0, 4, 100, 1, GridBagConstraints.NORTH);
		this.add(panneauJoueur, this.contraintes);
		this.toutMettreAJour();
	}
	
	/**
	 * Change les contraintes du GridBagLayout
	 * 
	 * @param xDebut
	 * 			Indice horizontal de début
	 * @param yDebut
	 * 			Indice vertical de début
	 * @param xTaille
	 * 			Indice de la taille horizontale
	 * @param yTaille
	 * 			Indice de la taille verticale
	 */
	public void setContraintes (int xDebut, int yDebut, int xTaille, int yTaille)
	{
		this.contraintes.gridx = xDebut;
		this.contraintes.gridy = yDebut;
		this.contraintes.gridwidth= xTaille;
		this.contraintes.gridheight = yTaille;
	}
	
	/**
	 * Change les contraintes du GridBagLayout
	 * 
	 * @param xDebut
	 * 			Indice horizontal de début
	 * @param yDebut
	 * 			Indice vertical de début
	 * @param xTaille
	 * 			Indice de la taille horizontale
	 * @param yTaille
	 * 			Indice de la taille verticale
	 * @param positionInitiale
	 * 			Position initiale où le composant doit être placé
	 */
	public void setContraintes (int xDebut, int yDebut, int xTaille, int yTaille, int positionInitiale)
	{
		this.setContraintes(xDebut, yDebut, xTaille, yTaille);
		this.contraintes.anchor = positionInitiale;
	}

	public void mettreAjourJoueur()
	{
		this.removeAll();
		this.panneauPioche = new PanneauPioche(pioche);
		this.setContraintes(1, 3, 1, 1, GridBagConstraints.NORTH);
		this.add(panneauPioche,this.contraintes);
		this.panneauTalon = new PanneauTalon(talon);
		this.setContraintes(3, 3, 1, 1, GridBagConstraints.CENTER);
		this.add(panneauTalon,this.contraintes);
		this.panneauCouleur = new PanneauCouleurTalon(talon);
		this.setContraintes(6, 3, 1, 1, GridBagConstraints.NORTH);
		this.add(panneauCouleur, this.contraintes);
		for(Joueur j : this.joueurs)
		{
			if(j.isEstJoueurActuel())
			{
				this.panneauJoueur= new PanneauJoueur(j);
				this.setContraintes(0, 4, 100, 1, GridBagConstraints.SOUTH);
				this.add(panneauJoueur, this.contraintes);
			}
		}
		this.validate();
	}
	
	public void toutMettreAJour()
	{
		this.mettreAjourJoueur();
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		this.mettreAjourJoueur();
		
	}
}
