package src.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueenBacktracking {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		solveNQueens(n);
	}

	private static void solveNQueens(int n) {
		char[][]board=new char[n][n];
		for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					board[i][j]='.';
				}
			}
		findBoardConfig(board,0);
	}

	private static void findBoardConfig(char[][] board, int col) {
		//System.out.println("We are filling for column:"+col);
		if(col == board.length)
		{
			printConfig(board);
			return;
		}
		for(int row=0;row<board.length;row++)
		{
			if(!checkAttack(board,row,col))	
			{
				board[row][col]='Q';
				findBoardConfig(board,col+1);
				board[row][col]='.';
			}
		}
	}

	private static boolean checkAttack(char[][] board, int row, int col) {
    
	 	int i,j;
		//1.check for same row
		for(i=0;i<col;i++)
			if(board[row][i] == 'Q')
				return true;
		
		//check for diagonal attack
		i=row;j=col;
		while(i>=0 && j>=0)
		{
			if(board[i][j] == 'Q')
				return true;
			i--;
			j--;
		}
		
		//check for anti diagonal
		i=row;j=col;
		while(i<board.length && j>=0)
		{
			if(board[i][j] == 'Q')
				return true;
			i++;
			j--;
		}
		
        return false;
    }

	 
	private static void printConfig(char[][] board) {
		int n=board.length;
		for(int i=0;i<n;i++)
		{
			System.out.println();
			for(int j=0;j<n;j++)
			{
				System.out.print(board[i][j]+" ");
			}
		}
		System.out.println();
		System.out.println("----------------------");
		System.out.println();
	}

}
