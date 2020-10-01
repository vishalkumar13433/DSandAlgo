package Strings;

public class StringSearching {

	 public static void main(String args[]) 
	    { 
	        String s1 = "for"; 
	        String s2 = "geeksforgeeks"; 
	          
	        int res = isSubstring(s1, s2); 
	          
	        if (res == -1) 
	            System.out.println("Not present"); 
	        else
	            System.out.println("Present at index "  
	                                           + res); 
	    }

	private static int isSubstring(String s1, String s2) {
		int l1=s1.length();
		int l2=s2.length();
		int j;
		for(int i=0;i<l2-l1;i++)
		{
			for(j=0;j<l1;j++)
			{
				if(s1.charAt(j) != s2.charAt(i+j))
					break;
				
			}
			if(j==l1)
				return i;
		}
		return -1;
	} 

}
