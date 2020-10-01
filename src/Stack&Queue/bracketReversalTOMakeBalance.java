import java.util.Stack;

public class bracketReversalTOMakeBalance {

	public static void main(String[] args)  { 
        String expr = "{}}{}{"; 
          
        System.out.println(countMinReversals(expr)); 
    }

	private static int countMinReversals(String expr) {
		if(expr.length()%2 !=0)
				return -1;
		Stack<Character> s=new Stack();
		char[]c=expr.toCharArray();
		int opening_cnt=0,closing_cnt=0;
		int i=0;
		//removing balanced parenthesis
		while(i<c.length)
		{
			if(c[i] == '}' && !s.empty() && s.peek()=='{')
			{
					s.pop();
			}
			else
			{
				s.push(c[i]);
			}
			i++;
		}
		//count of unbalanced parenthesis
		int unbalanced=s.size();
		while(!s.empty() && s.peek()=='{') 
		{
			s.pop();
			opening_cnt++;
		}
		closing_cnt=unbalanced - opening_cnt;
		System.out.println("unbalanced:"+unbalanced);
		System.out.println("opening:"+opening_cnt);
		System.out.println("closing:"+closing_cnt);
		return ceil(closing_cnt,2) + ceil(opening_cnt,2);
	}

	private static int ceil(int i, int j) {
		int val;
		if(i%j == 0)
				val=i/j;
		else
				val= (i/j)+(i%j);
		return val;
	} 

}
