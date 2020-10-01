package Arrays.Strings;

public class CustomSqrt {

	public static void main(String[] args) 
    { 
        int x = 11; 
        System.out.println(floorSqrt(x));
        System.out.println(flrsqrt(x));
    }

	//O(Sqrt(x))
	private static int floorSqrt(int x) {
		
		int i=1;
		while(i*i <= x)
		{
			i++;
		}
		return i-1;
	} 
	
	//O(log x)
	private static int flrsqrt(int x) {
		
		int start=0,end=x;
		while(start<=end)
		{
			int mid=(start+end)/2;
			int sq=mid*mid;
			if( sq== x)
				return mid;
			if(sq < x)
				start=mid+1;
			else
				end=mid-1;
		}
		return end;
	}
}
