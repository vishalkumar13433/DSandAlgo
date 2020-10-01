package ImpQuestion;

public class SieveofEratosthenes {

	 public static void main(String args[]) 
	    { 
	        int n = 20; 
	        System.out.print("Following are the prime numbers "); 
	        System.out.println("smaller than or equal to " + n); 
	        SieveofEratosthenes g = new SieveofEratosthenes(); 
	        g.sieveOfEratosthenes(n); 
	    }

	private void sieveOfEratosthenes(int n) {
		boolean[] sieve=new boolean[n+1];	//all elements are false by Default
		
		for(int i=2;i*i<=n;i++)
		{
			if(sieve[i]==false)
			{
				for(int j=2;i*j<=n;j++)
				{
					sieve[i*j]=true;
				}
			}
		}
		
		for(int i=2;i<n;i++)
		{
			if(sieve[i]==false)
				System.out.print(i + " ");
		}
	} 

}
