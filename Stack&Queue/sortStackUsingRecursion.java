import java.util.ListIterator;
import java.util.Stack;

public class sortStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>(); 
        s.push(30); 
        s.push(-5); 
        s.push(18); 
        s.push(14); 
        s.push(-3); 
       
        System.out.println("Stack elements before sorting: "); 
        System.out.println(s); 
       
        sortStack(s); 
       
        System.out.println(" \n\nStack elements after sorting:"); 
        System.out.println(s); 
	}
	private static void sortStack(Stack<Integer> s) {
		if(!s.isEmpty())
		{
			int x=s.pop();
			sortStack(s);
			insertSorted(s,x);
		}
	}
	private static void insertSorted(Stack<Integer> s, int x) {
		if(s.isEmpty() || x>s.peek())
		{
			s.push(x);
		}
		else
		{
			int a=s.pop();
			insertSorted(s,x);
			s.push(a);
		}
	}
		
}
