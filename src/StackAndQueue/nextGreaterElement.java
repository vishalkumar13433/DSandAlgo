package src.StackAndQueue;

import java.util.Stack;

public class nextGreaterElement {

	 public static void main(String args[]) 
	    { 
	        int arr[]= {11, 13, 21, 3}; 
	        int n = arr.length; 
	        printNGE(arr, n); 
	       
	    }

	private static void printNGE(int[] arr, int n) {
		//O(n^2)
		/*for(int i=0;i<n;i++)
		{
			int max=-1;
			
			for(int j=i+1;j<n;j++)
			{
				if(arr[j] > arr[i])
					{
						max=arr[j];
						break;
					}
			}
			arr[i]=max;
		}
		*/
		int nge[] = new int[arr.length]; 
		Stack<Integer> s=new Stack();
		for(int i=arr.length -1;i>=0;i--)
		{
			while(!s.isEmpty() && s.peek()<= arr[i])
				s.pop();
			nge[i]=(s.isEmpty())?-1:s.peek();
			s.push(arr[i]);
		}
		for(int i = 0; i < nge.length; i++)  
	        System.out.print(nge[i] + " "); 
	} 
}
