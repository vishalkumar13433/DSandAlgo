
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};
		String word = "ABCCED";
//		String word = "SEE";
//		String word = "ABCB";
//		String word = "FDECA";
		System.out.println("Exists:" + exist(board, word));
	}

	public static boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(existUtil(board,word,visited,"",i , j))
					return true;
			}
		}
		return false;
	}

	private static boolean existUtil(char[][] board, String word, boolean[][] visited, 
			String wordTillNow, int row, int col) {
		if(row <0 || col<0 || row>=visited.length || col >= visited[0].length || visited[row][col])	
			return false;
		wordTillNow += board[row][col];
		visited[row][col] = true;
		if(word.equals(wordTillNow)) return true;
		boolean isFound = existUtil(board,word,visited,wordTillNow,row+1,col) || 
				existUtil(board,word,visited,wordTillNow,row,col-1)||
				existUtil(board,word,visited,wordTillNow,row-1,col)||
				existUtil(board,word,visited,wordTillNow,row,col+1);
		if(isFound) return true;
		visited[row][col] = false;
		return false;
	}
	
}
