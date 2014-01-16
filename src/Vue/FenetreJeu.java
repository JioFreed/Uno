package Vue;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Controleur.Controleur;
import Modele.*;

/**
 * Fenetre principale du jeu, composée de panneauPrincipal
 * 
 * @author Youssef, Ananias
 *
 */
public class FenetreJeu extends JFrame implements Observer
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Taille minimal horizontale de la fenetre
	 */
	final static int MIN_HORIZONTAL = 1350;
	
	/**
	 * Taille minimal vertical de la fenetre
	 */
	final static int MIN_VERTICAL = 730;
	/**
	 * Constructeur
	 */
	private Controleur controleur;
	/**
	 * Panneau Principal
	 */
	private JPanel panneauPrincipal;
	
	/**
	 * Constructeur de la fenetre principale du jeu, elle fait appel via le contoleur à la méthode init()
	 * pour créer une nouvelle manche et la méthode démarerPartie() pour commencer le jeu
	 * @param controleur
	 */
	public FenetreJeu(Controleur controleur)
	{
		super("Uno ");
		this.controleur = controleur;
		this.controleur.init();
		this.controleur.ajouterObserver(this);
		this.controleur.demarerLaPartie();
		
		this.pack();
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension (MIN_HORIZONTAL,MIN_VERTICAL));
		
		this.setLayout(new BorderLayout());
		this.panneauPrincipal= new PanelPrincipal(this.controleur);
		this.add(this.panneauPrincipal, BorderLayout.SOUTH);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * 
	 * la méthode fait appel à la méthode piocherCarte via le controleur
	 */
	public void piocherCarte()
	{
		this.controleur.piocherCarte();
	}
	
	/**
	 * la méthode fait appel à la méthode jouerCarte via le controleur
	 */
	public void jouerCarte()
	{
		this.controleur.jouerCarte();
	}
	
	/**
	 * la méthode fait appel à la méthode passerTour via le controleur
	 */
	public void passerTour()
	{
		this.controleur.passerTour();
	}
	
	/**
	 * la méthode fait appel à la méthode setCarteActuelle via le controleur
	 */
	public void setCarteActuelle(Carte c)
	{
		this.controleur.setCarteActuelle(c);
	}
	
	/**
	 * La méthode update permet de mettre à jour la Fenetre du jeu en cas de changement,
	 * - Une fois la manche est finie la fonction déclare le gagnant et lance une nouvelle manche tant que la partie n'est pas finie.
	 * 
	 * - Si un joueur a une carte dans la main un message s'affiche pour déclarer que le joueur est : "Uno"
	 * 
	 * - Si la partie est finie un message s'affiche déclarant le gagant et ferme la fenetre du jeu
	 */
	public void update(Observable arg0, Object arg1) 
	{
		if (((Manche) arg0).isMancheEstFinie() && ((Manche) arg0).getScoreTotal() < Partie.getScoreGagnant())
		{	
			JOptionPane.showMessageDialog(this, ((Manche) arg0).getJoueurGagnant2().getNom() + " a gagner la manche!");
			this.controleur.init();
			this.controleur.ajouterObserver(this);
			this.setVisible(false);
			this.controleur.demarerLaPartie();	
			this.setVisible(true);
		}
		
		else if (((Manche) arg0).getUno() && ((Manche) arg0).getJoueurReelExistant())
			JOptionPane.showMessageDialog(this, ((Manche) arg0).getJoueurCourant().getNom() + " déclare Uno !!");
		else if(((Manche) arg0).getScoreTotal() >= Partie.getScoreGagnant())
		{
			JOptionPane.showMessageDialog(this, ((Manche) arg0).getJoueurGagnant().getNom() + " a gagné la partie ");
			System.exit(0);
		}

	}
}
