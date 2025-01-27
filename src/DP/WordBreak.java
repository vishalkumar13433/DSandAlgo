package src.DP;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	private static Set<String> dictionary = new HashSet<>(); 
	public static void main(String[] args) {
		String temp_dictionary[] = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		// loop to add all strings in dictionary set
		for (String temp : temp_dictionary) {
			dictionary.add(temp);
		}

		// sample input cases
//		System.out.println(wordBreak("ilikesamsung"));
//		System.out.println(wordBreak("iiiiiiii"));
//		System.out.println(wordBreak(""));
//		System.out.println(wordBreak("ilikelikeimangoiii"));
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));

	}

	private static boolean wordBreak(String str) {
		int size = str.length();
		if(size == 0) return true;
		System.out.println(str);
		for(int i=1;i<=str.length();i++) {
			if(dictionary.contains(str.substring(0, i)) && wordBreak(str.substring(i, size)))
				return true;
		}
		return false;
	}

}
