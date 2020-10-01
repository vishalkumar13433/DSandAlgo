package DP;

import java.util.Arrays;

public class WildCardPatternMatching {

	 public static void main(String args[]) 
	    { 
	        String str = "baaabab"; 
	        String pattern = "*****ba*****ab"; 
	        // String pattern = "ba*****ab"; 
	        // String pattern = "ba*ab"; 
//	         String pattern = "a*ab"; 
	        // String pattern = "a*****ab"; 
	        // String pattern = "*a*****ab"; 
	        // String pattern = "ba*ab****"; 
	        // String pattern = "****"; 
	        // String pattern = "*"; 
	        // String pattern = "aa?ab"; 
//	         String pattern = "b*b"; 
	        // String pattern = "a*a"; 
	        // String pattern = "baaabab"; 
	        // String pattern = "?baaabab"; 
	        // String pattern = "*baaaba*"; 
	       
	        if (PatternMatch(str, pattern, str.length(), 
	                             pattern.length())) 
	            System.out.println("Yes"); 
	        else
	            System.out.println("No"); 
	    }

	private static boolean PatternMatch(String str, String pattern, int m, int n) {
		if( pattern.length() == 0 && str.length()==0)return true;
		else if(pattern.length() == 0 && str.length()!=0) return false;
		if(str.length() == 0 && pattern.length() == 1 && pattern.charAt(0) == '*') return true;
		boolean[][] dp = new boolean[m+1][n+1];
		for(int i=0;i<=m;i++)
			Arrays.fill(dp[i],false);
		dp[0][0] = true;
		for(int i=1;i<=n;i++) {
			if(pattern.charAt(i-1) == '*')
				dp[0][i] = dp[0][i-1];
		}
	
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(pattern.charAt(j-1) == '*'){
			// match * with current char  or remove *
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}else if(pattern.charAt(j-1) == '?' || pattern.charAt(j-1) == str.charAt(i-1)){
					dp[i][j] = dp[i-1][j-1];	//as ? matched with the character or characters matched
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[m][n];
	} 
}
