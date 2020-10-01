package Arrays.SlidingWindowTechnique;

import java.util.HashMap;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
//		String str = "ADOBECODEBANC"; 
//        String pat = "ABC"; 
		String str = "AA"; 
        String pat = "AA"; 
        System.out.print("Smallest window is :\n " + 
                        findSubString(str, pat)); 
	}

	private static String findSubString(String str, String pat) {
		int strLen = str.length();
		int patLen = pat.length();
		if(strLen < patLen) {
			return "";
		}
		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i=0;i<patLen;i++) {
			hm.put(pat.charAt(i), 1 + hm.getOrDefault(pat.charAt(i),0));
		}
		int minWindow = Integer.MAX_VALUE;
		int end = 0 , start = 0 ,cnt=patLen , windowStart = start;
		while(end < strLen) {
			char c = str.charAt(end);
			if(hm.getOrDefault(c, 0) > 0) {
				//reduce cnt only if character belongs to second string
				cnt--; 
			}
			//reduce freq for every character
			hm.put(c,  hm.getOrDefault(c,0)-1);
			end++;
			while(cnt == 0) {
				if(minWindow > end-start) {
					minWindow = end-start;
					windowStart = start;
				}
				//make window invalid
				c = str.charAt(start);
				if(hm.getOrDefault(c, 0) == 0) {
					cnt++;
				}
				hm.put(c,  hm.get(c)+1);
				start++;
			}
		}
		System.out.println(minWindow);
		System.out.println(windowStart);
		return minWindow ==Integer.MAX_VALUE? "":str.substring(windowStart, windowStart+minWindow);
	}

}
