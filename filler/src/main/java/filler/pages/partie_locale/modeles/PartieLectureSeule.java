
package filler.pages.partie_locale.modeles;

import ntro.mvc.modeles.ModeleLectureSeule;

public interface PartieLectureSeule 
       extends   ModeleLectureSeule {
	
	 GrilleLectureSeule getGrille();
	 int getLargeur();
	 int getHauteur();
}
