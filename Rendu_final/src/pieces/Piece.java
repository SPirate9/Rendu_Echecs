package pieces;

import echecs.Echiquier;
import echecs.IPiece;

public abstract class Piece implements IPiece{
	private char piece;
	private char lettre;
	private char chiffre;
	private boolean isWhite;
	
	public Piece(char piece, char lettre,char chiffre, boolean isWhite) {
		if(isWhite) {
			piece=java.lang.Character.toUpperCase(piece);
		}
		this.piece=piece;
		this.lettre=lettre;
		this.chiffre=chiffre;
		this.isWhite=isWhite;
	}
	public boolean isWhite() {
		return this.isWhite;
	}
	public char getPiece(){
		return this.piece;
	}
	public void setPiece(char piece){
		this.piece=piece;
	}
	public char getLettre(){
		return this.lettre;
	}
	public char getChiffre(){
		return this.chiffre;
	}
	public void setLettre(char lettre){
		this.lettre=lettre;
	}
	public void setChiffre(char chiffre){
		this.chiffre=chiffre;
	}
	public int getposX(){
		return 8-((int)chiffre-48);
	}
	
	public int getposY(){
		return (int)lettre-97;
	}
//	public void moovePossible(char lettre,char chiffre) {
//
//	}
	public void isPossible(char lettre,char chiffre) {
 
	}
	public boolean moovePossible(Echiquier e,char lettre,char chiffre) {
		System.out.println("dans piece");
		return true;
	}
	public String moovePossibleErreur() {
		return "piece erreur";
	}
}
