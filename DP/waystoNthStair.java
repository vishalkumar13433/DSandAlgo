

public class waystoNthStair {

	 public static void main (String args[]) 
	    { 
	          int n = 4; 
	          System.out.println("Number of ways = "+ countWays(n)); 
	    
	          //Generalized Problem
	          int steps = 3; //1,2,3 steps at a time
	          System.out.println("Number of ways = "+ countWaysGeneral(n , steps));
	    
	          System.out.println("Number of ways = "+ countWaysGeneralDP(n , steps));
	    }

	 private static int countWaysGeneralDP(int n, int steps) {
		 int res[] = new int[n+1]; 
		 res[0] = 0;
		 res[1] = 1;
		 for(int i=2;i<=n;i++) {
			 res[i] = 0;
			 for(int j=1; j<=steps && j <=i;j++) {
				 res[i] += res[i-j]; 
			 }
		 }
		 return res[n];
	 }

	private static int countWaysGeneral(int n, int steps) {
		if(n <= 1) return n;
		int ways = 0;
		for(int i=1;i<=steps && i<=n;i++) {
			ways += countWaysGeneral(n-i , steps);
		}
		return ways;
	}

	//This is Fibonacci Function . that we already know how to solve
	private static int countWays(int n) {
		if(n <=2) return n;
		return countWays(n-1) + countWays(n-2);
	} 
	
}
