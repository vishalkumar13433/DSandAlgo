
public class findMissingNumber {

	 public static void main(String args[]) 
	    { 
	        int a[] = {1,2,4,5,6}; 
	        int miss = getMissingNo(a,5); 
	        System.out.println(miss);    
	    }

	private static int getMissingNo(int[] a, int n) {
		//Method 1: O(n)
	/*	int sum=(n+1)*(n+2)/2;
		for(int i=0;i<n;i++)
			sum-=a[i];
		return sum;
		*/
		
		//Method 1:Also  O(n)
		int x1=a[0];
		//XOR all given number
		for(int i=1;i<n;i++)
			x1=x1 ^ a[i];
		//XOR all number from 1 to n+1
		int x2=1;
		for(int i=2;i<=n+1;i++)
			x2=x2^i;
		//XORing both will give 
		return x1^x2;
	} 

}
