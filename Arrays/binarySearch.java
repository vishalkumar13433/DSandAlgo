
public class binarySearch {

	public static void main(String[] args) {
		binarySearch ob = new binarySearch(); 
        int arr[] = { 2, 3, 4, 10, 40 }; 
        int n = arr.length; 
        int x = 10; 
        int result = ob.binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
	}

	private int binarySearch(int[] arr, int start, int end, int val) {
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
