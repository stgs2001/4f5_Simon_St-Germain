
package filler.pages.partie_locale.afficheurs;

import java.util.List;

import ntro.debogage.J;
import ntro.mvc.Afficheur;
import filler.enumerations.Couleur;
import filler.pages.partie_locale.modeles.ColonneLectureSeule;
import filler.pages.partie_locale.modeles.GrilleLectureSeule;
import filler.pages.partie_locale.modeles.CaseDeJeuLectureSeule;
import filler.pages.partie_locale.modeles.PartieLectureSeule;
import filler.pages.partie_locale.vues.VuePartie;


public abstract class   AfficheurPartie<PLS extends PartieLectureSeule, 
                                        V extends VuePartie> 

				extends Afficheur<PLS, V> {

	@Override
	public void initialiserAffichage(PLS partieLectureSeule, V vue) {
		J.appel(this);
		
		int largeur = partieLectureSeule.getLargeur();
		int hauteur = partieLectureSeule.getHauteur();
		
		vue.creerGrille(largeur, hauteur);
	}

	@Override
	public void rafraichirAffichage(PLS partieLectureSeule, V vue) {
		J.appel(this);

		GrilleLectureSeule grille = partieLectureSeule.getGrille();
		
		int hauteurGrille = partieLectureSeule.getHauteur();
		
		rafraichirGrille(hauteurGrille, grille, vue);
	}

	private void rafraichirGrille(int hauteurGrille, GrilleLectureSeule grille, V vue) {
		J.appel(this);

		List<ColonneLectureSeule> colonnes = grille.getColonnes();
		
		for(int indiceColonne = 0; indiceColonne < colonnes.size(); indiceColonne++) {
		
			ColonneLectureSeule colonne = colonnes.get(indiceColonne);
			List<CaseDeJeuLectureSeule> casesDeJeu = colonne.getCasesDeJeu();
			
			rafraichirColonne(hauteurGrille, indiceColonne, casesDeJeu, vue);

		}
	}

	private void rafraichirColonne(int hauteurGrille, 
								   int indiceColonne, 
								   List<CaseDeJeuLectureSeule> casesDeJeu, 
								   V vue) {
		J.appel(this);
		
		
		for(int indiceRangee = 0; indiceRangee < casesDeJeu.size(); indiceRangee++) {
			
			CaseDeJeuLectureSeule caseDeJeu = casesDeJeu.get(indiceRangee);
			Couleur couleur = caseDeJeu.getCouleur();
			
			afficherCaseDeJeu(hauteurGrille, indiceColonne, indiceRangee, couleur, vue);
		}
	}
	
	private void afficherCaseDeJeu(int hauteurGrille, 
			                   int indiceColonne,  
			                   int indiceRangee, 
			                   Couleur couleur,
			                   V vue) {
		J.appel(this);
		
		int indiceRangeeCoordonneesGraphiques = convertirEnCoordonneesGraphiques(hauteurGrille, indiceRangee);

		vue.afficherCaseDeJeu(indiceColonne, indiceRangeeCoordonneesGraphiques, couleur);
	}
	
	private int convertirEnCoordonneesGraphiques(int hauteurGrille, int indiceRangee) {
		J.appel(this);

		return hauteurGrille - indiceRangee - 1;
	}

}
