package Arrays.Strings;

public class countWordsInaString {

	public static void main(String[] args) {
		 String str = "One two       three\n four\tfive  "; 
	        System.out.println("No of words : " + countWords(str)); 
	}

	private static int countWords(String str) {
		int i=0,cnt=0;
		boolean end=true;	// to count first character also
		while(i<str.length())
		{
			if(str.charAt(i)==' ' || str.charAt(i) == '\n' || str.charAt(i)=='\t')
			{
				end=true;
			}
			else if(end)	
			{
				end=false;
				cnt++;
			}
			i++;
		}
		return cnt;
	}

}
