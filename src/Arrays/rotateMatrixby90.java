package src.Arrays;

public class rotateMatrixby90 {

	public static void main (String[] args)  
    { 
        int N = 4; 
          
        // Test Case 1 
        int mat[][] = 
        { 
            {1, 2, 3, 4}, 
            {5, 6, 7, 8}, 
            {9, 10, 11, 12}, 
            {13, 14, 15, 16} 
        }; 
       
        //Clockwise 90 deg using extra space
      //  rotateMatrix(N,mat); 
       
        //in-place rotation without using extra space
        rotateAntiClockwiseInplace(N,mat);
        
        // Print rotated matrix 
        displayMatrix(N,mat); 
    } 
	
	private static void rotateAntiClockwiseInplace(int n, int[][] mat) {
		
		//rotate 90 degree anticlockwise
		//Step 1: find transpose
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)	//j=i important else every element will be reversed twice and we will get the same matrix again
			{
				int temp=mat[i][j];
				mat[i][j]=mat[j][i];
				mat[j][i]=temp;
			}
		}
		//Step2: reverse every column
		
		for(int j=0;j<n;j++)
			{
				int k=n-1; 
				for(int i=0;i<k;i++)
				{
					int temp=mat[i][j];
					mat[i][j]=mat[k][j];
					mat[k][j]=temp;
					k--;
				}
			}
			
	}

	private static void rotateMatrix(int n, int[][] mat) {
		 //using extra space
		int[][] temp=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				temp[j][n-i-1]=mat[i][j];
			}
		}
	
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				mat[i][j]=temp[i][j];
			}
		}
   	
	}

	
	static void displayMatrix(int N, int mat[][]) 
    { 
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + mat[i][j]); 
       
            System.out.print("\n"); 
        } 
        System.out.print("\n"); 
    } 
	
}
