import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) 
    { 
        String str = "ABDEFGABEF"; 
        System.out.println("The input string is " + str); 
        int len = longestUniqueSubsttr(str); 
        System.out.println("The length of "
                           + "the longest non repeating character is " + len); 
    }

	private static int longestUniqueSubsttr(String str) {

		int maxLen  = 0;
		HashMap<Character , Integer> hm = new HashMap<>();
		int start = 0;
		for(int i=0;i<str.length();i++) {
			//if its a repeated character
			if(hm.containsKey(str.charAt(i))) {
				//next substring start either from start in case the 
				//character that got repeated was starting char
				//otherwise the index of repeating char + 1
				start = Integer.max(start, hm.get(str.charAt(i)) + 1);
			}
			hm.put(str.charAt(i),i);
			maxLen = Integer.max(maxLen, i-start+1);
		}
		
		return maxLen;
	} 
	
}
