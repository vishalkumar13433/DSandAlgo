import java.util.Stack;

public class sortStackUsingTempStack {

	public static void main(String[] args) {
		Stack<Integer> input = new Stack<Integer>(); 
        input.add(34); 
        input.add(3); 
        input.add(31); 
        input.add(98); 
        input.add(92); 
        input.add(23); 
      
        // This is the temporary stack 
        Stack<Integer> tmpStack= new Stack<Integer>();
        sortstack(input,tmpStack); 
        System.out.println("Sorted numbers are:"); 
      
        while (!tmpStack.empty()) 
        { 
            System.out.print(tmpStack.pop()+" "); 
        }  
	}

	private static void sortstack(Stack<Integer> s, Stack<Integer> tmp) {
		while(!s.isEmpty())
		{
			int x=s.pop();
			while(!tmp.isEmpty() && tmp.peek()>x)
			{
				s.push(tmp.pop());
			}
			tmp.push(x);
		}
	}


}
