package src.Arrays.Strings;


public class DecodeString {
	public static int startIndex = 0;
	public static void main(String[] args) {
//		String s = "3[a]2[bc]";// return "aaabcbc".
		String s = "3[a2[c]]"; // return "accaccacc".
		//String s = "2[abc]3[cd]ef"; //return "abcabccdcdcdef"
		//String s = "a23[b]"; //return abbbbbbbbbbbbbbbbbbbbbbb";
		String decodedString = decodeString(s);
		System.out.println(decodedString);
		
	}

	private static String decodeString(String s) {
		if(startIndex == s.length()-1) return s;
		StringBuilder result = new StringBuilder();
		while(startIndex <s.length() && s.charAt(startIndex) != ']') {
			if(!Character.isDigit(s.charAt(startIndex))) {
				result.append(s.charAt(startIndex));
				startIndex++;
			}else {
				int count =0;
				while(startIndex < s.length() && Character.isDigit(s.charAt(startIndex))) {
					count = count*10 + (s.charAt(startIndex)-'0');
					startIndex++;
				}
				startIndex++; //every number is followed by a '['
				String forwardRes = decodeString(s);
				startIndex++; // it is finished by a ']'
				
				while(count-- > 0) {
					result.append(forwardRes);
				}
				
			}
			
		}
		return result.toString();
		
	}

}
