package DP;

import java.util.Arrays;

public class longestPalindromicSubsequence {

	public static void main(String[] args) { 
        String seq = "GEEKSFORGEEKS"; 
        int n = seq.length(); 
        System.out.printf("The length of the LPS is %d", lps(seq.toCharArray(), 0, n - 1)); 
        int[][] dp = new int[n][n];
        for(int i=0;i<dp.length;i++) {
        	Arrays.fill(dp[i], -1);
        }
        System.out.printf("The length of the LPS using Memoization is %d", lpsDPMemo(seq.toCharArray(), 0, n - 1 , dp));
        System.out.printf("The length of the LPS using DP is %d", lpsDP(seq.toCharArray() , dp));
	}

	private static int lpsDP(char[] str , int[][] dp) {
		int start = 0 , end = str.length-1;
		if(start == end) return 1;
		if(start == end-1 && str[start] == str[end]) return 2;
		
		for(int i=0;i<dp.length ; i++) {
			dp[i][i] = 1;
		}
		
		for(int sublen=2;sublen<str.length;sublen++) {
			for(int i=0;i < str.length - sublen + 1 ; i++) {
				int j = sublen+i-1;
				if(str[i] == str[j] && sublen==2) 
					dp[i][j]= 2;
				else if (str[i] == str[j] )
					dp[i][j] = 2+dp[i+1][j-1];
				else
					dp[i][j] = Integer.max(dp[i+1][j] , dp[i][j-1]);
			}
		}
		return dp[0][str.length-1];
	}

	private static int lpsDPMemo(char[] str, int start, int end, int[][] dp) {
		if(start > end) return 0;
		if(start == end) return 1;
		if(start == end-1 && str[start] == str[end]) return 2;
		
		if(dp[start][end] != -1) return dp[start][end];
		
		if(str[start] == str[end]) 
			dp[start][end] = 2+ lpsDPMemo(str, start+1, end-1 , dp);
		else
			dp[start][end] = Integer.max(lpsDPMemo(str, start+1, end, dp) , lpsDPMemo(str, start, end-1, dp));
		return dp[start][end];
	}

	private static int lps(char[] str, int start, int end) {
		if(start > end) return 0;
		if(start == end) return 1;
//		if(start == end-1 && str[start] == str[end]) return 2;
		if(str[start] == str[end]) 
			return 2+ lps(str, start+1, end-1);
		return Integer.max(lps(str, start+1, end) , lps(str, start, end-1));
	}
}
