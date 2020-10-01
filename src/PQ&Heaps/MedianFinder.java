import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> min,max;
	MedianFinder()
	{
		min=new PriorityQueue<>();
		max=new PriorityQueue<>(Collections.reverseOrder());
	}
	    public static void main(String[] args) {
	    	MedianFinder obj = new MedianFinder();
	    	  obj.addNum(1);
	    	  System.out.println(obj.findMedian());
	    	  obj.addNum(30);
	    	  System.out.println(obj.findMedian());
	    	  obj.addNum(5);
	    	  System.out.println(obj.findMedian());
	    	  obj.addNum(15);
	    	  System.out.println(obj.findMedian());
	    	 
	    	  
	    }
	
		private double  findMedian() {
			PriorityQueue<Integer> big,small;
			if(max.size() > min.size())
			{
				big=max;
				small=min;
			}
			else
			{
				big=min;
				small=max;
			}
				
			return (big.size()==small.size())?((big.peek()+small.peek())/2.0):big.peek();
			
		}

		private void addNum(int num) {
			if(max.size()==0 || num<=max.peek())
				max.add(num);
			else if(min.size()==0 ||num > max.peek() )
				min.add(num);
			
			if(min.size() - max.size() > 1)
				max.offer(min.poll());
			else if(max.size() - min.size() > 1)
				min.offer(max.poll());
		}
	

}
