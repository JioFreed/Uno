package Vue;

import java.util.ArrayList;

public class GestionnaireMain 
{
	private ArrayList<LabelCarte> labelsCartes;
	public GestionnaireMain ()
	{
		this.labelsCartes = new ArrayList<LabelCarte> ();
	}
	

	public void ajouterLabel (LabelCarte label)
	{
		this.labelsCartes.add(label);
	}
	
	public void mettreFocus (LabelCarte labelFocus, FenetreParametre fenetre)
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
