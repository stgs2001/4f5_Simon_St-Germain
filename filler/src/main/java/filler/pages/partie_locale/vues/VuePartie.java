
package filler.pages.partie_locale.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import filler.Constantes;
import filler.enumerations.Couleur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public abstract class VuePartie implements Vue, Initializable {

    @FXML
    private HBox conteneurEntetes;

    @FXML
    private VBox conteneurGrille;
    
    private Button[] entetes;
    
    private Button[][] cases;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(conteneurEntetes);
		DoitEtre.nonNul(conteneurGrille);
	} 

    public void creerGrille(int largeur, int hauteur) {
        J.appel(this);

        creerEntetes(largeur);
        
        creerColonnes(largeur, hauteur);
    }
    
    private void creerEntetes(int largeur) {
        J.appel(this);
        
        entetes = new Button[largeur];
        
        for(int indiceRangee = 0; indiceRangee < largeur; indiceRangee++) {
        	
        	Button entete = new Button("|");
        	
        	entete.setMinWidth(Constantes.TAILLE_CASE);
        	entete.setMaxWidth(Constantes.TAILLE_CASE);
        	
        	entetes[indiceRangee] = entete;
        	
        	conteneurEntetes.getChildren().add(entete);
        }
    }

    private void creerColonnes(int largeur, int hauteur) {
        J.appel(this);
        
        cases = new Button[largeur][hauteur];

        for(int indiceRangee = 0; indiceRangee < hauteur; indiceRangee++) {
        	HBox ligne = creerLigne(indiceRangee, largeur);
        	
        	conteneurGrille.getChildren().add(ligne);
        }
    }

    private HBox creerLigne(int indiceRangee, int largeur) {
        J.appel(this);
        
        HBox ligne = new HBox();
        
        for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
        	
        	Button _case = new Button();
        	
        	_case.setMinWidth(Constantes.TAILLE_CASE);
        	_case.setMaxWidth(Constantes.TAILLE_CASE);
        	
        	cases[indiceColonne][indiceRangee] = _case;
        	
        	ligne.getChildren().add(_case);
        }
        
        return ligne;
    }
    

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	} 
	
	private boolean siIndicesValides(int indiceColonne, int indiceRangee) {
		J.appel(this);

		boolean siValide = false;
		
		if(indiceColonne >= 0 && indiceColonne < cases.length) {
			siValide = indiceRangee >= 0 && indiceRangee < cases[indiceColonne].length;
		}
		
		return siValide;
	}

	public void afficherCaseDeJeu(int indiceColonne, int indiceRangee, Couleur couleur) {
		J.appel(this);
		
		if(siIndicesValides(indiceColonne, indiceRangee)) {

			Button _case = cases[indiceColonne][indiceRangee];
			
			switch(couleur) {
				case JAUNE:
					_case.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
					break;

				case ROUGE:
					_case.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
					break;
			}
		}
	}

}
