/**
 * 
 */

/**
 * @author stolljoe
 *
 */
public class Wuerfel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]); 	//Würfel mit N Seiten
		int K = Integer.parseInt(args[1]); 	//Anzahl an Wiederholungen zum Gewinn
		double S = Integer.parseInt(args[2]); 	//Anzahl der Spiele
		double  p;
		int ca=0;
		double wonint=0;
		double prop =0;
		for (int i = 0;i<S;i++) { 			//Anz. Spiele
			p= Math.random() * N;			//Ausführen eines Spiels
			if (p >= N -1) {				//wenn den größten Wert (N-1) erreicht erhöhe ca um 1
				ca = ca +1;
				if (ca == K) {				// Wenn ca K Mal gewinnt gewinnt man das Spiel
					wonint=wonint +1;			// erhöhe Gewonnen auf ..+1
				}
			}
			else {
				ca =0;						// Falls nur max. K-1 mal hintereinander gewinnt setze ca wieder auf 0
			}
			
		}
		prop = S / wonint;					// Teile S durch wonint um die Druchschnittliche Spiellänge zu berechnen
		System.out.println(prop);			// gebe die Durchschnittl. Spiellänge aus
		
	}

}
