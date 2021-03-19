
package filler.pages.partie_locale;

import javafx.application.Application;
import javafx.stage.Stage;
import ntro.debogage.J;
import ntro.javafx.Initialisateur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;
import filler.pages.partie_locale.modeles.PartieLocale;

import static filler.Constantes.*;

import java.util.Random;

public class PagePartieLocale extends Application {

	static {

		Initialisateur.initialiser();
		
		J.appel(PagePartieLocale.class);
	}

	private Random alea = new Random();
	
	public static void main(String[] args) {
		J.appel(PagePartieLocale.class);
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		J.appel(this);
		
		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		PartieLocale partie = EntrepotDeModeles.obtenirModele(PartieLocale.class, idModeleTest);
		
		J.valeurs(partie.getId(), partie.getTourAJouer(), partie.getPointJoueur1(), partie.getPointJoueur2());

		Systeme.quitter();
		
	}
}
