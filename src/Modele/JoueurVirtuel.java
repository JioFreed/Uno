package Modele;





public class JoueurVirtuel extends Joueur {
	
	private String[] name= new String [] {"Naruto", "Luffy", "Ichigo", "Captain America","Obama","Krytos","Wolverine",
			"Dr Who","Messi","Barney","SpiderMan","Batman","Arrow","Spielberg","Stephen Hawking","Zeus","Iron Man"};
	private Strategy strategy;
	
	public JoueurVirtuel(Strategy strategy)
	{
		super("");
		this.strategy=strategy;
		super.setNom(this.name[((int) (Math.random()*(this.name.length)))]);
	}

	public void passerSonTour(Talon t) {
		this.setPeutJouer(false);
		
	}

	@Override
	public int choisirCouleur(Talon t, Joueur j, Joueur j2) {
		return strategy.choisirCouleur(t, j,j2);
	}

	@Override
	public int choisirCarte(Talon t, Joueur j, Joueur j2) {
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
		return strategy.choisirAction(t, j,j2);
	}

	@Override
	public boolean douter() {
		System.out.println(this.getNom() + " doute et demande de voir les cartes");
		return strategy.douter();
		
	}
	
}
