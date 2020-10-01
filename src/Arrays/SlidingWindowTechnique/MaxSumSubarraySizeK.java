package Arrays.SlidingWindowTechnique;

public class MaxSumSubarraySizeK {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		int n = arr.length;
		System.out.println(maxSum(arr, n, k));
	}

	private static int maxSum(int[] arr, int n, int k) {
		if(n<k) return -1;	//Invalid
		
		int start = 0;
		int maxSum = 0;
		for(int i=0;i<k;i++) {
			maxSum += arr[i];
		}
		int curSum = maxSum;
		for(int i=k;i<n;i++) {
			curSum = curSum + arr[i] - arr[start];
			start++;
			maxSum = Integer.max(maxSum , curSum);
		}
		
		return maxSum;
	}

}
