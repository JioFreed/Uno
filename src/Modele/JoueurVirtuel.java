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
	public int choisirCouleur(Talon t, Joueur j, Joueur j2) {
		return strategy.choisirCouleur(t, j,j2);
	}

	@Override
	public int choisirCarte(Talon t, Joueur j, Joueur j2) {
		// TODO Auto-generated method stub
		return strategy.choisirCarte(t, j,j2);
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public int choisirAction(Talon t, Joueur j, Joueur j2) {
		// TODO Auto-generated method stub
		return strategy.choisirAction(t, j,j2);
	}

	@Override
	public boolean douter() {
		// TODO Auto-generated method stub
		return strategy.douter();
		
	}
	
}
