package DP;

import java.util.Arrays;

public class longestIncreasingSubsequence {
	static int lis;
	public static void main(String[] args) {
		int arr[]=new int[] {3,4,-1,0,6,2,3};
//		int arr[] = {50, 3, 10, 7, 40, 80};
	     int n = arr.length; 
	     lis = 1;
	     longIncSubSeq(arr, n);
	     System.out.println("Length of lis is " + lis + "\n"); 
	     System.out.println("Length of lis is " + longIncSubSeqDP( arr, n ) + "\n" ); 
	     
	}

	private static int longIncSubSeqDP(int[] arr, int n) {
		
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);	//every element represents LIS as 1
		int maxLIS = dp[0];
		for(int i=1;i<n;i++) {
			int j=0;
			while(j<i) {
				if(arr[j] < arr[i]) {
					dp[i] = Integer.max(dp[i], 1 + dp[j]);
					if(dp[i] > maxLIS) maxLIS = dp[i];
				}
				j++;
			}
		}
		return maxLIS;
	}

	private static int longIncSubSeq(int[] arr, int n) {
		
		if(n == 1) return 1;
		int max_ending_here = 1;
		for(int i=1;i<n;i++) {
			int ls = longIncSubSeq(arr, i);
			if(arr[i-1] < arr[n-1] && 1+ls > max_ending_here) {
				max_ending_here = 1+ls;
			}
		}
		if(max_ending_here > lis) {
			lis = max_ending_here;
		}
		return max_ending_here;
	}

	
	
	
}
