package src.StackAndQueue;
import java.util.Stack;

public class convertInfixToPostfix {

		public static void main(String[] args)  
	    { 
	        String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
	        System.out.println(infixToPostfix(exp)); 
	    }

		private static String infixToPostfix(String exp) {
			String res=new String("");
			Stack<Character> s= new Stack<Character>();
			for(Character c:exp.toCharArray())
			{
				if( Character.isLetterOrDigit(c))
				{
					res=res+c;
				}
				else if(c=='(')
					{
						s.push(c);
					}
				else if(c==')')
				{
					while( !s.isEmpty() && s.peek()!='(')
					{
						res=res+s.pop();
					}
					if(s.isEmpty() && s.peek()!='(')
					{
						System.out.println("Invalid String");
						return res;
					}
					else
					{
						s.pop();
					}
				}
				else if(c=='*' || c=='/' || c=='+' || c=='-' || c=='^')
				{
					if(s.isEmpty() || precedence(c) >= precedence(s.peek()))
					{
						s.push(c);
					}
					else
					{
						while(!s.isEmpty() && precedence(c) <= precedence(s.peek()))
						{
							res=res+s.pop();
						}
						s.push(c);
					}
				}
			}
			while(!s.isEmpty())
			{
				res=res+s.pop();
			}
			return res;
		}

		private static int precedence(Character c) {
			switch(c)
			{
			case '+':
			case '-': return 1;
			case '*':
			case '/':return 2;
			case '^':return 3;
			
			default:return -1;
			}
			
		} 
	

}
