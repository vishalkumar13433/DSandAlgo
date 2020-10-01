

import java.util.Stack;

public class LongestValidParanthesis {

	public static void main(String[] args)  
    { 
        String str = "((()()"; 
        System.out.println(longestValidPara(str)); 
        System.out.println(longestValidParaUsingStack(str)); 
        str = "()(()))))"; 
        System.out.println(longestValidPara(str)); 
        System.out.println(longestValidParaUsingStack(str)); 
       
    }
	private static int longestValidParaUsingStack(String str) {
		if(str.length() <= 1) return 0;
		Stack<Integer> st= new Stack<>();	//peek will tell till which index we have valid paran
		st.push(-1);	
		int i=0;
		int maxLen = 0;
		while(i<str.length()) {
			if(str.charAt(i) == '(') {
				st.push(i);
			}else {
				st.pop();
				if(!st.isEmpty()) {
					maxLen = Integer.max(maxLen, i - st.peek());
				}else {
					st.push(i);
				}
			}
			
			i++;
		}
		return maxLen;
	}
	//O(n^3) as O(n^2) for generating all sub and O(n) for valid check
	//taking all substrings and checking whether it is a valid or not
	private static int longestValidPara(String str) {
		if(str.length() <= 1) return 0;
		int maxLen = 0;
		for(int i=0;i<str.length()-1;i++) {
			for(int j=i+2;j<=str.length();j++) {
				if(checkIsValidParan(str.substring(i, j))) {
					maxLen =Integer.max(maxLen, j-i);
				}
			}
		}
		
		return maxLen;
	}

	private static boolean checkIsValidParan(String substring) {
		if(substring.length() ==0) return true;
		if(substring.length() == 1) return false;
		
		Stack<Character> s = new Stack<>(); 
		int i=0;
		while(i< substring.length()) {
			if(substring.charAt(i) == '(') {
				s.push('(');
			}else {
				if(s.isEmpty() || s.peek() != '(') {
					return false;
				}else {
					s.pop();
				}
			}
			
			i++;
		}
		return s.isEmpty();
	} 
}
