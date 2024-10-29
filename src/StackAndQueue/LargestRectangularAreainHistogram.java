package src.StackAndQueue;

import java.util.Stack;

public class LargestRectangularAreainHistogram {

	public static void main(String[] args) {
		
		LargestRectangularAreainHistogram l=new LargestRectangularAreainHistogram();
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
        System.out.println("Maximum area is " + l.getMaxArea(hist, hist.length)); 
	}

	private int getMaxArea(int[] hist, int length) {
		
		Stack<Integer> s=new Stack();
		int i=0,max_Area=0;
		while(i<length)
		{
			if(s.isEmpty() || hist[s.peek()]<=hist[i])
			{
				s.push(i);
				i++;
			}
			else
			{
				int height=s.pop();
				int area_covered=hist[height]* ((s.isEmpty())? i : i-s.peek()-1);
				if(area_covered > max_Area)
					max_Area=area_covered;
			}
		}
		while(!s.isEmpty())
		{
			int height=s.pop();
			int area_covered=hist[height]* ((s.isEmpty())? i : i-s.peek()-1);
			if(area_covered > max_Area)
				max_Area=area_covered;
		}
		return max_Area;
	}

}
