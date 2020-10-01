import java.util.Stack;

public class delMiddleinStack {

	public static void main(String[] args) {
		Stack<Character> st = 
                new Stack<Character>(); 
    
      // push elements into the stack 
      st.push('1'); 
      st.push('2'); 
      st.push('3'); 
      st.push('4'); 
      st.push('5'); 
      st.push('6'); 
      st.push('7'); 
      st.push('8'); 
  
    
      deleteMid(st, st.size(), 0); 
    
      // Printing stack after deletion 
      // of middle. 
      while (!st.empty()) 
      { 
          char p=st.pop(); 
          System.out.print(p + " "); 
      } 
	}

	private static void deleteMid(Stack<Character> st, int size, int cur) {
		if(!st.isEmpty())
		{
			int x=st.pop();
			deleteMid(st, size, cur+1);
			if(cur!=(size)/2)
				st.push((char) x);
		}
		
	}

}
