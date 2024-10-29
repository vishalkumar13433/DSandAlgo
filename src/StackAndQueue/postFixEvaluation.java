package src.StackAndQueue;

import java.util.Stack;

public class postFixEvaluation {

	public static void main(String[] args) {
		String exp="231*+9-"; 
       System.out.println("postfix evaluation: "+evaluatePostfix(exp)); 
		
	}

	private static int evaluatePostfix(String exp) {
		
		Stack<Integer> s=new Stack<>();
		for(int i=0;i<exp.length();i++)
		{
			char c=exp.charAt(i);
			if(Character.isDigit(c))
			{
				s.push(c-'0');
			}
			else
			{
				int val2=s.pop();
				int val1=s.pop();
				switch(c)
				{
				case '+':s.push(val1 + val2);
						break;
				case '-':s.push(val1 - val2);
						break;
				case '*':s.push(val1 * val2);
						break;
				case '/':s.push(val1 / val2);
						break;
				}
			}
		}
		return s.pop();
	}

}
