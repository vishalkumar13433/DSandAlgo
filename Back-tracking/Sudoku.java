
public class Sudoku {


	private static boolean solveSudoku(int[][] board, int n) {
		boolean complete=true;
		
		int row = -1,col = -1;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(board[i][j] == 0)
					{
						row=i;
						col=j;
						complete=false;
						break;
					}
			}
		}
		if(complete)
		{
			return true;
		}
		//fill values
		for(int k=1;k<10;k++)
		{
			if(isSafe(board,k,row,col))
			{
				//put value
				board[row][col]=k;
				
				//after filling if the sudoku is completed, return true
				if(solveSudoku(board,n))
					return true;
				else	//otherwise backtrack
					board[row][col]=0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int k, int row, int col) {
		
		return isSafeRow(board,k,row,col) && isSafeCol(board,k,row,col) && isSafeSquare(board,k,row,col);
	}

	private static boolean isSafeSquare(int[][] board, int num, int row, int col) {
		
		int row_start = row - (row %(int)Math.sqrt(board.length));
		int col_start = col - (col % (int)Math.sqrt(board.length));
		
		
		for(int i=row_start;i<row_start + (int)Math.sqrt(board.length);i++)
		{
			for(int j=col_start;j<col_start +(int)Math.sqrt(board.length) ;j++)
			{
				if(board[i][j]==num)
					return false;
			}
		}
		
		return true;
	}

	private static boolean isSafeCol(int[][] board, int num, int row, int col) {
		for(int i=0;i<board.length;i++)
		{
			if(board[i][col] == num)
				return false;
		}
		return true;
	}

	private static boolean isSafeRow(int[][] board, int num, int row, int col) {
		for(int i=0;i<board.length;i++)
		{
			if(board[row][i] == num)
				return false;
		}
		return true;
	}

	  
	public static void print(int[][] board, int N) 
	{ 
	    for (int r = 0; r < N; r++) 
	    { 
	        for (int d = 0; d < N; d++) 
	        { 
	            System.out.print(board[r][d]); 
	            System.out.print(" "); 
	        } 
	        System.out.print("\n"); 
	          
	        if ((r + 1) % (int) Math.sqrt(N) == 0)  
	        { 
	            System.out.print(""); 
	        } 
	    } 
	} 
	public static void main(String[] args) {
		int[][] board = new int[][] 
			    { 
			            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
			            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
			            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
			            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
			            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
			            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
			            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
			            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
			    }; 
			    int N = board.length; 
			  
			    if (solveSudoku(board, N)) 
			    { 
			        print(board, N); // print solution 
			    }  
			    else
			    { 
			        System.out.println("No solution"); 
			    } 
			}

}
