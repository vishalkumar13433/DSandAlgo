
public class equilibriumIndex {

	 public static void main(String[] args)  
	    { 
	        int arr[] = { -7, 1, 5, 2, -4, 3, 0 }; 
	        int arr_size = arr.length; 
	        System.out.println("First equilibrium index is " +  
	                         equilibrium(arr, arr_size)); 
	    }

	private static int equilibrium(int[] arr, int n) {
		int sum=0;
		for(int i=0;i<n;i++)
			sum+=arr[i];
		
		int left_sum=0;
		for(int i=0;i<n;i++)
		{
			int right_sum;
            right_sum=(i==n-1)?0:(sum-arr[i]-left_sum);
			if(left_sum == right_sum)
			{
				return i;
			}
			left_sum += arr[i];
		}
		return -1;
	} 
}
