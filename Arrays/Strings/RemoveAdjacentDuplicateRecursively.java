package Strings;

import java.util.Stack;

public class RemoveAdjacentDuplicateRecursively {

	public static void main(String[] args) {

        String str1 = "geeksforgeeg"; 
        System.out.println(remove(str1)); 

        String str2 = "azxxxzy"; 
        System.out.println(remove(str2)); 

        String str3 = "caaabbbaac"; 
        System.out.println(remove(str3)); 

        String str4 = "gghhg"; 
        System.out.println(remove(str4)); 

        String str5 = "aaaacddddcappp"; 
        System.out.println(remove(str5)); 

        String str6 = "aaaaaaaaaa"; 
        System.out.println(remove(str6)); 

        String str7 = "qpaaaaadaaaaadprq"; 
        System.out.println(remove(str7)); 

        String str8 = "acaaabbbacdddd"; 
        System.out.println(remove(str8)); 
	}

	private static String remove(String str) {
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		if( n== 2) {
			if(str.charAt(0) == str.charAt(1)) return "";
			else return str;
		}
		int i=0 , sbLen = 0;
		while(i<n) {
			if(sbLen >0 && sb.charAt(sbLen-1) == str.charAt(i)) {
				sb.deleteCharAt(sbLen-1);
				sbLen--;
			}else {
				sb.append(str.charAt(i));
				sbLen++;
			}
			i++;
		}
		
		return sb.toString();
	}

}
