package src.StackAndQueue;

import java.io.*;
import java.util.Stack;

public class reverseWordsInAString {
	public static void main(String[] args) 
	{ 
	   String str="";
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  try {
		str=br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   reverseWords(str); 
	}

	private static void reverseWords(String str) {
		/*Stack<Character> s=new Stack();
			String s1=new String();
			for(int i=0;i<str.length();i++)
			{
				if(str.charAt(i) == ' ')
				{
					while(!s.isEmpty())
						s1=s1+s.pop();
					s1=s1+" ";
				}
				else
					s.push(str.charAt(i));
			}
			while(!s.isEmpty())
				s1=s1+s.pop();
			 str=s1.substring(0, s1.length());
			 System.out.println(str);
			 */
			str+=' ';
			char[] c=str.toCharArray();
			
			int word_begin=0;
			int i=0;
			while(i<c.length)
			{
				
					if(c[i]==' ')
					{
						reverse(c,word_begin,i-1);
						word_begin=i+1;
					}
					i++;
			}
			reverse(c,0,i-1);
		for(i=0;i<c.length;i++)
			System.out.print(c[i]);
	}

	private static void reverse(char[] c, int start, int end) {
		
		while(start<end)
		{
			char temp=c[start];
			c[start]=c[end];
			c[end]=temp;
			
			start++;
			end--;
		}
	} 
}
