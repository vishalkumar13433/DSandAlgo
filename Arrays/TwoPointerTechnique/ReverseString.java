package TwoPointerTechnique;

public class ReverseString {

	public static void main(String[] args) {
		String str = "Hello";
		reverseString(str.toCharArray());
	}

	public static void reverseString(char[] s) {

		int len = s.length;
		if(len<=1)return;
		int start = 0 , end = len-1;
		while(start < end) {
			char c = s[start];
			s[start] = s[end];
			s[end] = c;
			start++;
			end--;
		}
		System.out.println(s);
	}
	
}
