package Arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; 
		System.out.println("Maximum water that can be accumulated is " +  
                findWater(arr,arr.length)); 
	}

	private static int findWater(int[] a, int n) {
		
		if(n==0)
            return 0;
		
		int[] left=new int[n];
		int[] right=new int[n];
		
		left[0]=a[0];
		right[n-1]=a[n-1];
		
		int ans=0;
		
		int i;
		for(i=1;i<n;i++)
			left[i]=Math.max(left[i-1], a[i]);
		
		for(i=n-2;i>=0;i--)
			right[i]=Math.max(right[i+1],a[i]);
		
		
		//water that can be held by a bar depends on previous highest bar and next highest bar .
		for( i=0;i<n;i++)
		{
			ans+= (Math.min(left[i], right[i]) - a[i]);
		}
		return ans;
	}

}
