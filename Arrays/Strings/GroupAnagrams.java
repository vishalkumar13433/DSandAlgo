package Strings;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> ls= groupAnagrams(strs);
		for(List<String> l : ls) {
			System.out.println();
			for(String s: l)
				System.out.print(s + " ,");
		}
	}
	
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> hm = new HashMap<>();
        for(String str:strs) {
        	char[] charArray = str.toCharArray();
        	Arrays.sort(charArray);
        	String sortedString = String.valueOf(charArray);
        	List<String> s;
        	if(!hm.containsKey(sortedString)) {
        		 s= new ArrayList<>();
        	}else {
        		s = hm.get(sortedString);
        	}
    		s.add(str);
    		hm.put(sortedString, s);
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        for(List<String> l : hm.values()) {
        	ans.add(l);
        }
        
        return ans;
    }
}
