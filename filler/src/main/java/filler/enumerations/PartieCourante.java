
package filler.enumerations;

import ntro.debogage.J;

public enum PartieCourante {
	
	PARTIE_NULL("Joueur1", 0, 0);
	
	private String tourAJouer = "";
    private int pointJoueur1;
	private int pointJoueur2;
	
	private PartieCourante(String tourAJouer, int pointJoueur1, int pointJoueur2) {
		J.appel(this);

		this.tourAJouer = tourAJouer;
		this.pointJoueur1 = pointJoueur1;
		this.pointJoueur2 = pointJoueur2;
	}
	
	public String getTourAJouer(){
		return tourAJouer;
	}
	
	public int getPointJoueur1(){
		return pointJoueur1;
	}
	
	public int getPointJoueur2(){
		return pointJoueur2;
	}

}