package DP;

public class longestPalindromicSubstring {

	public static void main(String[] args) { 
        String str = "cbbd"; 
        System.out.println("Length is: " + longestPalSubstr(str)); 
    }

	private static int longestPalSubstr(String str) {
		if(str.length() == 0 || str.length() == 1 || (str.length() == 2 && str.charAt(0)== str.charAt(1))) return str.length();
		boolean[][] pal = new boolean[str.length()][str.length()];
		
		int maxLength = 1;	// single char is a palindrome of length 1
		for(int i=0;i<str.length();i++) {
			pal[i][i] = true;
		}
		
		// for substring length 2
		int start = 0;
		for(int i=0 ;i<str.length()-1;i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				pal[i][i+1] = true;
				start = i;
				maxLength = 2;	//found a substring of length 2
			}
		}
		
		//substring of length more than or equal to 3
		
		for(int sublen=3 ;sublen <= str.length();sublen++) {
			for(int i=0; i< str.length() - sublen + 1;i++) {
				int j = sublen + i -1;
				if(str.charAt(i) == str.charAt(j) && pal[i+1][j-1]) {
					pal[i][j] = true;
					if(j-i+1 > maxLength) {
						start = i;
						maxLength = j-i+1;
					}
				}
			}
		}
		String finalSubstring = str.substring(start , start+maxLength);
		System.out.println(finalSubstring);
		return maxLength;
	} 
	
}
