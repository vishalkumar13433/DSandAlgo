package Arrays;

public class segregateEvenandOdd {

	public static void main(String[] args) { 
	    
	        int arr[] = { 1, 3, 2, 4, 7,  
	                            6, 9, 10 }; 
	        int n = arr.length; 
	        arrayEvenAndOdd(arr, n); 
	        for (int i : arr) 
	            System.out.print(i + " "); 
	        System.out.println("\n2nd method");
	        arraySeg(arr,n);
	        for (int i : arr) 
	            System.out.print(i + " "); 
	}

	private static void arraySeg(int[] arr, int n) {
		//O(n/2) time and O(n) space
		int i=0,j=n-1,k=0,l=n-1;
		
		int[] ans=new int[n];
		
		while(i<=l)
		{
			if(arr[i]%2==0)
			{
				ans[k]=arr[i];
				k++;
				
			}
			else
			{
				ans[l]=ans[i];
				l--;
			}
			i++;
			
			if(arr[j]%2 == 0)
			{
				ans[k]=arr[j];
				k++;
			}
			else
			{
				ans[l]=arr[j];
				l--;
			}
			j--;
		}
		
		for(i=0;i<n;i++)
		{
			arr[i]=ans[i];
		}
	}

	private static void arrayEvenAndOdd(int[] arr, int n) {
		//O(n) time and O(1) space
		int i=-1,j=0;
		while(j!=n)
		{	
			if(arr[j]%2==0)
			{
				i++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
			j++;
		}
	}
}
