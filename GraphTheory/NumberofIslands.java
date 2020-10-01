package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DisjointSet.DisjointSetusingArrays;

public class NumberofIslands {

	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
            { 0, 1, 0, 0, 1 }, 
            { 1, 0, 0, 1, 1 }, 
            { 0, 0, 0, 0, 0 }, 
            { 1, 0, 1, 0, 1 } }; 
            NumberofIslands I = new NumberofIslands(); 
            //Noth method are setting grid value to 0 after processing.. so run only 1 at a time
//            System.out.println("Number of islands is: " + I.countIslands(M , M.length ,  M[0].length));
            System.out.println("Number of islands is : " + I.countIslandsUsingDisjointSet(M , M.length ,  M[0].length));
	}

	private int countIslandsUsingDisjointSet(int[][] grid , int rows  , int cols) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		DisjointSetusingArrays ds = new DisjointSetusingArrays(rows* cols);
		int cnt = 0;
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(grid[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(grid[i][j] == 0) {
					continue;
				}
				boolean belongsToAnyGroup = false;
				if(i-1 >=0 && grid[i-1][j] == 1) {
					ds.union(cols *i +j, cols * (i-1) + j);
					belongsToAnyGroup = true;
				}
				if(i+1 < rows && grid[i+1][j] == 1) {
					ds.union(cols *i +j, cols *(i+1) + j);
					belongsToAnyGroup = true;
				}
				
				if(j-1 >=0 && grid[i][j-1] == 1) {
					ds.union(cols *i +j, cols *i + j -1);
					belongsToAnyGroup = true;
				}
				if(j+1 < cols && grid[i][j+1] == 1) {
					ds.union(cols *i +j, cols *i + j+ 1);
					belongsToAnyGroup = true;
				}
				
				if(belongsToAnyGroup) cnt--;
				grid[i][j] = 0;
			}
		}
		
		return cnt;
	}

	private int countIslands(int[][] matrix, int rows, int cols) {
		int numberOfIslands = 0;
		for(int i=0 ; i< rows ; i++) {
			for(int j=0 ; j< cols; j++) {
				if(matrix[i][j] == 1) {
					DFS(i , j , matrix ,rows, cols);
					numberOfIslands++;
				}
			}
		}
		return numberOfIslands;
	}

	private void DFS(int row, int col, int[][] matrix, int totalrows, int totalcols) {
		
		if(row <0 || col <0 || row >= totalrows || col >= totalcols || matrix[row][col] == 0)
			return;
		//visit this node
		matrix[row][col] = 0;
		DFS(row-1 , col , matrix , totalrows, totalcols);
		DFS(row , col-1 , matrix , totalrows, totalcols);
		DFS(row+1 , col , matrix , totalrows, totalcols);
		DFS(row , col+1 , matrix , totalrows, totalcols);
	}

}
