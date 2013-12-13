package Vue;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Joueur;

/**
 * Panel principal de la FenetrePrincipale. Gère le positionnement de tous les panels internes.
 * 
 * @author Yann, Youssef
 *
 */
public class PanneauPartie extends JPanel
{
	private GridBagConstraints contraintes;
	
	public PanneauPartie (Controleur controleur)
	{
		super();

		ArrayList<Joueur> joueurs = controleur.getJoueurs();
		boolean interface2Joueurs = false;
		if (joueurs.size() == 2)
			interface2Joueurs = true;
		
		this.setLayout(new GridBagLayout ());
		this.contraintes = new GridBagConstraints ();
		
		PanneauInformationsGenerales panneauGeneral = new PanneauInformationsGenerales(joueurs);
		this.setContraintes(0, 0, 3, 1);
		this.add(panneauGeneral, this.contraintes);
		
		if (interface2Joueurs)
		{
			this.setContraintes(0, 1, 1, 1);
			this.add(Box.createRigidArea(new Dimension(200,80)), this.contraintes);
		}
		
		PanneauPioche panneauPioche = new PanneauPioche(controleur.getPioche());
		if (!interface2Joueurs)
			this.setContraintes(1, 3, 1, 1, GridBagConstraints.SOUTH);
		else
			this.setContraintes(1, 2, 1, 1, GridBagConstraints.SOUTH);
		this.add(panneauPioche, this.contraintes);
		
		PanneauDefausse panneauDefausse = new PanneauDefausse(controleur.getDefausse());
		if (!interface2Joueurs)
			this.setContraintes(1, 4, 1, 1, GridBagConstraints.NORTH);
		else
			this.setContraintes(1, 3, 1, 1, GridBagConstraints.NORTH);
		this.add(panneauDefausse, this.contraintes);
		
		// On détermine la hauteur des panneaux des joueurs, selon le nombre de joueurs dans la partie
		for (int i = 0; i < joueurs.length; i++)
		{
			if (i == 0)
				this.setContraintes(0, 2, 1, 2);
			else if (i == 1)
				this.setContraintes(2, 2, 1, 2);
			else if (i == 3)
				this.setContraintes(0, 4, 1, 2);
			else
				this.setContraintes(2, 4, 1, 2);
			this.add(new PanneauJoueur (joueurs[i]), this.contraintes);
			this.add(Box.createHorizontalGlue());
			this.add(Box.createVerticalGlue());
		}
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
}
