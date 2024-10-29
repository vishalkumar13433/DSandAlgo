package src.Arrays;

import java.util.HashSet;
import java.util.Set;

public class pairSumX {

	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 10, -8}; 
        int n = 16; 
        int arr_size = A.length; 
          
        // Function calling 
        //If unsorted Array
        if(!hasArrayTwoCandidates(A, arr_size, n)) 
            System.out.println("Array doesn't have " + 
                               "two elements with given sum"); 
        //If Sorted Array, Use 2 pointer technique
        int arr[]={-8,1,4,6,10,45};
        checkNum(arr,arr.length,n);
        
	}

	private static void checkNum(int[] arr, int n, int sum) {
		int i=0,j=n-1;
		while(i<j)
		{
			if(arr[i] + arr[j] == sum)
			{
				System.out.println("Two numbers having sum :" + sum + " are : "+ arr[i] + " + " + arr[j]);
				return;
			}
			if(arr[i] + arr[j] < sum)
				i++;
			else
				j--;
		}
		System.out.println("NOT present!!");
	}

	private static boolean hasArrayTwoCandidates(int[] a, int n, int sum) {
		Set<Integer> hs=new HashSet();
		for(int i=0;i<n;i++)
		{
			if(hs.contains(sum-a[i]))
			{
				System.out.println("Two numbers having sum :" + sum + " are : "+ a[i] + " + " + (sum-a[i]));
				return true;
			}
			hs.add(a[i]);
		}
		return false;
		
	}

}
