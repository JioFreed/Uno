package Modele;

import javax.swing.JOptionPane;

/**
 * Class représentant le joueur Reel
 * 
 * @author Youssef,Ananias
 * 
 */
public class JoueurReel extends Joueur {

	public JoueurReel(String nom) {
		super(nom);
	}

	@Override
	public boolean douter() {
		int selectedValue = JOptionPane.showConfirmDialog(null,
				"Voulez vous verifier le coup?", "Choisir ",
				JOptionPane.YES_NO_OPTION);
		System.out.println(selectedValue);
		return selectedValue == 0 ? true : false;
	}

	@Override
	public void passerSonTour(Talon t) {

	}

	@Override
	public int choisirCouleur(Talon t, Joueur j, Joueur j2) {
		return 0;
	}

	@Override
	public int choisirCarte(Talon t, Joueur j, Joueur j2) {
		return 0;
	}

	@Override
	public int choisirAction(Talon t, Joueur j, Joueur j2) {
		return 0;
	}

}
