package src.DP;

import java.util.Arrays;

public class MaxSubSquareMatrixWithAll1s {
	public static void main(String[] args)  
    { 
        int M[][] = {{0, 1, 1, 0, 1},  
                    {1, 1, 0, 1, 0},  
                    {0, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 1}, 
                    {0, 0, 0, 0, 0}}; 
              
        int res = maxSubSquare(M , M.length , M[0].length ); 
        System.out.print(res);
    }

	private static int maxSubSquare(int[][] m, int rows, int cols) {
		int[][] dp = new int[rows][cols];
		int max = 0;
		for(int i=0;i<cols;i++) {
			if(m[0][i] == 1) max= 1;
			dp[0][i] = m[0][i];
		}
		for(int i=0;i<rows;i++) {
			if(m[i][0] == 1) max= 1;
			dp[i][0] = m[i][0];
		}
		for(int i=1; i< rows ;i++) {
			for(int j=1;j<cols;j++) {
				if(m[i][j] == 0) {
					dp[i][j] = 0;
				}else {
					dp[i][j] = 1 + Integer.min(Integer.min(dp[i-1][j], dp[i][j-1]) , dp[i-1][j-1]);
					max = Integer.max(max, dp[i][j]);
				}
			}
		}
		return max;
	} 
}
