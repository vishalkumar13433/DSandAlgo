public class SearchinaRowwiseColumnwiseSortedMatrix {

	public static void main(String[] args) {
		int mat[][] = { {1, 3, 5, 7}, 
                		{10,11,16,20}, 
                		{23,30,34,50} 
                	  }; 
      
			if(search(mat,11))
				System.out.println("11 is present"); 
			else
				System.out.println("Not present");
	}

	private static boolean search(int[][] mat, int key) {
		int row=mat.length;
		int col=mat[0].length;
		
		int i=0,j=col-1;
		while(i<row && j>0)
		{
			if(mat[i][j]==key)
					return true;
			if(mat[i][j] > key)
				j--;
			else
				i++;
		}
		return false;
	}


}
