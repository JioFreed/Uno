package Vue;

import java.util.ArrayList;

/**
 * Gestionnaire de la main d'un joueur
 * 
 * @author Youssef,Ananias
 *
 */
public class GestionnaireMain 
{
	/**
	 * Liste de Labels contenants les cartes de la main
	 */
	private ArrayList<LabelCarte> labelsCartes;
	
	/**
	 * Crée une nouvelle liste de label vide
	 */
	public GestionnaireMain ()
	{
		this.labelsCartes = new ArrayList<LabelCarte> ();
	}
	
	/**
	 * Ajout d'un label carte a la liste
	 * @param label
	 */
	public void ajouterLabel (LabelCarte label)
	{
		this.labelsCartes.add(label);
	}
	
	/**
	 * Mettre le focus sur la carte selectionée
	 * @param labelFocus
	 * @param fenetre
	 * 			Fenetre de la partie
	 */
	public void mettreFocus (LabelCarte labelFocus, FenetreJeu fenetre)
	{
		for (LabelCarte labelCourant : this.labelsCartes)
			{
				if (labelCourant == labelFocus)
					labelCourant.mettreFocus();
				else
					labelCourant.enleverFocus();
			}
			fenetre.setCarteActuelle(labelFocus.getCarte());
	}
}
