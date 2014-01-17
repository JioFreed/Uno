package Modele;

/**
 * Class représentant le joueur Virtuel
 * @author Pret
 *
 */
public class JoueurVirtuel extends Joueur {
	
	/**
	 * Liste des noms
	 */
	private String[] name= new String [] {"Naruto", "Luffy", "Ichigo","Obama","Krytos",
			"DrWho","Messi","Barney","Batman","Arrow","Spielberg","Hawking","Zeus"};
	
	/**
	 * Stratégie du joueur virtuel
	 */
	private Strategy strategy;
	
	/**
	 * Constructeur du joueur virtuel
	 * @param strategy
	 * 		Stratégie choisie:
	 * 			Aggressif,
	 * 			Avance
	 * 			Imprevisible
	 */
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
		return strategy.douter();
		
	}
	
}
