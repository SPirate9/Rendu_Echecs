package echecs;

import java.util.Scanner;

import ihm.IHM;
import pieces.Dame;
import pieces.Roi;

public class Main {

	public static void main(String[] args) {

	
		Echiquier e = new Echiquier(8,8);
		Roi rW = new Roi('e','1',true);
		Roi rB = new Roi('e','8',false);
		Dame dW = new Dame('d','1',true);
		Dame dB = new Dame('d','8',false);
		e.insertPiece(rW);
		e.insertPiece(rB);
		e.insertPiece(dW);
		e.insertPiece(dB);
		IHM.affiche(e);
		while( !e.partieFinie() ) {
			try{
	            Scanner sc = new Scanner(System.in);
	            System.out.print("Veuillez saisir votre prochain coup: ");
	            String coup = sc.next("[a-h]+[1-8]+[a-h]+[1-8]" );
	            e.moovePiece(coup.charAt(0),coup.charAt(1),coup.charAt(2),coup.charAt(3));
	            IHM.affiche(e);
	        } catch(Throwable a){
	        	if(a.toString()=="java.util.InputMismatchException") {
	        		System.out.println("Veuillez entrer 4 caract�res de la forme lettre(a-h) chiffre(1-8) lettre(a-h) chiffre(1-8)");
	        	}else {
	        		System.out.println(a.getMessage());
	        	}
	        }
		}
		System.out.println("Felicitation vous avez gagné");
	 

	}
}







