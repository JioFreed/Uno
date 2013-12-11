package Modele;


public class JoueurVirtuel extends Joueur {
	private Strategy strategy;
	
	public JoueurVirtuel(String nom,Strategy strategy)
	{
		super(nom);
		this.strategy=strategy;
	}

	@Override
	public void passerSonTour(Talon t) {
		this.setPeutJouer(false);
		
	}

	@Override
	public int choisirCouleur(Talon t, Joueur j) {
		return strategy.choisirCouleur(t, j);
	}

	@Override
	public int choisirCarte(Talon t, Joueur j) {
		// TODO Auto-generated method stub
		return strategy.choisirCarte(t, j);
	}

	@Override
	public int choisirAction(Talon t, Joueur j) {
		// TODO Auto-generated method stub
		return strategy.choisirAction(t, j);
	}
	
}
