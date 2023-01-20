package ihm;
import echecs.Echiquier; 

public class IHM {
	public static void affiche(Echiquier e) {
		int tabLenX = e.getTabLenX();
		int tabLenY = e.getTabLenY();
		
		System.out.println(lettres(tabLenX));
		
		ligne(e,tabLenX,tabLenY);
		
		System.out.println(traits(tabLenX));
		System.out.println(lettres(tabLenX));
	}
	
	public static String lettres(int tabLenX) {
		String lettres="    "; // initialisation de la chaine des lettres avec espace pour aligner
		
		for (int i=0;i<tabLenX;++i){
			lettres+=(char)(i+97)+"   "; // (char)97 = 'a'
				}
		return lettres;
	}
	
	public static String traits(int tabLenX) {
		String traits = "  ";
		int x=0;
		while(x <tabLenX) {
			traits += " ---";
			++x;
		}
		return traits;
	}
	
	public static void ligne(Echiquier e, int tabLenX, int tabLenY) {
		String ligne = "";
		for (int i=0;i<tabLenY;++i){
			System.out.println(traits(tabLenX));
			ligne += tabLenY-i+" | ";
			for (int j=0;j<tabLenX;++j) {
				if(e.getTab()[i][j]!=null) {
					ligne += e.getTab()[i][j].getPiece()+" | ";
				}
				else {
					ligne += " "+" | ";
				}
			}
			System.out.println(ligne+(tabLenY-i));
			ligne = "";
		}
	}
}
