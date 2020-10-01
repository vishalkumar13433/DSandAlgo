package ImpQuestion;

public class numberOfIsland {

	public static void main(String[] args) throws java.lang.Exception {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		numberOfIsland I = new numberOfIsland();
		System.out.println("Number of islands is: " + I.countIslands(M));
	}

	private int countIslands(int[][] mat) {
		if(mat.length == 0) return 0;
		
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		int islandCnt = 0;
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(mat[i][j] == 1) {
					islandCnt += traverseConnection(mat,i,j,visited);
					visited[i][j] = true;
				}
			}
		}
		return islandCnt;
	}

	private int traverseConnection(int[][] mat, int row, int col, boolean[][] visited) {
		if(row <0 || col<0 || row>=mat.length || col >= mat[0].length || mat[row][col] == 0 || visited[row][col])
			return 0;
		visited[row][col] = true;
		traverseConnection(mat,row,col-1,visited);
		traverseConnection(mat, row-1, col, visited);
		traverseConnection(mat, row+1, col, visited);
		traverseConnection(mat, row, col+1, visited);
		return 1;
	}

}
