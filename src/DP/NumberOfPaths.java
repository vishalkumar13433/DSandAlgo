package src.DP;

import java.util.Arrays;

public class NumberOfPaths {

	public static void main(String[] args) {
		int m=3;
		int n=3;
		
		int pathsCount = numberPaths(m,n);
		System.out.println("Number of Paths:" + pathsCount);
		
		int[][] dp = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			  Arrays.fill(dp[i], -1);
		}
		pathsCount = numberPathsDP(m,n,dp);
		System.out.println("Number of Paths Using DP:" + pathsCount);
	}

	private static int numberPathsDP(int m, int n, int[][] dp) {
		if(m==1 || n==1)
			return 1;		
		if(dp[m][n] != -1) return dp[m][n];
		dp[m][n] =numberPaths(m, n-1) + numberPaths(m-1, n);
		return  dp[m][n];
	}

	private static int numberPaths(int m, int n) {
		if(m==1 || n==1)
			return 1;
		return numberPaths(m, n-1) + numberPaths(m-1, n);
	}

}
