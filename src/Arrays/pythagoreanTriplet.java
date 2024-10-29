package src.Arrays;

import java.util.Arrays;

public class pythagoreanTriplet {
	public static void main(String[] args) 
    { 
        int ar[] = {3, 1, 4, 6, 5}; 
        int ar_size = ar.length; 
        if(isTriplet(ar,ar_size)==true) 
           System.out.println("Yes"); 
        else
           System.out.println("No");         
    }

	private static boolean isTriplet(int[] ar, int n) {
		
		if(n<2)
			return false;
		Arrays.sort(ar);
		//square every Element
		for(int i=0;i<n;i++)
			ar[i]*=ar[i];
		
		//problem has become, 3 numbers with sum
		for(int i=n-1;i>=0;i--)
		{
			int l=0,r=i-1;
			while(l<r)
			{
				if(ar[l] + ar[r] == ar[i])
				{
					return true;
				}
				if( ar[l] + ar[r] < ar[i] )
					l++;
				else
					r--;
			}
		}
		
		return false;
	} 
}
