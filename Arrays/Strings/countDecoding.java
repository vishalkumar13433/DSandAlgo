package Strings;

import java.util.Arrays;

public class countDecoding {

	public static void main(String[] args) {
		char digits[] = {'1', '2', '3', '4'}; 
	    int n = digits.length; 
	    System.out.printf("Count is %d", countDecodingNumber(digits, n)); 
	    System.out.println();
	    int[] dp = new int[n+1];
	    System.out.printf("Count is %d", countDecodingNumberDP(digits, n , dp)); 
	}

	private static int countDecodingNumberDP(char[] digits, int n, int[] dp) {
	    Arrays.fill(dp, 0);
		dp[0] = 1;
	    dp[1] = 1;
	    for(int i=2;i<=n;i++) {
	    	if(digits[i-1] > '0') {
				dp[i] = dp[i-1]; //that character 
				//will be appended after all such combinations
			}
			if(digits[i-2] == '1' || (digits[i-2] == '2' && digits[i-1] < '7'))
				dp[i] += dp[i-2];
	    }
	    return dp[n];
	}

	private static int countDecodingNumber(char[] digits, int n) {
		if(n==0 || n==1) return 1; //empty string or 1 character has 1 mapping
		
		int count = 0;
		if(digits[n-1] > '0') {
			count = countDecodingNumber(digits, n-1); //that character 
			//will be appended after all such combinations
		}
		if(digits[n-2] == '1' || (digits[n-2] == '2' && digits[n-1] < '7'))
			count += countDecodingNumber(digits,n-2);
		return count;
	}

}
