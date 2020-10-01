
public class MaximumSizeSquareSubMatrixAll1s {

	public static void main(String[] args) {
		int M[][] = {{0,1,1,0,1},{1,1,1,0,0},{1,1,1,1,0},{1,1,1,0,1}}; 
          
		int n=printMaxSubSquare(M,M.length,M[0].length); 
		System.out.println("\nMaximum size sub-matrix is:"+n);
	}

	private static int printMaxSubSquare(int[][] mat, int row, int col) {
		
		int[][] memo=new int[row+1][col+1];
		int res=0;
		
		for(int i=0;i<row+1;i++)
		{
			for(int j=0;j<col+1;j++)
			{
				if(i==0 || j==0)
					{
						memo[i][j]=0;
					}
				else if(mat[i-1][j-1] == 0)
					{
						continue;
					}
				else
					{
					memo[i][j]=1 + Math.min(memo[i-1][j-1], Math.min(memo[i-1][j], memo[i][j-1]));
						if(memo[i][j] > res)
							res=memo[i][j];
					}
			}
		}
		System.out.println("Memoized:\n");
		for(int i=0;i<row+1;i++)
		{
			System.out.println();
			for(int j=0;j<col+1;j++)
			{
				System.out.print(memo[i][j] + " ");
			}
		}
		
		return res;
	}

}
