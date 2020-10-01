import java.util.Arrays;

public class RodCuttingProblem {

	public static void main(String args[]) 
    { 
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.length; 
        System.out.println("Maximum Obtainable Value is "+ 
                            cutRod(arr, size)); 
  
    }

	private static int cutRod(int[] arr, int n) {
		
		//O(2^N)
		/*if(n == 0) return 0;
		int maxProfit = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			maxProfit = Integer.max(maxProfit, arr[i] + cutRod(arr,n-i-1));
		}
		return maxProfit;*/
		
		//Memoized Solution
		/*int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		return cutRodUtil(arr, n , memo);*/
		
		//Bottom's Up Approach
		int[] memo = new int[n+1];
		memo[0] = 0;
		for(int i=1;i<=n;i++) {
			int maxProfit = Integer.MIN_VALUE;
			for(int j=0;j<i;j++) {
				maxProfit = Integer.max(maxProfit, arr[j] + cutRod(arr,n-j-1));
			}
			memo[i] = maxProfit;
		}
		return memo[n];
	}

	//O(N^2)
	private static int cutRodUtil(int[] arr, int n, int[] memo) {
		if(memo[n] != -1) return memo[n];
		int maxProfit = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			maxProfit = Integer.max(maxProfit, arr[i] + cutRod(arr,n-i-1));
		}
		memo[n] = maxProfit;
		return maxProfit;
	} 
	
}
