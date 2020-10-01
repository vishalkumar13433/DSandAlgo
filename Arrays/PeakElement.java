
public class PeakElement {

	public static void main(String[] args) {
		int arr[] = {21, 3, 20, 4, 1, 0}; 
        int n = arr.length; 
        System.out.println("peak elements:\n ");  
        findPeak(arr, n); 
        System.out.print("\nPeak index using efficient method is :"+findPeakHelper(arr,0,n-1));
	}

	private static void findPeak(int[] arr, int n) {
		
		//O(n) time
		for(int i=0;i<n;i++)
		{
			int left,right;
			left=(i==0)?0:arr[i-1];
			right=(i==n-1)?0:arr[i+1];
			
			if(arr[i] >= left && arr[i] >= right)
				System.out.print(arr[i]+" ");
		}
		
		
	}

	private static int  findPeakHelper(int[] arr, int start, int end) {
		if(start<=end)
		{
			int mid=(start+end)/2;
			if((mid==start || arr[mid] >= arr[mid-1] ) && ( mid==end ||arr[mid] >= arr[mid+1]))
				return mid;
			
			// If middle element is not peak and its left neighbor is 
	        // greater than it,then left half must have a peak element 
			if(mid> start && arr[mid] < arr[mid-1])
				return findPeakHelper(arr,start,mid-1);
			//else right half will have it
			return findPeakHelper(arr,mid+1,end);
		}
		return -1;
	}

}
