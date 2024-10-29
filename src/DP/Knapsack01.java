package src.DP;

import java.util.Arrays;

public class Knapsack01 {

	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
		 int[][] dp = new int[n+1][W+1]; 
		 for(int i=0;i<dp.length;i++) {
			 Arrays.fill(dp[i],-1);
		 }
		System.out.println(knapSackMemoized(W, wt, val, n, dp));
		System.out.println(knapSackDP(W, wt, val, n, dp));
	}

	private static int knapSackDP(int W, int[] wt, int[] val, int n, int[][] dp) {
		if(W ==0 || n==0) return 0;
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0]=  0;
		}
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=  0;
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(wt[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Integer.max(val[i-1]+ dp[i-1][j- wt[i-1]], dp[i-1][j]);
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

	private static int knapSackMemoized(int W, int[] wt, int[] val, int n, int[][] dp) {
		if(W ==0 || n==0) return 0;
		if(wt[n-1] > W) return knapSack(W, wt, val, n-1);
		if(dp[n][W] !=-1) return dp[n][W];
		dp[n][W] = Integer.max(val[n-1] + knapSackMemoized(W-wt[n-1], wt, val, n-1, dp), knapSackMemoized(W, wt, val, n-1 ,dp));
		return dp[n][W];
	}

	private static int knapSack(int W, int[] wt, int[] val, int n) {
		if(W ==0 || n==0) return 0;
		
		if(wt[n-1] > W) return knapSack(W, wt, val, n-1);
		
		return Integer.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
	}

}
