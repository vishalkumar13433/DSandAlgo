package Strings;

public class customIndexOF {

	 public static void main (String[] args)
	    {
	        // Empty string
	        compareFunc("", "");
	        compareFunc("A", "");
	        compareFunc("AB", "");
	        compareFunc("", "A");
	        compareFunc("", "AB");
	        // Equal non-empty strings
	        compareFunc("A", "A");
	        compareFunc("AB", "AB");
	        compareFunc("ABC", "A");
	        // Match at the beginning
	        compareFunc("A", "AB");
	        compareFunc("AB", "ABC");
	        compareFunc("ABC", "ABD");
	        // Match at the end
	        compareFunc("B", "AB");
	        compareFunc("BC", "ABC");
	        compareFunc("ABC", "DBC");
	        // Match at the middle
	        compareFunc("BC", "ABCD");
	        compareFunc("CD", "ABCDEF");
	        compareFunc("ABCDEF","CD");
	        // No match on longer strings
	        compareFunc("QWERTYUIOPASDFGHJKL", "ZXCVBNM");
	        compareFunc("ZXCVBNM","QWERTYUIOPASDFGHJKL");
	        System.out.println("Test successful");
	    }
	 public static int myIndexOf(char[] str, char[] substr) {
	        int len1=str.length,len2=substr.length;
	        if(len1<len2)
	        		return -1;
	        int i,j,cnt=0;
	        for(i=0;i<len1;i++)
	        {
	        	for(j=0;j<len2;j++)
	        	{
	        		if(str[i+j]== substr[j])
	        		{
	        			cnt++;
	        			if(cnt==len2)
	        					return i;
	        		}
	        		else
	        		{
	        			cnt=0;
	        			break;
	        		}
	        	}
	        }
	        return -1;
	    }

	    public static boolean compareFunc(String s1, String s2)
	    {
	        int r1 = s1.indexOf(s2);
	        int r2 = myIndexOf(s1.toCharArray(), s2.toCharArray());
	        boolean ret = (r1==r2);
	        System.out.println(ret + " for '" + s1 + "' '" + s2 + "' -> " + r1 + " " + r2);
	        return ret;
	    }

}
