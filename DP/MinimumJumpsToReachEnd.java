

import java.util.Arrays;

public class MinimumJumpsToReachEnd {
	static int cnt = 0;
	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }; 
//		int arr[] = {5,9,3,2,1,0,2,3,3,1,0,0};
//		int arr[] = {3,2,1,0,4};	//Not Possible
		int n = arr.length;
		System.out.println("Minimum number of jumps to reach the end is :" + minJumps(arr, n)); 
		System.out.println("called:" + cnt + " times");
		cnt=0;
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println("Minimum number of jumps to reach the end Using Memoization is :" + minJumpsMemo(arr, n , dp)); 
		System.out.println("called:" + cnt + " times");
		System.out.println("------------");
		for(int i=0;i<dp.length;i++)
			System.out.print(dp[i] + " ");
		System.out.println("------------");
		System.out.println("Minimum number of jumps to reach the end Using DP is :" + minJumpsDP(arr, n)); 
		
	}

	private static int minJumpsDP(int[] arr, int n) {
		if( n == 1) return 0;
		int[] dp = new int[n];
		dp[0] = 0;
		for(int i=1;i<n;i++) {
			if(arr[i] == 0) {
				dp[i] = Integer.MAX_VALUE;
				continue;
			}
			int minJumps= Integer.MAX_VALUE;
			for(int j=i-1;j>=0 ; j--) {
				if( j+arr[j]>=i )
					minJumps = Integer.min(minJumps, dp[j]);
			}
			dp[i] = 1 + minJumps;
		}
		return dp[n-1];
	}

	private static int minJumpsMemo(int[] arr, int n, int[] dp) {
		
		if( n == 1) return 0;
		if(arr[n-1] == 0) return Integer.MAX_VALUE;
		if(dp[n] != -1) return dp[n];
		int jumps = Integer.MAX_VALUE;
		for(int j=n-2;j>=0;j--) {
			// if n-1 is reachable from arr[j] 
			// i.e arr[j] >= n-j-1
			if(j+ arr[j] >= n-1) {
				int subjumps = minJumpsMemo(arr, j+1 , dp);
				 if (subjumps != Integer.MAX_VALUE) 
					 jumps = Integer.min(jumps, 1+subjumps);
			}
		}
		dp[n] = jumps;
		cnt++;
		return jumps;
	}

	private static int minJumps(int[] arr, int n) {
		
		if( n == 1) return 0;
		if(arr[n-1] == 0) return Integer.MAX_VALUE;
		
		int jumps = Integer.MAX_VALUE;
		for(int j=n-2;j>=0;j--) {
			// if n-1 is reachable from arr[j] 
			// i.e arr[j] >= n-j-1
			if(j+ arr[j] >= n-1) {
				int subjumps = minJumps(arr, j+1);
				 if (subjumps != Integer.MAX_VALUE) 
					 jumps = Integer.min(jumps, 1+subjumps);
			}
		}
		cnt++;
		return jumps;
	}
}
