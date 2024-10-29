package src.Arrays.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class printAnagramsTogether {

	public static void main(String[] args) 
    { 
        // Driver program 
        String arr[] = { "cat", "dog", "tac", "god", "act" }; 
        printAnagrams(arr); 
    }

	private static void printAnagrams(String[] arr) {
		HashMap<String,List<String>> hm = new HashMap<>();
		for(String s:arr) {
			char[] chArr = s.toCharArray();
			Arrays.sort(chArr);
			String sortedStr = String.valueOf(chArr);
			List<String> anagrams;
			if(hm.containsKey(sortedStr)) {
				anagrams = hm.get(sortedStr);
			}else {
				anagrams = new ArrayList<String>();
			}
			anagrams.add(s);
			hm.put(sortedStr, anagrams);
		}
		
		for(String s : hm.keySet()) {
			List<String> anagrams = hm.get(s);
			System.out.println(anagrams);
		}
	} 
	
}
