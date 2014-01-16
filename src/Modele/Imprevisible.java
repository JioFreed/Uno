package Modele;


/**
 * Cette classe d�finie le comportement du joueur virtuel Imprevisible
 * @author Youssef, Ananias
 *
 */

public class Imprevisible implements Strategy {

	
	public int choisirCouleur(Talon t, Joueur j, Joueur j2)
	{
		return (int)(Math.random() * (3-0));
	}
	
	public int choisirCarte(Talon t, Joueur j, Joueur j2)
	{
		
		return ((int)(Math.random() * (8-0))) > 4 ? this.comportementNormal(t, j, j2) :  this.skyzo(t, j, j2);

	}			
	
	public int choisirAction(Talon t, Joueur j, Joueur j2)
	{
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
	 * Verfier si le joueur � une carte plus quatre
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est pr�sente sinon -1
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
	 * Verfier si le joueur � une carte plus deux
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 	
	 * 		l'indice de la carte sinon -1
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
	 * Verfier si le joueur � une cartestop
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est pr�sente sinon -1
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
	 * Verfier si le joueur � une carte inverser
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est pr�sente sinon -1
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
	 * Verfier si le joueur � une carte joker
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est pr�sente sinon -1
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
	 * Verfier si le joueur � une carte normale
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @return
	 * 		l'indice de la carte si elle est pr�sente sinon -1
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
	 * liste des priorit� pour jouer normalement
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @param j2
	 * 		Joueur Suivant
	 * @return
	 * 		l'indice de la carte � jouer
	 */
	public int comportementNormal(Talon t,Joueur j, Joueur j2)
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

	
	/**
	 * liste des priorit� pour jouer aggressivement
	 * @param t
	 * 		Talon de la partie
	 * @param j
	 * 		Joueur courant
	 * @param j2
	 * 		Joueur Suivant
	 * @return
	 * 		l'indice de la carte � jouer
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
