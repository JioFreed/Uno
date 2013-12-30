package Vue;

import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 * Classe contenant toutes les données relatives aux images de la partie
 * 
 * @author Yann, Youssef
 *
 */
public class Images
{
	/**
	 * Taille horizontale pour un redimensionnement minimal des cartes
	 */
	public final static int ECHELLEX_MIN = 62;
	/**
	 * Taille verticale pour un redimensionnement moyen des cartes
	 */
	public final static int ECHELLEY_MIN = 75;
	/**
	 * Taille horizontale pour un redimensionnement moyen des cartes
	 */
	public final static int ECHELLEX_MOY = 80;
	/**
	 * Taille verticale pour un redimensionnement moyen des cartes
	 */
	public final static int ECHELLEY_MOY = 105;
	/**
	 * Taille horizontale pour un redimensionnement maximum des cartes
	 */
	public final static int ECHELLEX_MAX = 90;
	/**
	 * Taille verticale pour un redimensionnement maximum des cartes
	 */
	public final static int ECHELLEY_MAX = 120;
	
	public final static String CHEMIN = "Image/";
	public final static String CACHEE = CHEMIN + "Cachee.png";
	
	// Rouge
	public final static String redPlusTwo= CHEMIN + "+2rouge.png";
	public final static String redNone= CHEMIN + "0rouge.png";
	public final static String redOne = CHEMIN + "1rouge.png";
	public final static String redTwo = CHEMIN + "2rouge.png";
	public final static String redThree = CHEMIN + "3rouge.png";
	public final static String redFour = CHEMIN + "4rouge.png";
	public final static String redFive = CHEMIN + "5rouge.png";
	public final static String redSix = CHEMIN +"6rouge.png";
	public final static String redSeven = CHEMIN + "7rouge.png";
	public final static String redEight = CHEMIN + "8rouge.png";
	public final static String redNine = CHEMIN + "9rouge.png";
	public final static String InverserRed = CHEMIN + "InverserRouge.png";
	public final static String StopRed = CHEMIN + "StopRouge.png";
	
	
	// Blue
	public final static String bluePlusTwo= CHEMIN + "+2blue.png";
	public final static String blueNone= CHEMIN + "0blue.png";
	public final static String blueOne = CHEMIN + "1blue.png";
	public final static String blueTwo = CHEMIN + "2blue.png";
	public final static String blueThree = CHEMIN + "3blue.png";
	public final static String blueFour = CHEMIN + "4blue.png";
	public final static String blueFive = CHEMIN + "5blue.png";
	public final static String blueSix = CHEMIN +"6blue.png";
	public final static String blueSeven = CHEMIN + "7blue.png";
	public final static String blueEight = CHEMIN + "8blue.png";
	public final static String blueNine = CHEMIN + "9blue.png";
	public final static String Inverserblue = CHEMIN + "InverserBlue.png";
	public final static String Stopblue = CHEMIN + "StopBlue.png";
	
	// Yellow
	public final static String jaunePlusTwo= CHEMIN + "+2jaune.png";
	public final static String jauneNone= CHEMIN + "0jaune.png";
	public final static String jauneOne = CHEMIN + "1jaune.png";
	public final static String jauneTwo = CHEMIN + "2jaune.png";
	public final static String jauneThree = CHEMIN + "3jaune.png";
	public final static String jauneFour = CHEMIN + "4jaune.png";
	public final static String jauneFive = CHEMIN + "5jaune.png";
	public final static String jauneSix = CHEMIN +"6jaune.png";
	public final static String jauneSeven = CHEMIN + "7jaune.png";
	public final static String jauneEight = CHEMIN + "8jaune.png";
	public final static String jauneNine = CHEMIN + "9jaune.png";
	public final static String Inverserjaune = CHEMIN + "InverserJaune.png";
	public final static String Stopjaune = CHEMIN + "StopJaune.png";
	
	// Green
	public final static String greenPlusTwo= CHEMIN + "+2vert.png";
	public final static String greenNone= CHEMIN + "0vert.png";
	public final static String greenOne = CHEMIN + "1vert.png";
	public final static String greenTwo = CHEMIN + "2vert.png";
	public final static String greenThree = CHEMIN + "3vert.png";
	public final static String greenFour = CHEMIN + "4vert.png";
	public final static String greenFive = CHEMIN + "5vert.png";
	public final static String greenSix = CHEMIN +"6vert.png";
	public final static String greenSeven = CHEMIN + "7vert.png";
	public final static String greenEight = CHEMIN + "8vert.png";
	public final static String greenNine = CHEMIN + "9vert.png";
	public final static String Inversergreen = CHEMIN + "InverserVert.png";
	public final static String Stopgreen = CHEMIN + "StopVert.png";
	
	//Joker +4
	public final static String joker = CHEMIN + "Joker.png";
	public final static String plusFour = CHEMIN + "+4.png";
	
	//Couleur jeu
	
	public final static String red = CHEMIN + "red.png";
	public final static String blue = CHEMIN + "blue.png";
	public final static String green = CHEMIN + "green.png";
	public final static String jaune = CHEMIN + "jaune.png";
	
	/**
	 * Retourne une image redimensionnée de taille minimale
	 * 
	 * @param cheminImage
	 * 			Chemin de l'image qui doit être redimensionnée
	 * @return Image redimensionnée
	 */
	public static ImageIcon redimensionnerMin (String cheminImage)
	{
		return new ImageIcon(new ImageIcon(cheminImage).getImage().getScaledInstance(ECHELLEX_MIN, ECHELLEY_MIN, Image.SCALE_DEFAULT));
	}
	
	/**
	 * Retourne une image redimensionnée de taille moyenne
	 * 
	 * @param cheminImage
	 * 			Chemin de l'image qui doit être redimensionnée
	 * @return Image redimensionnée
	 */
	public static ImageIcon redimensionnerMoy (String cheminImage)
	{
		return new ImageIcon(new ImageIcon(cheminImage).getImage().getScaledInstance(ECHELLEX_MOY, ECHELLEY_MOY, Image.SCALE_DEFAULT));
	}

	/**
	 * Retourne une image redimensionnée de taille maximum
	 * 
	 * @param cheminImage
	 * 			Chemin de l'image qui doit être redimensionnée
	 * @return Image redimensionnée
	 */
	public static ImageIcon redimensionnerMax (String cheminImage)
	{
		return new ImageIcon(new ImageIcon(cheminImage).getImage().getScaledInstance(ECHELLEX_MAX, ECHELLEY_MAX, Image.SCALE_DEFAULT));
	}
	
	/**
	 * Fonction pour récupérer une instance de FenetrePrincipale qui contient un composant
	 * 
	 * @param c
	 * 			Composant à qui on cherche la fenêtre
	 * @return Une instance de FenetrePrincipale
	 */
	public static FenetreParametre getFenetre (JComponent c)
	{
		Window window = SwingUtilities.windowForComponent(c);
		return (FenetreParametre) window;
	}
}
