import java.util.List;
import java.util.ArrayList;

public class SpiraPrinting {
	
	public static void main(String[] args) {
		 int a[][] = { {1,  2,  3,  4,  5,  6}, 
                 {7,  8,  9,  10, 11, 12}, 
                 {13, 14, 15, 16, 17, 18} 
               }; 
		 spiralOrder(a);
	}

	 public static void spiralOrder(int[][] matrix) {
		 
	        int i,j,r=0,c=0;
	        int row=matrix.length -1;
	        int col=matrix[0].length -1;
	        
	       while(r<=row && c<=col) {
	    	   
	    	   for(i=c;i<=col;i++)
		        	System.out.print(matrix[r][i] + " ");
		        r++;
		        
		       for(j=r;j<=row;j++)
		    	   System.out.print(matrix[j][col] + " ");
		        col--;
		        
		        
		       if(r<=row)	//IMP LINE .. try printing without it
		       for(i=col;i>=c;i--)
		    	   System.out.print(matrix[row][i] + " ");
		       row--;
		       
		       if(c<=col)	//IMP LINE .. try printing without it
		       for(j=row;j>=r;j--)
		    	   System.out.print(matrix[j][c] + " ");
		       c++;
	       }
	        
	 }
	
}
