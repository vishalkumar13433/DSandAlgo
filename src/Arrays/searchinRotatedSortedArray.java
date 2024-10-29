package src.Arrays;

public class searchinRotatedSortedArray {

	public static void main(String[] args) {
		int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; 
	    int n = arr1.length; 
	    int key = 3; 
	    System.out.println("Index of the element is : "+ pivotedBinarySearch(arr1, n, key)); 
	}

	private static int pivotedBinarySearch(int[] arr, int n, int key) {
		//1.find Pivot
		int pivot=findPivot(arr,0,n-1);
		System.out.println("Pivot : " + pivot);
		if(pivot == -1)	//array not rotated
			return binarySearch(arr,0,n-1,key);
		// 2. search in left sorted subarray
		int ind=binarySearch(arr,0,pivot,key);
		if(ind!= -1)
			return ind;
		//3. search in right sorted subarray
		return binarySearch(arr,pivot+1,n-1,key);
	}

	
	private static int findPivot(int[] arr, int start, int end) {
		if(start < end)
		{
			int mid=(start+end)/2;
			
			 //1.in case mid is end ,then mid+1 will cause IndexOutOfBound
			if(mid < end && arr[mid]>arr[mid+1])
				return mid;
			
			//2.in case mid is start ,then mid-1 will cause IndexOutOfBound
			if(mid > start && arr[mid] < arr[mid-1])
				return mid-1;
			
			if(arr[mid] <= arr[start])
				return findPivot(arr,start,mid-1);
			return findPivot(arr,mid+1,end);
		}
		return -1;
	}

	private static int binarySearch(int[] arr, int start, int end, int val) {
		if(start <= end)
		{
			int mid=(start+end)/2;
			if(arr[mid]==val)
				return mid;
			if(arr[mid] < val)
				return binarySearch(arr,mid+1,end,val);
			return binarySearch(arr,start,mid-1,val);
		}
		return -1;
	}
	
}
