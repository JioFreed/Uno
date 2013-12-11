package Modele;

public class Aggressif implements Strategy{

	@Override
	public void passerSonTour(Talon t) {
	}

	@Override
	public int choisirCouleur(Talon t,Joueur j) {
		
		return 0;
	}

	@Override
	public int choisirCarte(Talon t,Joueur j) {
		for (int i=0; i<j.main.size();i++)
		{
			if (t.getDerniereCarte().comparerCarte(j.main.get(i)))
				if (!(j.main.get(i) instanceof CarteStandard ))
					return i;
				else
					return i;
		}
		return 0;	
	}

	@Override
	public int choisirAction(Talon t,Joueur j) {
		for (int i=0; i<j.main.size();i++)
		{
			if (t.getDerniereCarte().comparerCarte(j.main.get(i)))
				return 0;
		}
		return 1;	
	}

}
