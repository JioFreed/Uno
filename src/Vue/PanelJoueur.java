package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import Modele.Joueur;

public class PanelJoueur extends JPanel implements Observer, ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Taille horizontale du panel
	 */
	final static int TAILLE_HORIZONTALE = 1100;
	
	/**
	 * Taille verticale du panel
	 */
	final static int TAILLE_VERTICALE = 280;
	
	/**
	 * Le joueur concerné
	 */
	private Joueur joueur;
	
	/**
	 * le titre qui est aussi le nom du joueur courant
	 */
	private TitledBorder titre;
	
	/**
	 * Panel représentant la main du jouer courant
	 */
	private JPanel panneauMain;
	
	/**
	 * Panneau pour l'action à effectuer
	 */
	private JPanel panneauAction;
	
	private GridBagConstraints contraintes;
	/**
	 * Bouton permettant de jouer
	 */
	private JButton boutonCible = new JButton ("Jouer !");
	
	/**
	 * Bouton permettant de passer son tour
	 */
	private JButton boutonPasser = new JButton ("Passer son Tour !");
	
	/**
	 * Crée les différents panel composant le panneau du joueur
	 * @param joueurConcerne
	 */
	
	public PanelJoueur (Joueur joueurConcerne)
	{
		super();
		this.joueur = joueurConcerne;
		
		// Forme du panneau principal
		this.titre = new TitledBorder(joueurConcerne.getNom());
		this.setBorder(this.titre);
		this.setPreferredSize(new Dimension(TAILLE_HORIZONTALE + 20, TAILLE_VERTICALE + 20));
        this.setMaximumSize(new Dimension(TAILLE_HORIZONTALE + 20, TAILLE_VERTICALE + 20));
        this.setMinimumSize(new Dimension(TAILLE_HORIZONTALE + 20, TAILLE_VERTICALE + 20));  

		this.setLayout(new GridBagLayout ());
		this.contraintes = new GridBagConstraints ();
		
        
        // Panneau de la main
		this.panneauMain =  new JPanel ();
		this.panneauMain.setPreferredSize(new Dimension(TAILLE_HORIZONTALE -200, TAILLE_VERTICALE));
        this.panneauMain.setMaximumSize(new Dimension(TAILLE_HORIZONTALE-200, TAILLE_VERTICALE));
        this.panneauMain.setMinimumSize(new Dimension(TAILLE_HORIZONTALE-200, TAILLE_VERTICALE)); 
        this.setContraintes(0, 0, 2, 3);
        this.add(this.panneauMain, this.contraintes);     
        
        this.panneauAction = new JPanel ();
		this.panneauAction.setPreferredSize(new Dimension(TAILLE_HORIZONTALE/4, TAILLE_VERTICALE/3));
        this.panneauAction.setMaximumSize(new Dimension(TAILLE_HORIZONTALE/4, TAILLE_VERTICALE/3));
        this.panneauAction.setMinimumSize(new Dimension(TAILLE_HORIZONTALE/4, TAILLE_VERTICALE/3)); 
        
        this.boutonCible.addActionListener(this);
        this.boutonPasser.addActionListener(this);
        this.panneauAction.add(this.boutonCible);
        this.panneauAction.add(this.boutonPasser);
        
        this.setContraintes(3, 2, 1, 1);
        this.add(this.panneauAction, this.contraintes);
        
        this.toutMettreAJour();
	}

	public void changerCouleur (Color nvleCouleur)
	{
        this.titre.setTitleColor(nvleCouleur);
	}
	
	/**
	 * Met à jour le panel contenant la main du joueur courant
	 */
	public void mettreAJourMain ()
	{
		this.panneauMain.removeAll();
		GestionnaireMain gestionnaire = new GestionnaireMain ();
		for (int i = 0; i < this.joueur.getMain().size(); i++)
		{
			this.panneauMain.add(new LabelCarte (this.joueur.getMain().get(i), "moy", gestionnaire));
		}
		this.panneauMain.validate();
	}

	public void toutMettreAJour ()
	{
		this.mettreAJourMain();
		this.mettreAJourCible();
	}

	/**
	 * Met à jour le bouton d'action selon les carte en possession
	 * 
	 * Le bouton jouer ne s'affiche que lorsqu'un joueur à une carte jouable
	 * Le bouton passer son tour ne s'affiche que lorqu'un joueur n'a pas de carte jouable même s'il a pioché une carte
	 */
	public void mettreAJourCible()
	{
		if (this.joueur.isaUneCarteJouable())
		{
			this.boutonCible.setVisible(true);
			this.boutonPasser.setVisible(false);
		}
		
		else if(this.joueur.getAPiocher())
		{
			if (this.joueur.isaUneCarteJouable())
			{
				this.boutonCible.setVisible(true);
				this.boutonPasser.setVisible(true);
			}
			else
			{
				this.boutonCible.setVisible(false);
				this.boutonPasser.setVisible(true);
			}
		}
		else
		{
			this.boutonCible.setVisible(false);
			this.boutonPasser.setVisible(false);
		}
		
	}
	public void update(Observable arg0, Object arg1) 
	{
		this.toutMettreAJour();
	}
	
	public void setContraintes (int xDebut, int yDebut, int xTaille, int yTaille)
	{
		this.contraintes.gridx = xDebut;
		this.contraintes.gridy = yDebut;
		this.contraintes.gridwidth= xTaille;
		this.contraintes.gridheight = yTaille;
		this.contraintes.fill = GridBagConstraints.BOTH;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == this.boutonCible)
		{
			Images.getFenetre(this).jouerCarte();
			this.boutonCible.setVisible(false);
			this.boutonPasser.setVisible(false);
		}
		
		if (e.getSource() == this.boutonPasser)
		{
			Images.getFenetre(this).passerTour();
			this.boutonPasser.setVisible(false);
		}
	}
}
