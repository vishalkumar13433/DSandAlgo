package StackAndQueue;

import java.util.Stack;

public class SortArrayUsingStack {

	public static void main(String[] args) {
		Stack<Integer> input = new Stack<Integer> ();
        input.add(34); 
        input.add(3); 
        input.add(31); 
        input.add(98); 
        input.add(92); 
        input.add(23); 
      
        // This is the temporary stack 
        Stack<Integer> tmpStack=sortstack(input); 
        System.out.println("Sorted numbers are:"); 
      
        while (!tmpStack.empty()) 
        { 
            System.out.print(tmpStack.pop()+" "); 
        }  
	}

	private static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> tmp= new Stack<Integer>();
		while(!input.isEmpty())
		{
			int temp=input.pop();
			while(!tmp.isEmpty() && temp > tmp.peek())
			{
				input.push(tmp.pop());
			}
			tmp.push(temp);
		}
		
		return tmp;
	}

}
