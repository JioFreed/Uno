package Modele;


public class Normal implements Strategy {

	@Override
	public void passerSonTour(Talon t)
	{
	}
	public int choisirCouleur(Talon t, Joueur j)
	{
		return 0;
	}
	
	public int choisirCarte(Talon t, Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if (t.getDerniereCarte().comparerCarte(j.main.get(i)))
				return i;
		}
		return 0;			
	}
	
	public int choisirAction(Talon t, Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if (t.getDerniereCarte().comparerCarte(j.main.get(i)))
				return 0;
		}
		return 1;		
	}

}
