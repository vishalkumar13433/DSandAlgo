

import java.util.Arrays;

public class EditDistance {
	
	 public static void main(String args) 
	    { 
	        String str1 = "horse"; 
	        String str2 = "ros"; 
	   
	        System.out.println( editDist( str1 , str2 , str1.length(), str2.length()) ); 
	        int[][] dp = new int[str1.length()+1][ str2.length()+1];
	        for(int i=0;i<=str1.length();i++) {
		        Arrays.fill(dp[i], -1);
	        }
	        System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length() , dp) );
	        
	        System.out.println("--------------");
	        for(int i=0;i<dp.length;i++) {
	        	System.out.println();
	        	for(int j=0;j<dp[0].length;j++) {
	        		System.out.print(dp[i][j] + " " );
	        	}
	        }
	        System.out.println("--------------");
	        
	    }

	private static int editDistDP(String str1, String str2, int m, int n, int[][] dp) {
		/*if(m == 0) return n;
		if(n==0) return m;
		
		if(dp[m][n] != -1) return dp[m][n];
		
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			dp[m][n] = editDistDP(str1 , str2 , m-1 , n-1 , dp);
		} else {
			dp[m][n] = 1 + min(editDistDP(str1, str2, m-1, n , dp),//insert a char
					editDistDP(str1, str2, m, n-1 ,dp), // remove a char
					editDistDP(str1, str2, m-1, n-1 , dp)//replace
					);
		}*/
		
		for(int i=1;i<dp.length;i++) {
			dp[i][0]= i;
		}
		
		for(int i=1;i<dp[0].length;i++) {
			dp[0][i] = i;
		}
		
		dp[0][0] = 0;
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = 1 + min(dp[i-1][j-1] , dp[i-1][j] , dp[i][j-1]);
				}
			}
		}
		
		return dp[m][n];
	}

	private static int editDist(String str1, String str2, int m, int n) {
		if(m == 0) return n;
		if(n == 0) return m;
		
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return editDist(str1 , str2 , m-1 , n-1);
		}
		return 1 + min(editDist(str1, str2, m-1, n),//insert a char
				editDist(str1, str2, m, n-1), // remove a char
				editDist(str1, str2, m-1, n-1)//replace
				);
		
	} 
	
	private static int min(int a, int b, int c) {
		return Integer.min(a, Integer.min(c, b));
	}
	
}
