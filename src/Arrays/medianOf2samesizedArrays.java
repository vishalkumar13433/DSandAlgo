package Arrays;

public class medianOf2samesizedArrays {

	public static void main(String[] args) {
		int ar1[] = {1,12,15,26,38};  
	    int ar2[] = {2,13,17,30,45};  
	    int n1 = ar1.length;  
	    int n2 = ar2.length;  
	    if (n1 == n2)  
	        System.out.println("Median is " + getMedian(ar1, 0,n1 - 1,ar2, 0,n2-1  ));  
	    else
	        System.out.println("Doesn't work for arrays "+ "of unequal size");  
	}

	private static int getMedian(int[] ar1,int s1,int e1, int[] ar2, int s2,int e2) {
		int n=e1-s1+1;
		if(n<=0)
			return -1;
		
		System.out.println("\n------------------------\nPrinting Array 1: ");
		for(int i=s1;i<=e1;i++)
			System.out.println(ar1[i] + " ");
		System.out.println("\n\nPrinting Array 2: ");
		for(int i=s2;i<=e2;i++)
			System.out.println(ar2[i] + " ");
		System.out.println("\n------------------------\n");
		if(n==1)
		{
			return ((ar1[s1]+ar2[s2])/2);
		}
		if(n==2)
		{
			return (Integer.min(ar1[e1], ar2[e2]) + Integer.max(ar1[s1], ar2[s2]))/2;
		}
		
		int med1=median(ar1,s1,n);
		int med2=median(ar2,s2,n);
		
		System.out.println("Med 1:" + med1);
		System.out.println("Med 2:" + med2);
		
		
		if(med1 == med2)
			return med1;
		if(med1 < med2)
		{
			if (n % 2 == 0) 
			{
				return getMedian(ar1, s1+n/2,s1+n-1, ar2, s2,s2+n/2 - 1);
			}
			return getMedian(ar1, s1+n/2,s1+n-1, ar2, s2,s2+n/2);
		}
		
		if (n % 2 == 0) 
		{
			return getMedian(ar1, s1,s1+n/2-1, ar2, s2+n/2,s2+n-1);
		}
		return getMedian(ar1,s1,s1+n/2, ar2, s2+n/2,s2+n-1);
		
	}

	static int median(int arr[], int start,int n) 
	{ 
	    if (n % 2 == 0) 
	        return (arr[start+n / 2] +  
	                arr[start + n / 2 - 1]) / 2; 
	    else
	        return arr[start+n / 2]; 
	} 
	  
	
}
