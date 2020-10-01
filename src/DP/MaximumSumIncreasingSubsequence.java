package DP;

public class MaximumSumIncreasingSubsequence {

	public static void main(String args[]) 
    { 
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5}; 
        int n = arr.length; 
        System.out.println("Sum of maximum sum "+ 
                            "increasing subsequence is "+ 
                              maxSumIS(arr, n)); 
    }

//	O(N^2)
	private static int maxSumIS(int[] arr, int n) {
		if(n ==0) return 0;
		if(n==1) return arr[0];
		int[] sum = new int[n];
		for(int i=0;i<arr.length;i++) {
			sum[i] = arr[i];
		}
		int lis = Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j]) {
					arr[i] = Integer.max(arr[i], arr[i]+sum[j]);
					lis = Integer.max(lis , arr[i]);
				}
			}
		}
		return lis;
	} 

}
