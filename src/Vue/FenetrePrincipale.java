package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Modele.*;
import Controleur.Controleur;
import Vue.FenetrePrincipale;


public class FenetrePrincipale extends JFrame implements ActionListener, KeyListener
{
	
	final static int TAILLEX = 1050;
	final static int TAILLEY = 600;
	private ParametrePartie parametres;
	private GridBagConstraints contraintes;
	private JPanel panneauAjoutJoueur;
	private JPanel panneauListeJoueur;
	private ArrayList<Joueur> listeParticipants = new ArrayList<Joueur> ();
	private JButton[] boutonsSupprimer = new JButton [7];
	private JComboBox choixTypeJoueur;
	private JTextField choixNomJoueur = new JTextField (10);
    private String[] choixTypes = {"Reel", "Virtuel Aggressif","Virtuel Imprevisible","Virtuel Normal"};
    private JLabel labelNom = new JLabel (" Nom entre 3 et 12 caractères : ");
	private JButton boutonAjouterJoueur;
	private JComboBox choixScoreGagnant;
	private JRadioButton boutonOui;
	private JRadioButton boutonNon;
	private JButton boutonValidation;
	
	public FenetrePrincipale ()
	{
		super ();

		this.parametres = new ParametrePartie ();
		
		this.setSize(TAILLEX, TAILLEY);
		this.setLocationRelativeTo(this);
		this.setLayout(new GridBagLayout ());
		this.contraintes = new GridBagConstraints ();
		
		// Titre
		JLabel labelTitre = new JLabel ("Choisissez les paramètres :");
        labelTitre.setHorizontalAlignment(JLabel.CENTER);
        labelTitre.setVerticalAlignment(JLabel.CENTER);
        labelTitre.setFont(new Font(Font.DIALOG_INPUT,25,25));
		this.setContraintes (1, 0, 2, 1);
        this.add(labelTitre, this.contraintes);
		this.setContraintes (1, 1, 2, 1);
        this.add(Box.createRigidArea(new Dimension (300, 50)), this.contraintes);
        
        
        // Ajout de joueurs
        this.panneauListeJoueur = new JPanel ();
        this.panneauListeJoueur.setLayout(new GridBagLayout());
        this.dimensionner(this.panneauListeJoueur,400, 200);
        this.majListe();
        this.setContraintes(0, 2, 2, 2);
        this.add(this.panneauListeJoueur, this.contraintes);
        
        this.panneauAjoutJoueur = new JPanel();
        this.panneauAjoutJoueur.add(new JLabel("Ajouter un joueur "));
        this.choixTypeJoueur = new JComboBox(this.choixTypes);
        this.choixTypeJoueur.addActionListener(this);
        this.panneauAjoutJoueur.add(this.choixTypeJoueur);
        this.panneauAjoutJoueur.add(this.labelNom);
        this.choixNomJoueur.addKeyListener(this);
        this.panneauAjoutJoueur.add(this.choixNomJoueur);
        this.boutonAjouterJoueur = new JButton ("Ajouter !");
        this.boutonAjouterJoueur.addActionListener(this);
        this.majBoutonAjout();	
        this.panneauAjoutJoueur.add (boutonAjouterJoueur);
        this.setContraintes(0, 5, 4, 1);
        this.add(this.panneauAjoutJoueur, this.contraintes);
        
        // Panneau pour score
        JPanel panneauLimite = new JPanel();
        panneauLimite.add(new JLabel ("Score Gagnant : "));
        this.choixScoreGagnant = new JComboBox ();
        this.choixScoreGagnant.addItem("Illimité");
        this.parametres.setScoreGagnant(Integer.MAX_VALUE);
        for (int i = 500; i <= 1000; i += 100)
        	this.choixScoreGagnant.addItem(i);
        this.choixScoreGagnant.addActionListener(this);
        panneauLimite.add(this.choixScoreGagnant);
        this.setContraintes(2, 2, 1, 1);
        this.add(panneauLimite, this.contraintes);
        
        // Bouton de validation
        JPanel panneauValider = new JPanel ();
        this.boutonValidation = new JButton ("Commencer la partie !");
        this.boutonValidation.addActionListener(this);
        if (this.parametres.parametresSontValides())
        	this.boutonValidation.setEnabled(true);
        else
        	this.boutonValidation.setEnabled(false);
        this.setContraintes(1, 5, 2, 1);
        this.add(Box.createRigidArea(new Dimension (300,50)), this.contraintes);
        panneauValider.add(this.boutonValidation, BorderLayout.CENTER);
        this.setContraintes(1, 6, 2, 1);
        this.add(panneauValider, this.contraintes);
		
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		this.setVisible(true);
	}
	
	public void setContraintes (int xDebut, int yDebut, int xTaille, int yTaille)
	{
		this.contraintes.gridx = xDebut;
		this.contraintes.gridy = yDebut;
		this.contraintes.gridwidth= xTaille;
		this.contraintes.gridheight = yTaille;
	}
	
	
	public void dimensionner (JComponent composant, int x, int y)
	{
        composant.setSize(x,y);
        composant.setPreferredSize(new Dimension(x,y));
        composant.setMinimumSize(new Dimension(x,y));
        composant.setMaximumSize(new Dimension(x,y));
	}
	
	public void majListe ()
	{
		this.panneauListeJoueur.removeAll();
		this.panneauListeJoueur.repaint();
		this.panneauListeJoueur.setLayout(new GridBagLayout ());
		int i = 0;
		for (i = 0; i < this.listeParticipants.size(); i++)
		{
			JPanel panelTmp = new JPanel ();
			JLabel labelTmp = new JLabel ("Joueur " + (i + 1) + " : " + this.listeParticipants.get(i).getNom());
			this.boutonsSupprimer[i] = new JButton("Supprimer");
			this.boutonsSupprimer[i].addActionListener(this);
			panelTmp.add(labelTmp);
			panelTmp.add(this.boutonsSupprimer[i]);
			this.setContraintes(0, i, 1, 1);
			this.panneauListeJoueur.add(panelTmp, this.contraintes);
		}
		this.setContraintes(0, i, 1, 1);
		this.panneauListeJoueur.add(Box.createRigidArea(new Dimension (400, 200 - (i*40))), this.contraintes);
        this.panneauListeJoueur.validate();
	}
	
	public void majBoutonAjout ()
	{
		this.choixNomJoueur.setToolTipText("");
		this.boutonAjouterJoueur.setEnabled(false);
		
		if (this.listeParticipants.size() < 8)
		{
			// XXX Rajouter quand niveaux virtuels
			if (this.choixTypeJoueur.getSelectedIndex() == 1)
				this.boutonAjouterJoueur.setEnabled(true);
			else if (this.choixTypeJoueur.getSelectedIndex() == 2)
				this.boutonAjouterJoueur.setEnabled(true);
			else if (this.choixTypeJoueur.getSelectedIndex() == 3)
				this.boutonAjouterJoueur.setEnabled(true);
			else
			{
				String nomChoisi = this.choixNomJoueur.getText();
				if (nomChoisi.length() < 3)
					this.choixNomJoueur.setToolTipText("Min : 3 caractères");
				else if (nomChoisi.length() > 12)
					this.choixNomJoueur.setToolTipText("Max : 12 caractères");
				else if (!this.parametres.peutAjouterJoueur(nomChoisi))
					this.choixNomJoueur.setToolTipText("Nom déjà pris !");
				else
					this.boutonAjouterJoueur.setEnabled(true);
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == this.boutonAjouterJoueur)
		{	
			Joueur joueurAjoute;
			if (this.choixTypeJoueur.getSelectedIndex() == 0) // Réel
				joueurAjoute = new JoueurReel (this.choixNomJoueur.getText());
			else if(this.choixTypeJoueur.getSelectedIndex() == 1) // Virtuel
			{
				// Astuce pour ne pas avoir des joueurs virtuels de même nom
				do
					joueurAjoute = new JoueurVirtuel (new Aggressif());
				while (!this.parametres.peutAjouterJoueur(joueurAjoute.getNom()));
			}
			else if(this.choixTypeJoueur.getSelectedIndex() == 2)
			{
				// Astuce pour ne pas avoir des joueurs virtuels de même nom
				do
					joueurAjoute = new JoueurVirtuel (new Imprevisible());
				while (!this.parametres.peutAjouterJoueur(joueurAjoute.getNom()));
			}
			else 
			{
				// Astuce pour ne pas avoir des joueurs virtuels de même nom
				do
					joueurAjoute = new JoueurVirtuel (new Imprevisible());
				while (!this.parametres.peutAjouterJoueur(joueurAjoute.getNom()));
			}
			this.parametres.ajouterJoueur(joueurAjoute);
			this.listeParticipants.add(joueurAjoute);
			this.majListe();
			this.choixNomJoueur.setText("");
			
			this.majBoutonAjout();
		}
		else if (e.getSource () == this.choixTypeJoueur)
		{
			this.majBoutonAjout();
			if (this.choixTypeJoueur.getSelectedIndex() == 1 || this.choixTypeJoueur.getSelectedIndex() == 2 || this.choixTypeJoueur.getSelectedIndex() == 3)
			{
				this.labelNom.setVisible(false);
				this.choixNomJoueur.setVisible(false);
			}
			else
			{
				this.labelNom.setVisible(true);
				this.choixNomJoueur.setVisible(true);
			}
		}	
		else if (e.getSource() == this.choixScoreGagnant)
		{
			if (this.choixScoreGagnant.getSelectedIndex() == 0)
				this.parametres.setScoreGagnant(Integer.MAX_VALUE);
			else
				this.parametres.setScoreGagnant(Integer.parseInt(this.choixScoreGagnant.getSelectedItem().toString()));
		}
		else if (e.getSource() == this.boutonValidation)
			this.lancerUnePartie ();
		else
		{
			// On chercher si c'est un des boutons de suppression de joueur participant qui a été appelé
			for (int i = 0; i < this.boutonsSupprimer.length; i++)
			{
				if (e.getSource() == this.boutonsSupprimer[i])
				{
					this.parametres.supprimerJoueur(this.listeParticipants.get(i).getNom());
					this.listeParticipants.remove(i);
					this.majListe();
					this.majBoutonAjout();
				}
			}
		}
		
		// On met à jour le bouton pour commencer la partie
		if (this.parametres.parametresSontValides())
        	this.boutonValidation.setEnabled(true);
        else
        	this.boutonValidation.setEnabled(false);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub	
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) 
	{
		if (e.getSource() == this.choixNomJoueur)
			this.majBoutonAjout();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub	
	}
	
	/**
	 * Lance une partie avec les paramètres entrés. Relance une fenetre de paramétrage si les paramètres sont invalides
	 * et que la partie ne peut être lancée.
	 */
	public void lancerUnePartie ()
	{
		this.setVisible(false);
		this.dispose();
		Partie partie = new Partie (this.parametres);
		Controleur controleur = new Controleur (partie);
		new FenetreParametre(controleur);
	
	}
}

