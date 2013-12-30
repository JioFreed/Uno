package Vue;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Modele.Joueur;

/**
 * Panel nord contenant toutes les informations sur les joueurs
 * 
 * @author Yann, Youssef
 *
 */
public class PanneauInformation extends JPanel
{
	/**
	 * Crée le panel nord avec les informations sur les joueurs
	 * 
	 * @param joueurs
	 * 			Joueurs dont les informations doivent être affichées
	 */
	public PanneauInformation(ArrayList<Joueur>joueurs) 
	{
		super();
		
		BoxLayout layout = new BoxLayout (this, BoxLayout.LINE_AXIS);
		this.setLayout(layout);
		for (Joueur joueurCourant : joueurs)
		{
			if(!joueurCourant.isEstJoueurActuel())
				this.add(new PanneauJoueurInactif(joueurCourant));
		}	
	}
}
