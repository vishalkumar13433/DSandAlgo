package src.StackAndQueue;

import java.util.Stack;

public class minStackinO1 {
	Stack<Integer> s;
	int min;
	minStackinO1()
	{	
		min=Integer.MAX_VALUE;
		s=new Stack<>();
	}
	public static void main(String[] args) {
		minStackinO1 myStack= new minStackinO1();	
		myStack.push(3);
		System.out.println(myStack.peek());
		myStack.push(5);
		System.out.println(myStack.peek());
		myStack.push(2);
		System.out.println(myStack.peek());
		myStack.push(1);
		System.out.println(myStack.peek());
		myStack.push(1);
		System.out.println(myStack.peek());
		myStack.push(-1);
		System.out.println(myStack.peek());
		System.out.println("Min element :"+myStack.getMin());
		System.out.println("Popping :"+myStack.pop());
		System.out.println("Min element :"+myStack.getMin());
		System.out.println("Popping :"+myStack.pop());
		System.out.println("Min element :"+myStack.getMin());
		System.out.println("Popping :"+myStack.pop());
		System.out.println("Min element :"+myStack.getMin());
		System.out.println("Popping :"+myStack.pop());
		System.out.println("Min element :"+myStack.getMin());
	}
	private int pop() {
		int pop=s.pop();
		
		if(pop < min)
		{
			int ret=pop;
			pop=min;
			min= 2*min-ret;
		}
		return pop;
	}
	private int getMin() {
		if (s.isEmpty()) 
            {
				System.out.println("Stack is empty"); 
				return Integer.MIN_VALUE;
            }
		return min;
	}
	private int peek() {
		if(s.isEmpty())
			return Integer.MIN_VALUE;
		return s.peek();
	}
	private void push(int val) {
		if(s.isEmpty())
			{
				min=val;
				s.push(val);
			}
		else if(val < min)
		{
			
			int n= 2*val - min;
			s.push(n);
			min=val;
		}
		else
		{
			s.push(val);
		}
	}

}
