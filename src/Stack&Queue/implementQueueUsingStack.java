import java.util.Stack;

public class implementQueueUsingStack {
	Stack<Integer> s1=new Stack<>();
	Stack<Integer> s2=new Stack<>();
	public static void main(String[] args) {
		implementQueueUsingStack queue = new implementQueueUsingStack();

		queue.push(1);
		queue.push(2);  
		System.out.println(queue.peek());
		System.out.println(queue.pop() );
		System.out.println(queue.empty());
	}
	
	 public void push(int x) 
	 {
	       s1.push(x);
	     
	 }
	    
	    /** Removes the element from in front of queue and returns that element. */
	 public int pop() 
	 {
		 	int x=-1;
   	  		while(!s1.isEmpty())
   	  		{
	    	   s2.push(s1.pop());
	    	  
   	  		}
   	  		x=s2.pop();
   	  		while(!s2.isEmpty())
   	  		{
   	  			s1.push(s2.pop());
   	  		}
   	  		return x;
     }
	    
	    /** Get the front element. */
    public int peek() 
    {
    		int x=-1;
    	  while(!s1.isEmpty())
	       {
	    	   s2.push(s1.pop());
	    	 
	       }
    	  x=s2.peek();
    	  while(!s2.isEmpty())
	       {
	    	   s1.push(s2.pop());
	       }
    	  return x;
    }
	    
	    /** Returns whether the queue is empty. */
	 public boolean empty() 
	 {
	        return s1.isEmpty();
	 }
	

}
