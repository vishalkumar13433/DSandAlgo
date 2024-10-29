package src.Arrays.SlidingWindowTechnique;

import java.util.HashMap;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String str = "ADOBECODEBANC";
        String pat = "ABC";
//		String str = "AA";
//        String pat = "AA";
        System.out.print("Smallest window is :\n " + 
                        findSubString(str, pat)); 
	}

	private static int findSubString(String str, String pat) {
		if(pat.length() == 0) return 0;
		int minWindow = Integer.MAX_VALUE;
		char[] str1 = str.toCharArray();
		char[] str2 = pat.toCharArray();
		HashMap<Character,Integer> charCountMap = new HashMap<>();
		for(char c : str2){
			int count = charCountMap.getOrDefault(c,0);
			charCountMap.put(c,1+count);
		}
		int totalChar = str2.length;
		int start = 0 , end = 0;
		while(end < str1.length) {
			char ch = str1[end];
			Integer count = charCountMap.get(ch);
			if (count != null) {
				charCountMap.put(ch, count - 1);
				totalChar--;
				while (totalChar == 0) {
					minWindow = Integer.min(minWindow, end - start + 1);
					if (charCountMap.get(str1[start]) != null) {
						charCountMap.put(str1[start], charCountMap.get(str1[start])+1);
						totalChar++;
					}
					start++;
				}
			}
			end++;
		}


		return Integer.min(minWindow, end -start+1);
	}

}
