package DP;

public class subsetSum {

	public static void main (String args[]) 
    { 
        int set[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9; 
        int n = set.length; 
        if (isSubsetSum(set, n-1, sum)) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 
        
        
        if (isSubsetSumDP(set, n-1, sum)) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum");
        
    }

	private static boolean isSubsetSumDP(int[] set, int n, int sum) {
		boolean[][] dp = new boolean[n+1][sum+1];
		if(n<0)
			return false;
		if(sum==0) return true;
		
		dp[0][0] = true; // basically , you can make sum0 with no elements (TRUE)
		for(int i=1;i<=n;i++) {
			dp[i][0] = true;
			dp[0][i] = false;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(j < set[i-1]) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j- set[i-1]] || dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
		
	}

	private static boolean isSubsetSum(int[] set, int n, int sum) {
		
		if(sum <0 ||n <= 0) return false;
		if(sum ==0 || set[n] == sum ) return true;
		
		return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum - set[n]);
	} 
	
}
