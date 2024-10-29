package src.StackAndQueue;

public class implementStackusingLinkedList {
	LLstackNode top;
	implementStackusingLinkedList()
	{
		top=null;
	}
	void push(int val)
	{
		LLstackNode n=new LLstackNode(val);
		n.next=top;
		top=n;
	}

	int pop()
	{
		if(isEmpty())
		{
			System.out.println("\nUnderFlow!!! cannot pop ");
			return -1;
		}
		int pop_element=top.data;
		LLstackNode next=top.next;
		top.next=null;
		top=next;
		return pop_element;
	}
		
	int peek()
	{
		if(top==null)
			{
				System.out.println("Empty Stack");
				return -1;
			}
		return top.data;
	}
	
	boolean isEmpty()
	{
		return (top==null);
	}
	
	public static void main(String[] args) {
		implementStackusingLinkedList s=new implementStackusingLinkedList();
		s.push(10);
		s.push(5);
		s.push(7);
		s.push(11);
		s.push(1);
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
