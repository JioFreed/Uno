package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Modele.Joueur;

public class PanneauJoueurInactif extends JPanel implements Observer {

	final static int X_MAX = 80;
	final static int Y_MAX = 40;
	private JLabel labelNombreKm;
	private TitledBorder titre;

	public PanneauJoueurInactif(Joueur joueurConcerne) {
		super();

		joueurConcerne.ajouterObserver(this);

		// Titre contenant le nom du joueur
		titre = new TitledBorder(joueurConcerne.getNom());
		this.setBorder(titre);

		// Label indiquant le nombre de kilomètres parcouru
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
