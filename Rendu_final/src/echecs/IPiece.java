package echecs;

public interface IPiece {

	public boolean isWhite();
	public char getPiece();
	public void setPiece(char piece);
	public char getLettre();
	public char getChiffre();
	public void setLettre(char lettre);
	public void setChiffre(char chiffre);
	public int getposX();
	
	public int getposY();
//	public void moovePossible(char lettre,char chiffre) {
//
//	}
	public void isPossible(char lettre,char chiffre) ;
	public boolean moovePossible(Echiquier e,char lettre,char chiffre) ;
	public String moovePossibleErreur() ;

}
