package pieces;

import echecs.Echiquier;

public class Dame extends Piece {
	
	public Dame(char lettre, char chiffre, boolean isWhite) {
		super('d', lettre, chiffre, isWhite);
	}
	
	public boolean moovePossible(Echiquier e,char lettre, char chiffre) {
		return (lettre==this.getLettre()||chiffre==this.getChiffre()||lettre+this.getChiffre()==chiffre+this.getLettre()||((chiffre-this.getLettre())+(lettre-this.getChiffre()))==0);
//		assert(lettre==this.getLettre()||chiffre==this.getChiffre()||lettre+this.getChiffre()==chiffre+this.getLettre()||((chiffre-this.getLettre())+(lettre-this.getChiffre()))==0): 
//			"Le Dame se déplace horizontalement, verticalement et en diagonale";
		
	}
	public String moovePossibleErreur() {
		return "Le Dame se déplace horizontalement, verticalement et en diagonale";
	}
}
