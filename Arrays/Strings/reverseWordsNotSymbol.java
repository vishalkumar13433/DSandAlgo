package Strings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class reverseWordsNotSymbol {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		System.out.print(reverseOnlyLetters(s));
	}

	private static String reverseOnlyLetters(String s) {
		Stack<Character> st=new Stack();
		char[] c=s.toCharArray();
		for(int i=0;i<c.length;i++)
		{
			if(( (int)c[i] >=65 && (int)c[i] <=90) || ( (int)c[i] >=97 && (int)c[i] <=122))
			{
				st.push(c[i]);
			}
		}
		for(int i=0;i<c.length;i++)
		{
			if(( (int)c[i] >=65 && (int)c[i] <=90) || ( (int)c[i] >=97 && (int)c[i] <=122))
			{
				c[i]=st.pop();
			}
		}
		String str=new String(c);
		return str;
	}

}
