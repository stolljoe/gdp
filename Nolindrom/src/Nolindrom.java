/**
 * 
 */

/**
 * @author stolljoe
 *
 */
public class Nolindrom {

	/**
	 * @param args
	 */
	public static long Nolin(long N) 
	{
		long Noli=0;
		long R=0; //
		long P = 0;
		long j =10;
		long Pu =0; //Puffer
		long Pfin =0;
		long stellen=0;
		long power= 1;
		long[] NAR = new long[101];
		NAR[0] = N;
		for(int g=0; g < 100;g++) 
		{
			stellen = stellen(NAR[g]);
			j=10;
			for(int l =1;j<NAR[g]*10;l++) // N mod 0 , N mod 10, N mod 100...
				{
				Pu = P + Pu; // akkumuliere den Puffer über die Schleife
				P = (NAR[g] % j - Pu); //
				Pfin = P*10/j;
				//System.out.println("N % j = " + P  +" Puffer " + Pu);
				//System.out.println("Pfin= "+ Pfin + " j: "+ j);
				for(long h =0;h< stellen -l ; h++) // calculate the "reverse" power 
				{ 
					power = power *10;
				}
				//System.out.println("Power: "+ power);
				R = Pfin* power + R;
				j=j*10;
				power = 1;
				}
			if ((NAR[g]) > (Long.MAX_VALUE/2)) 
			{
				/*System.out.println( Long.MAX_VALUE );
				System.out.println(NAR[g]);
				System.o/vol/fob-vol4/mi17/stolljoe/workspaceut.println(Long.MAX_VALUE /2);
				System.out.println("Ueberlauf Iter= " + g);*/
				Noli=NAR[0];
				break;
			}
			//else System.out.println("N+R= "+ (NAR[g]+R) + " g= "+ g);
			if(NAR[g]==R) 
			{
				//System.out.println("Palindrom= "+ NAR[g]);
				//if(g!=1)System.out.println("Fertig nach "+ g +" Iterationen");
				//else System.out.println("Fertig nach einer Iteration");
				break;
			}
			/*else {
			if(g != 0) System.out.println(" kein Palindrom, ");
			System.out.print("N= "+ NAR[g] + " R= "+ R +" Summe= "+ (NAR[g]+R));
			}*/
			if(g==99) 
			{ 
				//System.out.println("Nolindrom= " + NAR[0]);
				Noli=NAR[0];
			}
			
			
			NAR[g+1]= NAR[g]+R;
			//System.out.println( "Iter= "+g+ " N= "+NAR[g]+" R= "+R +" N+R=  " + NAR[g+1]);
			Pfin=0;
			power=1;
			stellen=0;
			P=0;
			R=0;
			j=10;
			Pu=0;
		}
		return Noli;
	}
	public static void main(String[] args) 
	{
			long limit;
			long N;
			limit = Long.parseLong(args[0]);
			for(long i=limit;i > 0; i--) 
			{
				N=Nolin(i);
				//System.out.println("Stellen von N= "+i+", "+stellen(i));
				if(N!=0) 
				{
					System.out.println(N);
				}
			}
			
				
	}
	public static long stellen(long N)
	{
		long n=0;
		long i=1;
		long sub=0;
		while(sub>=0) // berechne wie viele Stellen N hat
		{
			sub = N-i;	//aktualisiere die Var. stellen bei jedem Schleifendurchlauf mit i
			i*=10;
			n++;
		}
		return n-1;
	}
	

}
