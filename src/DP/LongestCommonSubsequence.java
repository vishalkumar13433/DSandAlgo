package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		
		int lcs = findLCS(str1, str2 , str1.length() , str2.length());
		System.out.println(lcs);
		
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		lcs = findLCSDP(str1, str2 , str1.length() , str2.length() , dp);
		System.out.println(lcs);
		lcs = findLCSDPBottomUp(str1 , str2 , str1.length() , str2.length());
		System.out.println(lcs);
	}

	private static int findLCSDPBottomUp(String str1, String str2, int length, int length2) {
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<dp.length ; i++) {
			dp[i][0] = 0;
		}
		for(int i=0;i<dp[0].length ; i++) {
			dp[0][i] = 0;
		}
		
		for(int i=1 ; i< dp.length ; i++) {
			for(int j=1 ; j< dp[0].length ; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					dp[i][j] = Integer.max(dp[i-1][j] , dp[i][j-1]);
				}
			}
		}
		System.out.println("------------");
		for(int i=0;i<dp.length;i++) {
			System.out.println();
			for(int j=0 ; j< dp[0].length;j++) {
				System.out.print(dp[i][j] + " ");
			}
		}
		System.out.println("------------");
		return dp[length][length2];
		
	}

	private static int findLCSDP(String str1, String str2, int m, int n, int[][] dp) {
		if(m == 0 || n==0)
			return 0;
		if(dp[m][n] != -1) return dp[m][n];
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			dp[m][n] = 1+ findLCS(str1, str2, m-1, n-1);
		}else {
			dp[m][n] = Integer.max(findLCS(str1, str2, m-1, n), findLCS(str1, str2, m, n-1));
		}
		return dp[m][n];
	}

	private static int findLCS(String str1, String str2, int m, int n) {
		//if any one is empty string , no LCS
		if(m == 0 || n == 0) return 0;
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return 1 + findLCS(str1,str2,m-1,n-1);
		}
		return Integer.max(findLCS(str1,str2,m,n-1), findLCS(str1,str2,m-1,n));
	}

}
