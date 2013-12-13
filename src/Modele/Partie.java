package Modele;

public class Partie {
	private Manche manche;
	private boolean partieEstFinie=false;
	
	public Partie(Manche m){
		manche= m;
	}
	
	public void ajouterJoueur(Joueur j)
	{
		manche.ajouterJoueur(j);
	}
	public void demarerPartie()
	{
		this.partieEstFinie();
		while(!partieEstFinie)
		{
			if(parametrePartie())
			{
				manche.commencerPartie();this.partieEstFinie();}
			else
			{
				System.out.println("Les paramètres de la partie ne sont pas valides");
				this.setPartieEstFinie(true);
			}
		}
	}
	
	public Manche getManche() {
		return manche;
	}

	public void setManche(Manche manche) {
		this.manche = manche;
	}

	public boolean parametrePartie()
	{
		 return manche.joueurs.size() >= 2 && manche.joueurs.size() <=7 ? true : false;
		
	}
	public void partieEstFinie()
	{
		if (!this.partieEstFinie) {
				if (this.manche.getScoreTotal() >=500) {
					this.partieEstFinie = true;
					System.out.println(this.manche.getJoueurGagnant().getNom()+ " a gagné la partie ");
				
				}
			}
		}
	
	public boolean isPartieEstFinie() {
		return partieEstFinie;
	}

	public void setPartieEstFinie(boolean partieEstFinie) {
		this.partieEstFinie = partieEstFinie;
	}
	
	
}
