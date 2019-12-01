/**
 * 
 */

/**
 * @author stolljoe
 *
 */
public class PrimeUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int p= Integer.parseInt(args[0]);
		if(args.length == 2) { // If there are 2 args take the second one as q 
			int q = Integer.parseInt(args[1]);
			
		}
		int[] Primes;
		//boolean o;						//for testing isPrime(..)
		//o= isPrime(p);
		//System.out.println("ISPRIME= "+o);// end testing isPrime
		int[] selection = new int[1000];
		for(int i=0;i<selection.length;i++) selection[i]= i;
		Primes = getFirstPrimes(p);
		if(args.length == 2) { // If there are 2 args take the second one as q 
			int q = Integer.parseInt(args[1]);
			Primes=getPrimesBetween(p, q,selection);
		}
		for(int i=0; i < Primes.length;i++) //PRINT Primes array
		{
			System.out.println(i+" "+Primes[i]);
		}
		int randomPrime = getRandomPrimeFrom(Primes);
		System.out.println("randomPrime= "+randomPrime);
	}
	public static int getRandomPrimeFrom(int[] selection)
	{	
		int randomPrime = 0;
		int k =0;
		for(int i=0; i< selection.length;i++) // lookup of how many Primes we have in selection
		{
			if(isPrime(selection[i])) k++;
		}
		if(k==0) return -1;
		int[] primeselection = new int[k];
		int rand = (int) (Math.random()*primeselection.length);
		int l =0;
		for(int i=0; i< selection.length;i++)
		{
			if(isPrime(selection[i])) 
			{
				primeselection[l]=selection[i];	// If Prime is in selection[i] is Prime Then copy it into primeselection
				l++;
			}
		}
		randomPrime = primeselection[rand]; // get a random number from that array
		return randomPrime;	 // return random Number from Array primeselection
	}
	public static int[] getPrimesBetween(int limita, int limitb, int[] selection) // selection is the array of numbers we pick our primes from
	{
		int[] returnarray;
		int[] allprimesbtw = getPrimesBetween(limita,limitb); //first we want all Primes in between limita and limitb
		
		//Lookup of how many Primes are in allprimesbtw /\ selection
		int k=0; //k is counting the Lookup
		for(int i=0;i<allprimesbtw.length;i++) // with this loop we go over allprimesbtw
		{
			for(int j=0; j< selection.length;j++)
			{
				if(allprimesbtw[i]==selection[j]) k++;
			}
			
		}
		returnarray = new int[k]; // create a array with the size k (number of matches)
		k=0;
		for(int i=0;i<allprimesbtw.length;i++) // with this loop we go over allprimesbtw
		{
			for(int j=0; j< selection.length;j++)
			{
				if(allprimesbtw[i]==selection[j])
				{
					returnarray[k]= selection[j];
					k++;
				}
			}
			
		}
		System.out.println("we have "+k+" matches!");
		return returnarray;
	}
	
	public static int[] getPrimesBetween(int limita, int limitb)
	{
		int[] Primes= getFirstPrimes(limitb); //Frist get all Primes smaller than limitb then sort out the primes smaller than limita
		int z=0; //iterator that counts up if Primes[i] < limita
		for(int i=0;i<Primes.length;i++) // Check at what point the primes are bigger than limita
		{
			if(Primes[i]>limita) {
				break;
			}
			else z++;
		}
		System.out.println("z= "+z); // we have the delete the first z Elements of Primes[]..
		int N;
		N = Primes.length -z; // N is out new size of Primes[]
		System.out.println("N= "+N);
		int[] Primesbtw = new int[N];
		for(int i=0;i<Primesbtw.length;i++) // Now lets copy the old array wihtout the uneeded element into our new array Primesbtw
		{
			Primesbtw[i]=Primes[i+z];
		}
		return Primesbtw;
	}
	
	public static int[] getFirstPrimes(int limit) 
	{
		int N=0; // Number of primes we are getting 
		for(int i=2;i<limit;i++) // Lookup of how many Primes we get
		{
			if(isPrime(i))  // If i Prime count N one up
			{
				N++;
				//System.out.println("isPrime= "+ i+ " Number of Primes= "+N);
			}
		}	//EndOf Lookup
		//System.out.println(N);
		int[] firstprimes = new int[N]; // Now we can declare our array
		int k=0; // k is the pos in array
		
		for(int i=2;i<limit;i++) // 
		{
			if(isPrime(i))  // If i Prime count N one up
			{
				firstprimes[k]=i;
				//System.out.println("isPrime= "+firstprimes[k]);
				k++;
			}
		}	//EndOf Lo
		return firstprimes;
	}
	
	public static boolean isPrime(int p) //WORKS & TESTED
	{
		int l;
		if(p<2) return false; // 0 and 1 are not prime, everything <0 is also not prime as well
		else
		{
			for(int i=2;i < p; i++) 
			{
				//System.out.println("i ="+i); //Check if for loop is correct
				l= p%i; // If l is 0 that means that p can be divided with i 
				//System.out.println(l);
				if(l==0) return false; // Then return false
			}
		}
		return true;
	}

}
