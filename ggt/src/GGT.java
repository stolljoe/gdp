/**
 * 
 */

/**
 * @author stolljoe
 *
 */
public class GGT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= Integer.parseInt(args[0]); 
		int b = Integer.parseInt(args[1]);
		if(a<0 || b <0) {		//Falls a oder b negativ sind (L18) gebe folgendes Statement (L19) und brich das Programm ab (L20)!
			System.out.println("nur positive Zahlen als Argumente erlaubt");
			System.exit(-1);
		}
		int h;
		int a1 = a; 			//setze a1 <- a
		int b1 = b; 			//setze b1 <- b
		while(b1!=0) { 			//solange b1 nicht 0 ist führe folgende Schleife aus
			h = a1 % b1; 		//h <- a1 mod b
			a1 = b1;	 		//a1 <- b1
			b1 = h;		 		//b1 <- h
		}
		System.out.println("ggT(" + a + ", " + b + ") = " + a1);	//Gib die Programmausgabe (ggT(a, b) = a1) aus
	}

}
