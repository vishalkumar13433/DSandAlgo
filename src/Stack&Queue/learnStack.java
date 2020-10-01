
public class learnStack {

	int MAX=5,top=-1;
	int[] a=new int[MAX];
	

	void push(int val)
	{
		if(top >= MAX-1)
			{
				System.out.println("OverFlow!!! Cannot push");
				return;
			}
		
		top=top+1;
		System.out.println("Adding ->"+val+" to the Stack");
		a[top]=val;
	}

	int pop()
	{
		if(top<0)
		{
			System.out.println("\nUnderFlow!!! cannot pop ");
			return -1;
		}
		
		int pop_element=a[top];
		top--;
		
		return pop_element;
	}
		
	int peek()
	{
		if(isEmpty())
		{
			System.out.println("Empty Stack");
			return -1;
		}
		return a[top];	
	}
	
	boolean isEmpty()
	{
		return (top<0);
	}
	
	
	public static void main(String[] args) {
			learnStack s=new learnStack();
			s.push(10);
			s.push(5);
			s.push(7);
			s.push(11);
			s.push(1);
			//Overflow condition !! stack is full
			s.push(0);
			//peeking: what is at the top?
			
			System.out.println("Top element in Stack :"+s.peek());
			
			//popping
			System.out.println("Removing top Element from stack i.e. :"+s.pop());
			System.out.println("Top element in Stack :"+s.peek());
			System.out.println("Removing top Element from stack i.e. :"+s.pop());
			System.out.println("Top element in Stack :"+s.peek());
			System.out.println("Removing top Element from stack i.e. :"+s.pop());
			System.out.println("Top element in Stack :"+s.peek());
			System.out.println("Removing top Element from stack i.e. :"+s.pop());
			System.out.println("Top element in Stack :"+s.peek());
			System.out.println("Removing top Element from stack i.e. :"+s.pop());
			System.out.println("Top element in Stack :"+s.peek());
			System.out.print("Removing top Element from stack i.e. :"+s.pop());
			System.out.println("Top element in Stack :"+s.peek());
			
			
			if(s.isEmpty())
			{
				System.out.println("Empty Stack");
			}
			
	}

}
