package DP;

public class maxProfitBySellingSharesKTimes {

	public static void main (String[] args)  
    { 
        int k = 3; 
        int price[] = {12, 14, 17, 10, 14, 13, 12, 15}; 
  
        int n = price.length; 
  
        System.out.println("Maximum profit is: " +  
                            maxProfit(price, n, k)); 
    }

	private static int maxProfit(int[] price, int n, int k) {
		int[][] dp = new int[k+1][price.length];
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		} 
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i] = 0;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				int maxTransactionForDay= 0;
				for(int m=0;m<j;m++) {
					maxTransactionForDay = Integer.max(maxTransactionForDay,price[j]- price[m] + dp[i-1][m]);
				}
				dp[i][j] = Integer.max(dp[i][j-1], maxTransactionForDay);
			}
		}

		System.out.println("-------------");
		for(int i=0;i<dp.length;i++) {
			System.out.println();
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j] + " ");
			}
		}
		System.out.println("-------------");
		
		return dp[k][price.length-1];
		
	}  
	
}
