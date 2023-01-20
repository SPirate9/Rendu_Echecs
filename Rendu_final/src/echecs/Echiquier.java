package echecs;
import pieces.Piece;

public class Echiquier {
	private IPiece[][] tab; //tableau 2 dimension avec les pieces dedans
	private int tabLenX; 
	private int tabLenY;
	private int nbCoup=0;
	private boolean partieFinie=false;
	
	public Echiquier(int a, int b) { //creer tableau vide 
		this.tab=new IPiece[a][b]; 
		this.tabLenX = this.tab[0].length;
		this.tabLenY = this.tab.length;
		for (int i=0;i<tabLenY;++i){
			for (int j=0;j<tabLenX;++j) {
				this.tab[i][j]=null;
			}
		}
	}
	public IPiece[][] getTab(){
		return this.tab;
	}
	
	public int getTabLenX(){
		return this.tabLenX;
	}
	
	public int getTabLenY(){
		return this.tabLenY;
	}


	public static int posX(char chiffre){
		return 8-((int)chiffre-48);
	}
	
	public static int posY(char lettre){
		return (int)lettre-97;
	}
	public static char toChiffre(int posX){
		return (char)(posX+48);
	}
	
	public static char toLettre(int posY){
		return (char)(posY+97);
	}
	public boolean caseExist(char lettre, char chiffre) {
		return (posX(chiffre)>=0 && posX(chiffre)<8 && posY(lettre)>=0 && posY(lettre)<8);
	}
	
	public IPiece getCase(char lettre, char chiffre) {
		assert( caseExist(lettre,chiffre)) :"La case "+lettre+chiffre+" n'existe pas";
		assert (!this.estVide(lettre, chiffre)) : "(get)case "+lettre+chiffre+" ne contient pas de piece";
		return this.tab[posX(chiffre)][posY(lettre)];
	}
	public void insertPiece(IPiece piece) {
		assert( caseExist(piece.getLettre(),piece.getChiffre())) :"La case "+piece.getLettre()+piece.getChiffre()+" n'existe pas";
		assert (this.estVide(piece.getLettre(), piece.getChiffre())) : "(insert)case "+piece.getLettre()+piece.getChiffre()+" non vide";
		this.tab[posX(piece.getChiffre())][posY(piece.getLettre())]=piece;
	}
	public boolean estVide(char lettre, char chiffre) {
		assert( caseExist(lettre,chiffre)) :"La case "+lettre+chiffre+" n'existe pas";
		return this.tab[posX(chiffre)][posY(lettre)]==null;
	}
	public void moovePiece(char lettre,char chiffre,char newLettre,char newChiffre) {
//		assert( caseExist(lettre,chiffre)) :"La case "+lettre+chiffre+" n'existe pas";
//		assert( caseExist(newLettre,newChiffre)) :"La case "+lettre+chiffre+" n'existe pas";
		assert (!this.estVide(lettre, chiffre)) : "la case de depart "+lettre+chiffre+" ne contient pas de piece";
		IPiece piece=getCase(lettre,chiffre);
		assert((nbCoup%2==0)==piece.isWhite()): "Ce n'est pas votre piece";
		assert( piece.moovePossible(this,newLettre, newChiffre)) :
			piece.moovePossibleErreur();
		assert (this.estVide(newLettre, newChiffre)||(!this.estVide(newLettre, newChiffre) && this.peutManger(lettre, chiffre, newLettre, newChiffre))) : 
			"la case de darrivée "+newLettre+newChiffre+" est occupee par une de vos pieces";
		this.tab[posX(chiffre)][posY(lettre)]=null;
		this.tab[posX(newChiffre)][posY(newLettre)]=null;
		piece.setLettre(newLettre);
		piece.setChiffre(newChiffre);
		this.insertPiece(piece);
		++this.nbCoup;
		
	}
	private void moovePieceAssert() {
		
	}
	public boolean peutManger(char lettre,char chiffre,char newLettre,char newChiffre) {
		IPiece pieceDepart=getCase(lettre,chiffre);
		IPiece pieceArrive=getCase(newLettre,newChiffre);
		if(pieceDepart.isWhite()!= pieceArrive.isWhite()) {
			this.partieFinie = java.lang.Character.toUpperCase(pieceArrive.getPiece())=='R';
			return true;
		}
		return false;
	}
	public boolean partieFinie() {
		return this.partieFinie;
	}
}
