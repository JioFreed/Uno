package Vue;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Modele.Joueur;

/**
 * Panel contenant le nom des joueurs et leurs scores
 * 
 * @author Youssef, Ananias
 *
 */
public class PanelInformation extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Crée un panneau avec le nom des joueurs et leurs scores
	 * 
	 * @param joueurs
	 * 			Les joueurs participants à la partie
	 */
	public PanelInformation(ArrayList<Joueur>joueurs) 
	{
		super();
		
		BoxLayout layout = new BoxLayout (this, BoxLayout.LINE_AXIS);
		this.setLayout(layout);
		for (Joueur joueurCourant : joueurs)
		{
			if(!joueurCourant.isEstJoueurActuel())
				this.add(new PanelJoueurInactif(joueurCourant));
		}	
	}
}
