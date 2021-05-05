package StackAndQueue;
import java.util.Stack;

public class checkParanthesis {

	public static void main(String[] args) {
			String s1="if(a(4)>9) {foo(a(2));}";
			String s2="for(i=0;i<a(3};i++) {foo{);)";
			String s3="while(true) }{ ()";
			String s4="if(x) {";
			String s5="}";
			System.out.println(checkParan(s1));
			System.out.println(checkParan(s2));
			System.out.println(checkParan(s3));
			System.out.println(checkParan(s4));
			System.out.println(checkParan(s5));
	}

	private static boolean checkParan(String s) {
		if(s.isEmpty())
				return true;
		Stack<Character> st =new Stack<>();
		
		  for (Character ch : s.toCharArray()){
			  if((ch=='{') || (ch=='(') || (ch=='['))
			  {
				  st.push(ch);
			  }
			  else if((ch=='}') || (ch==')') || (ch==']'))
			  {
				  if(st.empty())
					  	return false;
				  Character c=st.peek();
				  if(!checkPair(c,ch))
					  return false;
				  else
					  st.pop();
			  }
			  
		    }
		  if(st.empty())
			  return true;
		  return false;
				 
	}

	private static boolean checkPair(Character c, Character ch) {
		if(c=='(' && ch==')')
			return true;
		if(c=='[' && ch==']')
			return true;
		if(c=='{' && ch=='}')
			return true;
		return false;
	}

}
