package Strings;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class firstNonRepeatingCharacterInAString {

	public static void main (String[] args) 
    { 
        String str = "geeksforgeeks"; 
        int index =  firstNonRepeating(str); 
          
        System.out.println(index == -1 ? "Either all characters are repeating or string " + 
                   "is empty" : "First non-repeating character is " +  str.charAt(index)); 
    }

	private static int firstNonRepeating(String str) {
		/*HashMap<Character,Integer> hm = new HashMap<>();
		Set<Character> hs = new LinkedHashSet<>();
		
		int i=0;
		while(i < str.length()) {
			char c = str.charAt(i);
			if(!hm.containsKey(c)){
				hm.put(c, i);
				if(hs.contains(c)) {
					hs.remove(c);
				}else {
					hs.add(c);
				}
			}else if(hs.contains(c)) {
					hs.remove(c);
			}
			
			i++;
		}
		if(hs.isEmpty()) return -1;
		return hm.get(hs.iterator().next());*/
		
		//Method2
		/*for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(str.indexOf(c) == str.lastIndexOf(c)){
                return i;
            }
        }
        return -1;*/
		
		// Fastest Method
		int ind = Integer.MAX_VALUE , fIndex = -1 , lIndex = -1;
        for(char c='a' ; c<='z';c++){
            fIndex = str.indexOf(c);
            lIndex = str.lastIndexOf(c);
            if(fIndex != -1 && fIndex == lIndex){
                ind = Integer.min(ind , fIndex);
            }
        }
        
        return (ind != Integer.MAX_VALUE) ? ind : -1;
		
	} 
	
}
