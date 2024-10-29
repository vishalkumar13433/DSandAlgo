package src.Arrays.Strings;
import java.util.HashSet;

public class countnoofWordsPresentinString {

	public static void main(String[] args) {
		String word[] = { "welcome", "to", "geeks", "portal"}; 
        
        String str = "geeksforgeeks is a computer science portal for geeks."; 
          
        System.out.println(countOccurrence(word,str)); 
	}

	private static int countOccurrence(String[] word, String str) {
		int cnt=0;
		HashSet<String> hs=new HashSet();
		for(String s:word)
		{
			hs.add(s);
		}
		String s=new String();
		int i=0;
		while(i<str.length())
		{
			if(str.charAt(i) == ' ' || str.charAt(i)==',' || str.charAt(i)=='.')
			{
				System.out.println(s);	
				if(hs.contains(s))
					{
						System.out.println("Found: " + s);	
						cnt++;
					}
				s="";
			}
			else
			{
				s+=str.charAt(i);
			}
			i++;
		}
		
		return cnt;
		
	}

}
