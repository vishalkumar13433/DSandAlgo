package src.Arrays;

public class Sort0s1s2s {

	public static void main (String[] args) 
    { 
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}; 
        int arr_size = arr.length; 
        sort012(arr, arr_size); 
        System.out.println("Array after seggregation "); 
        printArray(arr, arr_size); 
    }

	private static void printArray(int[] arr, int arr_size) {
		 int i; 
	        for (i = 0; i < arr_size; i++) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(""); 
		
	}

	private static void sort012(int[] arr, int arr_size) {
		
		//Dutch National Flag Algorithm
		
		int start=0,mid=0,end=arr_size -1;
		while(mid<=end)
		{
			switch(arr[mid])
			{
			case 0:	{
						int temp=arr[mid];
						arr[mid]=arr[start];
						arr[start]=temp;
						
						start++;
						mid++;
						break;
					}
					
			case 1:	mid++;
					break;
			case 2:{
						int temp=arr[mid];
						arr[mid]=arr[end];
						arr[end]=temp;
				
						end--;
						break;
					}
			}
		}
	} 
}
