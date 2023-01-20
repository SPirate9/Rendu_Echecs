package pieces;

import echecs.Echiquier;
import echecs.IPiece;

public class Roi extends Piece {

	public Roi(char lettre, char chiffre, boolean isWhite) {
		super('r', lettre, chiffre, isWhite);
	}
	
	public boolean moovePossible(Echiquier e,char lettre, char chiffre) {
		assert(this.pasDeRoi(e, lettre, chiffre)): 
			"Il doit toujours y avoir une case entre les deux Rois.";	
		assert(this.pasEchec(e, lettre, chiffre)):
			"Le Roi ne peut pas se mettre en echec";
		return (Math.abs(this.getChiffre()-chiffre)<=1 && Math.abs(this.getLettre()-lettre)<=1);
//		assert(Math.abs(this.getChiffre()-chiffre)<=1 && Math.abs(this.getLettre()-lettre)<=1): 
//			"Le Roi se déplace, de case en case, dans toutes les directions";

		
	}	
	public String moovePossibleErreur() {
		return "Le Roi se déplace, de case en case, dans toutes les directions";
	}
	public boolean pasDeRoi(Echiquier e,char lettre,char chiffre) {
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				char NewLettre=Echiquier.toLettre(Echiquier.posY(lettre)+i);
				char NewChiffre=Echiquier.toChiffre(8-Echiquier.posX(chiffre)+j);
				if( (NewLettre!=this.getLettre() || NewChiffre!=this.getChiffre()) && e.caseExist(NewLettre,NewChiffre) && !e.estVide(NewLettre, NewChiffre) && java.lang.Character.toUpperCase(e.getCase(NewLettre, NewChiffre).getPiece())=='R') {
					return false;
				}
			}
		}
		return true;  
	}
	public boolean pasEchec(Echiquier e,char lettre, char chiffre) {
		for (int i=0;i<e.getTab().length;++i){
			for (int j=0;j<e.getTab().length;++j) {
				if(e.getTab()[i][j]!=null && e.getTab()[i][j].isWhite()!=this.isWhite() && java.lang.Character.toUpperCase(e.getTab()[i][j].getPiece())!='R') {
					IPiece piece = e.getTab()[i][j];
					System.out.println(piece.getPiece());
					if(piece.moovePossible(e, lettre, chiffre)) {
						return false;
					}
				}
			}
		}
		return true;

	}
}
