package src.StackAndQueue;
import java.util.LinkedList;
import java.util.Queue;

public class movingAverageInAStream {
	Queue<Integer> q;
	Double previousAvg;
	int maxSize;
	
	public movingAverageInAStream(int size) {
        q= new LinkedList<>();
        this.maxSize = size;
        this.previousAvg = 0d;
    }
    
    public double next(int val) {
    	int size  = q.size();
    	if(size == 0) {
    		q.add(val);
    		 this.previousAvg = val + 0.0;
    		return val;
    	}
        if( size < this.maxSize) {
        	Double prevAvg = this.previousAvg;
        	Double newAvg = (prevAvg * size + val)/(size+1.0);
        	q.add(val);
        	this.previousAvg = newAvg;
        	return newAvg;
        }else {
        	int toBeRemoved = q.poll();
        	Double newAvg = (previousAvg*this.maxSize - toBeRemoved + val)/(this.maxSize+ 0.0);
        	q.add(val);
        	this.previousAvg = newAvg;
        	return newAvg;
        }
    }
	
	public static void main(String[] args) {
		movingAverageInAStream stream = new movingAverageInAStream(3);
		double next = stream.next(1);
		System.out.println(next);
		next = stream.next(10);
		System.out.println(next);
		next = stream.next(3);
		System.out.println(next);
		next = stream.next(7);
		System.out.println(next);
		next = stream.next(5);
		System.out.println(next);
	}

}
