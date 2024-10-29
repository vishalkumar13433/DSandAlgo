package src.StackAndQueue;

import java.util.Stack;

public class reverseStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> st=new Stack();
			st.push(1); 
	        st.push(2); 
	        st.push(3); 
	        st.push(4); 
	        st.push(7); 
	          
	        System.out.println("Original Stack"); 
	          
	        System.out.println(st); 
	          
	        // function to reverse  
	        // the stack 
	        reverse(st); 
	          
	        System.out.println("Reversed Stack"); 
	          
	        System.out.println(st); 
	}

	private static void reverse(Stack<Integer> st) {
		if(!st.isEmpty())
		{
			int x=st.pop();
			reverse(st);
			
			insert_end(st,x);
		}
	}

	private static void insert_end(Stack<Integer> st, int x) {
		if(st.empty())
		{
			st.push(x);
		}
		else
		{
			//hold all elements in call stack with var a;
			int a=st.pop();
			//insert current element in end
			insert_end(st,x);
			//start adding element holded in call stack back one by one
			st.push(a);
		}
	}


}
