/**
 * 
 */

/**
 * @author stolljoe
 *
 */
public class Caesar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int l = args.length; // Wie viele Nachrichten bekommt das Programm
		int K = Integer.parseInt(args[0]); //Schlüssel K
		char[] origlow = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] origup = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for (int i=1;i<l;i++) { // Schleife durch Nachrichten 1 bis N
			String N = args[i]; 	//Nachricht 1 als String
			char[] Nc = new char[N.length()];
			Nc = N.toCharArray();
			N.toCharArray(); //Nachricht Nr. i als Array
			for (int h=0;h<Nc.length;h++) { // Schleife durch die Chars in der Nachricht
				for (int j=0;j<origlow.length;j++) { // Schleife durch das Alphabet
					if(Nc[h] == origlow[j]) {		// Fall 1: Nc[h] is lowercase
						if (j+K < 0) {				//Falls j+k kleiner als 1 können wir nicht mit modulo rechnen
							Nc[h]=origlow[origlow.length+(j+K)];	//Verstausche den Buchstaben Nc[h] mit 26+(j+k)
						}
						else {
							Nc[h]=origlow[(j+K) % origlow.length]; // sonst wie in Line 32 nur mit modulo statt Minus
						}
						break; 									// exit for loop
					}
					if(Nc[h] == origup[j]) {     // Fall 2: Analog zu Line 30 bis 38 nur als Großbuchstaben
						if (j+K < 0) {
							Nc[h]=origup[origup.length+(j+K)];
						}
						else {
							Nc[h]=origup[(j+K) % origup.length];
						}
						//System.out.println((j+K)%26);
						//System.out.print(Nc[h] + " ");
						break;
					}
				}
				System.out.print(Nc[h]); //Gebe den verschlüsselten Buchstaben aus
			}
			System.out.print("\n"); // Newline
		}
	}
}
