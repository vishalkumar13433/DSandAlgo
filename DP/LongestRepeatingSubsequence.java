import java.util.Arrays;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		String str = "aabebcdd"; 
        int m = str.length();
        int[][] dp = new int[m+1][m+1];
        for (int[] row : dp) { 
            Arrays.fill(row, -1); 
        } 
        System.out.println("The length of the largest subsequence that"
                + " repeats itself is : "
                + findLongestRepeatingSubSeq(str.toCharArray(), m, m , dp)); 
        System.out.println("The length of the largest subsequence that"
                + " repeats itself is : "
                + findLongestRepeatingSubSeqBottomUp(str.toCharArray(), m , dp)); 
	}

	private static int findLongestRepeatingSubSeqBottomUp(char[] str, int m, int[][] dp) {
		for (int[] row : dp) { 
            Arrays.fill(row, -1); 
        }
		for(int i=0;i<m;i++) {
			dp[i][0] = 0;
			dp[0][i] = 0;
		}
		for(int i= 1 ; i<=m;i++) {
			for(int j =1 ; j<=m;j++) {
				if(str[i-1] == str[j-1] && i != j) {
					dp[i][j] =  1 + dp[i-1][j-1];
				}else {
					dp[i][j] = Integer.max(dp[i-1][j] , dp[i][j-1]);
				}
			}
		}
		return dp[m][m];
	}

	private static int findLongestRepeatingSubSeq(char[] str, int m, int n, int[][] dp) {
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		if(m == 0 || n ==0) return 0;
		if(str[m-1] == str[n-1] && m != n) {
			dp[m][n] =  1 + findLongestRepeatingSubSeq(str, m-1, n-1, dp);
		}else {
			dp[m][n] = Integer.max(findLongestRepeatingSubSeq(str, m-1, n, dp), 
					findLongestRepeatingSubSeq(str, m, n-1, dp));
		}
		return dp[m][n];
	}
	
	
	
}
