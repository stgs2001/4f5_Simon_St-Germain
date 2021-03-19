
package filler.pages.partie_locale.modeles;

import filler.enumerations.PartieCourante;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
//import ntro.mvc.modeles.Modele;

public class PartieLocale extends Partie<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule {
	
	private String tourAJouer = "";
    private int pointJoueur1;
	private int pointJoueur2;
	
	@Override
	public void apresCreation() {
		J.appel(this);
		
		tourAJouer = "Joueur1";
		pointJoueur1 = 0;
		pointJoueur2= 0;
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);
		
		DoitEtre.nonNul(tourAJouer);
		DoitEtre.nonNul(pointJoueur1);
		DoitEtre.nonNul(pointJoueur1);
	}

	public String getTourAJouer() {
		return tourAJouer;
	}

	public void setTourAJouer(String tourAJouer) {
		this.tourAJouer = tourAJouer;
	}

	public int getPointJoueur1() {
		return pointJoueur1;
	}

	public void setPointJoueur1(int pointJoueur1) {
		this.pointJoueur1 = pointJoueur1;
	}

	public int getPointJoueur2() {
		return pointJoueur2;
	}

	public void setPointJoueur2(int pointJoueur2) {
		this.pointJoueur2 = pointJoueur2;
	}

}
