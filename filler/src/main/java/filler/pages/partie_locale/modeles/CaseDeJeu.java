
package filler.pages.partie_locale.modeles;

import filler.enumerations.Couleur;
import ntro.debogage.J;

public class CaseDeJeu implements CaseDeJeuLectureSeule {
	
	private Couleur couleur;
	private transient int indiceColonne;
	private transient int indiceRangee;

	@Override
	public Couleur getCouleur() {
		J.appel(this);

		return couleur;
	}

	@Override
	public int getIndiceRangee() {
		J.appel(this);

		return indiceRangee;
	}

	@Override
	public int getIndiceColonne() {
		J.appel(this);

		return indiceColonne;
	}
	
	public void setIndiceColonne(int indiceColonne) {
		J.appel(this);
		
		this.indiceColonne = indiceColonne;
	}
	
	public void setIndiceRangee(int indiceRangee) {
		J.appel(this);
		
		this.indiceRangee = indiceRangee;
	}

	public void setCouleur(Couleur couleur) {
		J.appel(this);
		
		this.couleur = couleur;
	}
}
