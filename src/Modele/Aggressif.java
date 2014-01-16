package Modele;

/**
 * Cette classe définie le comportement du joueur virtuel Aggressif
 * @author Youssef, Ananias
 *
 */
public class Aggressif implements Strategy{


	public int choisirCouleur(Talon t,Joueur j, Joueur j2) {
		return (int)(Math.random() * (3-0));
	}
	
	public int choisirCarte(Talon t,Joueur j, Joueur j2) {
		return this.skyzo(t, j, j2);	
	}
	
	
	public int choisirAction(Talon t,Joueur j, Joueur j2) {
		for (int i=0; i<j.main.size();i++)
		{
			if (t.getDerniereCarte().comparerCarte(j.main.get(i)))
				return 0;
		}
		return 1;	
	}

	public boolean douter() {
		return  ((int)(Math.random() * (8-0))) > 4 ? true : false;
	}
	
	
	/**
	 * Verfier si le joueur à une carte plus quatre
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est présente sinon -1
	 */
	public int jouerCarte4(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CartePlusQuatre))
					return i;
		}
		return -1;
	}
	
	
	/**
	 * Verfier si le joueur à une carte plus deux
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est présente sinon -1
	 */
	public int jouerCarte2(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CartePlusDeux) && t.getDerniereCarte().comparerCarte((j.main.get(i))))
					return i;
		}
		return -1;
	}
	
	/**
	 * Verfier si le joueur à une carte stop
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est présente sinon -1
	 */
	public int jouerCarteStop(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CarteStop) && t.getDerniereCarte().comparerCarte((j.main.get(i))))
					return i;
		}
		return -1;
	}
	
	
	/**
	 * Verfier si le joueur à une carte Inverser
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est présente sinon -1
	 */
	public int jouerCarteInverser(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CarteInverser) && t.getDerniereCarte().comparerCarte((j.main.get(i))))
					return i;
		}
		return -1;
	}
	
	
	/**
	 * Verfier si le joueur à une carte Joker
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est présente sinon -1
	 */
	public int jouerCarteJoker(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CarteJoker) )
					return i;
		}
		return -1;
	}
	
	
	/**
	 * Verfier si le joueur à une carte normale
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est présente sinon -1
	 */
	public int jouerCarteStandard(Talon t,Joueur j)
	{
		for (int i=0; i<j.main.size();i++)
		{
			if ((j.main.get(i) instanceof CarteStandard) && t.getDerniereCarte().comparerCarte((j.main.get(i))))
					return i;
		}
		return -1;
	}
	
	
	/**
	 * liste des priorité pour jouer aggressivement
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @param j2
	 * 		Joueur Suivant
	 * @return
	 * 		l'indice de la carte à jouer
	 */
	public int skyzo(Talon t,Joueur j,Joueur j2)
	{
		if(this.jouerCarte4(t, j) != -1)
			return this.jouerCarte4(t, j);
		
		else if(this.jouerCarte2(t, j) != -1)
			return this.jouerCarte2(t, j);
		
		else if(this.jouerCarteStop(t, j) != -1)
			return this.jouerCarteStop(t, j);
		
		else if(this.jouerCarteJoker(t, j) != -1)
			return this.jouerCarteJoker(t, j);
		
		else if (this.jouerCarteInverser(t, j) != -1)
			return this.jouerCarteInverser(t, j);
		
		else if(this.jouerCarteStandard(t, j) != -1)
			return this.jouerCarteStandard(t, j);
		
		
		return 0;
	}
}
