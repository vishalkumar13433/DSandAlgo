
public class countNumOfInversions {

	public static void main(String[] args) {
		 int arr[] = new int[] { 1, 20, 6, 4, 5 }; 
	     System.out.println("Number of inversions are " + mergeSortHelper(arr, 5)); 
	     
	}

	private static int mergeSortHelper(int[] arr, int n) {
		int temp[]=new int[n];
		return mergeSort(arr,temp,0,n-1);
	}

	private static int mergeSort(int[] arr, int[] temp, int start, int end) {
		
		if(start<end)
		{
			int mid=(start+end)/2;
			//total inversions are inversions in left subarray +inversion in right subarray + inversion between left and right sorted arrays
			return mergeSort(arr,temp,start,mid) + mergeSort(arr,temp,mid+1,end) + merge(arr,temp,start,mid,end);
		}
		return 0;
	}

	private static int merge(int[] arr, int[] temp, int start, int mid, int end) {
		int k=start,i=start,j=mid+1;
		int inv_cnt=0;
		
		while(i<=mid && j<=end)
		{
			
			if(arr[i] <= arr[j])
			{
				temp[k]=arr[i];
				i++;
			}
			else
			{
				temp[k]=arr[j];
				//if left array's smallest element is greater than smallest element of right 
				//then its an inversion for all the elements in left array as they all are greater than it.
				inv_cnt += (mid-i+1);	//as mid is last element in left sorted subarray
				//we are incrementing all at once because element will be added only once
				j++;	
			}
			k++;
		}
		
		while(i<=mid)
		{
			temp[k]=arr[i];
			k++;
			i++;
		}
		while(j<=end)
		{
			temp[k]=arr[j];
			k++;
			j++;
		}
		return inv_cnt;
	}
}
