package Modele;


public class Normal implements Strategy {

	@Override
	public void passerSonTour(Talon t)
	{
	}
	public int choisirCouleur(Talon t, Joueur j)
	{
		return (int)(Math.random() * (3-0));
	}
	
	public int choisirCarte(Talon t, Joueur j)
	{
		if(this.jouerCarteStandard(t, j) != -1)
			return this.jouerCarteStandard(t, j);
		
		else if(this.jouerCarteJoker(t, j) != -1)
			return this.jouerCarteJoker(t, j);
		
		else if (this.jouerCarteInverser(t, j) != -1)
			return this.jouerCarteInverser(t, j);
		
		else if(this.jouerCarteStop(t, j) != -1)
			return this.jouerCarteStop(t, j);
		
		else if(this.jouerCarte2(t, j) != -1)
			return this.jouerCarte2(t, j);
		
		if(this.jouerCarte4(t, j) != -1)
			return this.jouerCarte4(t, j);
	
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
	@Override
	public boolean douter() {
		// TODO Auto-generated method stub
		return true;
	}
	public int jouerCarte4(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CartePlusQuatre))
					return i;
		}
		return -1;
	}
	
	public int jouerCarte2(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CartePlusDeux) && t.getDerniereCarte().comparerCarte((j.main.get(i))))
					return i;
		}
		return -1;
	}
	
	public int jouerCarteStop(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CarteStop) && t.getDerniereCarte().comparerCarte((j.main.get(i))))
					return i;
		}
		return -1;
	}
	
	public int jouerCarteInverser(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CarteInverser) && t.getDerniereCarte().comparerCarte((j.main.get(i))))
					return i;
		}
		return -1;
	}
	
	public int jouerCarteJoker(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CarteJoker) )
					return i;
		}
		return -1;
	}
	
	public int jouerCarteStandard(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CarteStandard) && t.getDerniereCarte().comparerCarte((j.main.get(i))))
					return i;
		}
		return -1;
	}

}
