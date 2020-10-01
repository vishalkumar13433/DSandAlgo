package TRIE;

public class Boggle {

	public static void main(String args[]) 
    { 
		Boggle bog = new Boggle();
        // Let the given dictionary be following 
        String dictionary[] = {"geeks", "for", "quiz", "go"}; 
       
        // root Node of trie 
        TRIETesting trie = new TRIETesting(); 
       
        // insert all words of dictionary into trie 
        int n = dictionary.length; 
        for (int i=0; i<n; i++) 
            trie.FillStringInTrie(dictionary[i].toCharArray()); 
       
        char boggle[][] = {{'g','i','z'}, 
                           {'u','e','k'}, 
                           {'q','s','e'} 
        }; 
        
//      trie.printAllStrings(trie.root, "");
       
        bog.findWords(boggle, trie.root); 
               
    }

	private void findWords(char[][] boggle, TRIENode root) {
		int rows= boggle.length;
		int cols = boggle[0].length;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				TRIENode temp = root;
				if(temp.chars[boggle[i][j] - 'a'] != null) {
					temp = temp.chars[boggle[i][j] - 'a'];
					boolean[][] visited = new boolean[rows][cols];
					findWordsUtil(boggle, i , j ,visited ,temp,""+boggle[i][j]);
				}
			}
		}
	}

	private boolean isOutOfBound(int row , int col , int rows ,int cols ,boolean[][] visited) {
		return (row < 0 || row>= rows || col <0 || col >= cols || visited[row][col]);
	}
	
	private void findWordsUtil(char[][] boggle, int row, int col, boolean[][] visited, TRIENode root, String strTillNow) {
		int rows= boggle.length;
		int cols = boggle[0].length; 
		
		if(root.isWord) {
			System.out.println(strTillNow);
		}
		
		if(isOutOfBound(row, col, rows, cols, visited)) {
			return;
		}
		
		visited[row][col] = true;
		for(int i=0;i<root.chars.length;i++) {
			if(root.chars[i] != null) {
				char cur = (char) ('a'+i);
				if(!isOutOfBound(row+1, col, rows, cols, visited) && cur == boggle[row+1][col])
					findWordsUtil(boggle, row+1, col, visited, root.chars[i], strTillNow + boggle[row+1][col]);
				if(!isOutOfBound(row-1, col, rows, cols, visited) && cur == boggle[row-1][col])
					findWordsUtil(boggle, row-1, col, visited, root.chars[i], strTillNow + boggle[row-1][col]);
				if(!isOutOfBound(row, col-1, rows, cols, visited) && cur == boggle[row][col-1])
					findWordsUtil(boggle, row, col-1, visited, root.chars[i], strTillNow + boggle[row][col-1]);
				if(!isOutOfBound(row, col+1, rows, cols, visited) && cur == boggle[row][col+1])
					findWordsUtil(boggle, row, col+1, visited, root.chars[i], strTillNow + boggle[row][col+1]);
				if(!isOutOfBound(row+1, col+1, rows, cols, visited) && cur == boggle[row+1][col+1])
					findWordsUtil(boggle, row+1, col+1, visited, root.chars[i], strTillNow + boggle[row+1][col+1]);
				if(!isOutOfBound(row-1, col-1, rows, cols, visited) && cur == boggle[row-1][col-1])
					findWordsUtil(boggle, row-1, col-1, visited, root.chars[i], strTillNow + boggle[row-1][col-1]);
				if(!isOutOfBound(row+1, col-1, rows, cols, visited) && cur == boggle[row+1][col-1])
					findWordsUtil(boggle, row+1, col-1, visited, root.chars[i], strTillNow + boggle[row+1][col-1]);
				if(!isOutOfBound(row-1, col+1, rows, cols, visited) && cur == boggle[row-1][col+1])
					findWordsUtil(boggle, row-1, col+1, visited, root.chars[i], strTillNow + boggle[row-1][col+1]);
			}
		}
		visited[row][col] = false;
		
	} 
	
}

