
public class findMissingnoFromAP {

	public static void main(String[] args) {
		int arr[] = {2, 4, 8, 10, 12, 14}; 
	    int n = arr.length; 
	    System.out.println("The missing element is "+    
	                            findMissing(arr, n)); 
	    int d=(arr[n-1] - arr[0] )/n;
	    System.out.println("The missing element is "+    
                findMissing2(arr,0, n-1,d)); 
	}

	private static int findMissing2(int[] arr, int start,int end,int d) {
		//O(log n )
		if(start>end)
				return -1;
		int mid=(start+end)/2;
		if(arr[mid+1] - arr[mid] != d)
			return arr[mid]+d;
		if(arr[mid] - arr[mid-1] !=d)
			return arr[mid-1]+d;
		if(arr[mid]==arr[start]+(mid-start-1)*d)
		{
			return findMissing2(arr,mid+1,end,d);
		}
		
		return findMissing2(arr,start,mid-1,d);
	}

	private static int findMissing(int[] arr, int n) {
		//O(n)
		/*
		int d=(arr[n-1]-arr[0])/n;
		System.out.println("commom difference :"+d);
		for(int i=1;i<n;i++)
		{
			if(arr[i] != arr[i-1]+d)
				return arr[i-1]+d;
			
		}
		return -1;
		*/
		int sum=((n+1)*(arr[0] + arr[n-1])) /2 ;
		System.out.println("sum :"+sum);
		for(int i=0;i<n;i++)
		{
			sum-=arr[i];
		}
		return sum;
	}
	

}
