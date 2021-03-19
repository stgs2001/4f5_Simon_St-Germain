
package filler.pages.partie_locale.controleurs;

import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import filler.pages.partie_locale.afficheurs.AfficheurPartie;
import filler.pages.partie_locale.modeles.Partie;
import filler.pages.partie_locale.modeles.PartieLectureSeule;
import filler.pages.partie_locale.vues.VuePartie;

public abstract class ControleurPartie<PLS extends PartieLectureSeule, 
							    P extends Partie<PLS>,
                                V extends VuePartie, 
                                A extends AfficheurPartie<PLS, V>>

	            extends ControleurModeleVue<PLS, P, V, A> {

	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
	} 
}
