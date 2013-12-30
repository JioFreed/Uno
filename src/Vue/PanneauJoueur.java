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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolTip;
import javax.swing.border.TitledBorder;

import Modele.Carte;
import Modele.Joueur;

public class PanneauJoueur extends JPanel implements Observer, ActionListener
{
	final static int TAILLE_HORIZONTALE = 1100;
	final static int TAILLE_VERTICALE = 280;
	private Joueur joueur;
	private TitledBorder titre;
	private JPanel panneauMain;
	private JPanel panneauCible;
	private GridBagConstraints contraintes;
	private JButton boutonCible = new JButton ("Jouer !");
	private JButton boutonPasser = new JButton ("Passer son Tour !");
	
	public PanneauJoueur (Joueur joueurConcerne)
	{
		super();

		//joueurConcerne.ajouterObserver(this);
		this.joueur = joueurConcerne;
		
		// Forme du panneau principal
		this.titre = new TitledBorder(joueurConcerne.getNom());
		//this.changerCouleur(joueurConcerne.getCouleur());
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
        
        this.panneauCible = new JPanel ();
		this.panneauCible.setPreferredSize(new Dimension(TAILLE_HORIZONTALE/4, TAILLE_VERTICALE/3));
        this.panneauCible.setMaximumSize(new Dimension(TAILLE_HORIZONTALE/4, TAILLE_VERTICALE/3));
        this.panneauCible.setMinimumSize(new Dimension(TAILLE_HORIZONTALE/4, TAILLE_VERTICALE/3)); 
        
        this.boutonCible.addActionListener(this);
        this.boutonPasser.addActionListener(this);
        this.panneauCible.add(this.boutonCible);
        this.panneauCible.add(this.boutonPasser);
        
        this.setContraintes(3, 2, 1, 1);
        this.add(this.panneauCible, this.contraintes);
        
        this.toutMettreAJour();
	}

	public void changerCouleur (Color nvleCouleur)
	{
        this.titre.setTitleColor(nvleCouleur);
	}
	
	/**
	 * Met à jour le panel contenant la main du joueur
	 */
	public void mettreAJourMain ()
	{
		this.panneauMain.removeAll();
		GestionnaireMain gestionnaire = new GestionnaireMain ();
		for (int i = 0; i < this.joueur.getMain().size(); i++)
		{
			//if (this.joueur.isEstJoueurActuel())
				this.panneauMain.add(new LabelCarte (this.joueur.getMain().get(i), "moy", gestionnaire));
			//else
				//this.panneauMain.add(new JLabel (Images.redimensionnerMoy(Images.CACHEE)));
		}
		this.panneauMain.validate();
	}

	public void toutMettreAJour ()
	{
		this.mettreAJourMain();
		this.mettreAJourCible();
	}

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
		/*if (!this.joueur.estJoueurVirtuel())
			JOptionPane.showMessageDialog(Images.getFenetre(this), this.joueur + " à toi de jouer !");*/
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
