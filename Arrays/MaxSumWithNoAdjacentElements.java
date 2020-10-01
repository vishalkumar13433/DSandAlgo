public class MaxSumWithNoAdjacentElements {

	public static void main(String[] args) 
    { 
		MaxSumWithNoAdjacentElements sum = new MaxSumWithNoAdjacentElements(); 
        int arr[] = new int[]{5, 5, 10, 100, 10, 5}; 
//		int arr[] = new int[]{10, 2, 1, 8, 4, 6,10}; 
		System.out.println(sum.FindMaxSum(arr, arr.length)); 
    }

	
	private int FindMaxSum(int[] arr, int n) {
		int sumIncludingI = arr[0];
		int sumExcludingI = 0;
		int exclNew = 0;
		for(int i=1;i<n;i++) {
			exclNew = Integer.max(sumIncludingI, sumExcludingI);
			sumIncludingI = sumExcludingI + arr[i];
			sumExcludingI = exclNew;
		}
		return Integer.max(sumExcludingI, sumIncludingI);
	}
	
}
