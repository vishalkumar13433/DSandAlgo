package src.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int arr[]= {1,4,1,2,7,5,2};
		countingSort(arr,arr.length);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i] + " ");
	}

	private static void countingSort(int[] arr, int length) {
		
		int[] count=new int[10];
		for(int i=0;i<length;i++)
		{
			count[arr[i]]++;
		}
		
		int i=0,k=0;
		while(i<count.length)
		{
			if(count[i] == 0)
				{
					i++;
					continue;
				}
			arr[k++]=i;
			count[i]--;
		}
	}

}
