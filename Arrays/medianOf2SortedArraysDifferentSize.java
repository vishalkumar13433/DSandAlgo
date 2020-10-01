
public class medianOf2SortedArraysDifferentSize {

	public static void main(String[] args) {
		int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 18, 21, 25};
        
        System.out.println("Median is:"+findMedianSortedArrays(x, y));
	}

	private static double findMedianSortedArrays(int[] x, int[] y) {
		
		//1. check for shorter array
		if(x.length > y.length)
			return findMedianSortedArrays(y,x);
		
		//2.1.partition point for shorter array
		//2.2 check if its valid
		int part=-1;
		
		int start=0,end=x.length; //end is not equal to x.length -1 to handle case where one of the array has 1 element
		while(start <= end)
		{
			int part_x=(start+end)/2;
			
			int part_y = (x.length+y.length +1)/2 - part_x;
			int left_x=(part_x == 0 )? Integer.MIN_VALUE : x[part_x - 1];
			int left_y=(part_y == 0 )? Integer.MIN_VALUE : y[part_y - 1];
			int right_x = (part_x == x.length)? Integer.MAX_VALUE : x[part_x];
			int right_y = (part_y == y.length)? Integer.MAX_VALUE : y[part_y];
			
			System.out.println("\n--------------------------\n");
			System.out.println("part_x:"+part_x);
			System.out.println("part_y:"+part_y);
			System.out.println("left_x:"+left_x);
			System.out.println("right_x:"+right_x);
			System.out.println("right_y:"+right_y);
			System.out.println("left_y:"+left_y);
			System.out.println("\n--------------------------\n");
			
			if( left_x <= right_y && left_y <= right_x)
			{
				
				if((x.length + y.length)%2 ==0)
					return (Integer.max(left_x,left_y) + Integer.min(right_x,right_y))/2.0;
				else
					return Double.max(left_x, left_y);
				
			}
			else if( left_x > right_y )
			{
				end=part_x -1;
			}
			else
				start=part_x +1;
		}
		return 0.0;
				
	}

}
