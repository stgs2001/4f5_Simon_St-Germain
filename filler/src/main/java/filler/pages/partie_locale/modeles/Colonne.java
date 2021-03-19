
package filler.pages.partie_locale.modeles;

import java.util.ArrayList;

import java.util.List;

import filler.enumerations.Couleur;
import ntro.debogage.J;

public class Colonne implements ColonneLectureSeule {
	
	private List<CaseDeJeu> casesDeJeu = new ArrayList<>();
	private transient int idColonne;

	public CaseDeJeu ajouterCaseDeJeu(Couleur couleur) {
		J.appel(this);
		
		CaseDeJeu caseDeJeu = new CaseDeJeu();

		caseDeJeu.setCouleur(couleur);
		caseDeJeu.setIndiceColonne(idColonne);
		caseDeJeu.setIndiceRangee(casesDeJeu.size());
		
		casesDeJeu.add(caseDeJeu);
		
		return caseDeJeu;
	}

	@Override
	public List<CaseDeJeuLectureSeule> getCasesDeJeu() {
		J.appel(this);
		
		List<CaseDeJeuLectureSeule> casesDeJeuLectureSeule = new ArrayList<>();
		
		for(CaseDeJeu caseDeJeu : casesDeJeu) {

			casesDeJeuLectureSeule.add((CaseDeJeuLectureSeule) caseDeJeu);
		}
		
		return casesDeJeuLectureSeule;
	}

	public int getIdColonne() {
		return idColonne;
	}

	public void setIdColonne(int idColonne) {
		this.idColonne = idColonne;
	}

	public boolean siPossibleJouerIci(int hauteur) {
		J.appel(this);

		return casesDeJeu.size() < hauteur;
	}

	public void apresChargementJson() {
		J.appel(this);
		
		for(int indiceRangee = 0; indiceRangee < casesDeJeu.size(); indiceRangee++) {
			CaseDeJeu caseDeJeu = casesDeJeu.get(indiceRangee);
			caseDeJeu.setIndiceColonne(idColonne);
			caseDeJeu.setIndiceRangee(indiceRangee);
		}
	}
	
}
