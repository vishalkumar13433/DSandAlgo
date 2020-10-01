package GraphTheory;

public class Boggle {

	static final String dictionary[] = { "GEEKS", "FOR", "QUIZ" , "MATCH"}; 
    static final int n = dictionary.length; 
    static final int M = 3, N = 3; 
	
    public static boolean isSearchWord(String str) {
    	for(int i=0; i< dictionary.length ; i++) {
    		if(str.equals(dictionary[i]))
    				return true;
    	}
    	return false;
    }
    
	 public static void main(String args[]) 
	    { 
	        char boggle[][] = { { 'G', 'I', 'Z' }, 
	                            { 'U', 'E', 'K' }, 
	                            { 'Q', 'S', 'E' } }; 
	  
	        System.out.println("Following words of dictionary are present"); 
	        findWords(boggle); 
	    }

	private static void findWords(char[][] boggle) {
		boolean[][] visited = new boolean[M][N];

		for(int i=0; i<boggle.length ; i++) {
			for(int j=0; j<boggle[0].length ; j++) {
				String s = "";
				findWordsUtil(i , j , s , boggle , visited);
			}
		}
	}

	private static void findWordsUtil(int row, int col, String stringTillNow, char[][] boggle, boolean[][] visited) {

		visited[row][col] = true;	
		stringTillNow = stringTillNow + boggle[row][col];	
		
		if( isSearchWord(stringTillNow)) {
			System.out.println(stringTillNow);
		}
		
		//need to traverse all 8 adjacent element for this cell for 
		//next character
		
		for(int i= row-1 ; i<= row+1 && i < boggle.length; i++) {
			for(int j= col-1 ;j<= col+1 &&  j <boggle[0].length; j++) {
				if(i>=0 && j>=0 && !visited[i][j])
					findWordsUtil(i, j ,stringTillNow, boggle, visited);
			}
		}
		
		
		stringTillNow = stringTillNow.substring(0, stringTillNow.length()-1);	
		visited[row][col] = false;
		
	} 
	
}
