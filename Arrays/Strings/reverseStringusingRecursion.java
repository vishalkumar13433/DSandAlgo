package Strings;

public class reverseStringusingRecursion {

	public static void main(String[] args) {
		String s="Vishal";
		char c[]= s.toCharArray();
		
		reverse(c);
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]);
	}

	private static void reverse(char[] c) {
	
		reverse_Helper(c,0,c.length -1);
	}

	private static void reverse_Helper(char[] c, int start, int end) {
		if(start > end)
			return;
		char ch=c[start];
		c[start]=c[end];
		c[end]=ch;
		reverse_Helper(c,start+1,end-1);
	}

}
