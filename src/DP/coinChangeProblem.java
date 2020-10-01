package DP;

public class coinChangeProblem {

	public static void main(String[] args) 
    { 
        int arr[] = {1, 2, 3}; 
        int total = 4;
        int m = arr.length; 
        System.out.println( countWays(arr, m-1,total )); 
        System.out.println( countWaysDP(arr, m, total));
        
    }

	private static int countWaysDP(int[] arr, int typeOfChange, int total) {
		int[][] dp = new int[typeOfChange+1][total+1];
		dp[0][0] = 1;
		for(int i=1; i< total+1 ; i++) {
			dp[0][i] = 0;	//cannot make any total with no coins
		}
		for(int i=1;i<typeOfChange+1;i++) {
			dp[i][0] = 1;	// can only make 0 total by not adding any of the coins
		}
		
		for(int i=1; i< typeOfChange+1 ; i++) {
			for(int j=1; j<total+1 ; j++) {
				if(j< arr[i-1]) {
					//as coin value is more than total , can't include
					dp[i][j] = dp[i-1][j];
				} else {
								//include coin			//dont include
					dp[i][j] = dp[i][j - arr[i-1]] + dp[i-1][j];
				}
			}
		}
		
		System.out.println("------------");
		for(int i=0;i<dp.length;i++) {
			System.out.println();
			for(int j=0 ; j< dp[0].length;j++) {
				System.out.print(dp[i][j] + " ");
			}
		}
		System.out.println("------------");
		return dp[typeOfChange][total];
	}

	private static int countWays(int[] arr, int changeIndex, int total) {
		
		
		if(total == 0) return 1;
		if(total < 0) return 0;
		
		//dont have coins to make the denomination
		if(changeIndex < 0 ) return 0;
//				Include coin												dont include
		return countWays(arr, changeIndex, total - arr[changeIndex] ) + countWays(arr, changeIndex-1, total);
			
	} 

}
