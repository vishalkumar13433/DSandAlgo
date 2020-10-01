import java.util.LinkedList;
import java.util.Queue;

public class RottenTomatoes {
	
	 public static void main(String[] args)  
	    { 
	        int arr[][] = { {2, 1, 0, 2, 1}, 
	                        {1, 0, 1, 2, 1}, 
	                        {1, 0, 0, 2, 1}}; 
	        int ans = rotOranges(arr , arr.length , arr[0].length); 
	        if(ans == -1) 
	            System.out.println("All oranges cannot rot"); 
	        else
	            System.out.println("Time required for all oranges to rot = " + ans); 
	    }

	private static int rotOranges(int[][] arr , int rows , int cols) {
		Queue<TomatoQueueNode> q = new LinkedList<>();
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(arr[i][j] == 2) {
					q.add(new TomatoQueueNode(i, j, 0));
				}
			}
		}
		int time = 0;
		while(!q.isEmpty()) {
			TomatoQueueNode cur = q.poll();
			
			int row = cur.row;
			int col = cur.col;
			time= cur.traversalTime;
			if(isOutOfBound(row,col,rows,cols)) continue;
			//1. rot top 
			if(row>0 && arr[row-1][col] ==1) {
				arr[row-1][col] = 2;
				q.add(new TomatoQueueNode(row-1, col, time+1));
			}
			//2. rot left
			if(row<arr.length-1 && arr[row+1][col] ==1) {
				arr[row+1][col] = 2;
				q.add(new TomatoQueueNode(row+1, col, time+1));
			}
			//3. rot right
			if(col>0 && arr[row][col-1] ==1) {
				arr[row][col-1] = 2;
				q.add(new TomatoQueueNode(row, col-1, time+1));
				
			}
			//4. rot bottom
			if(col<arr[0].length-1 && arr[row][col+1] ==1) {
				arr[row][col+1] = 2;
				q.add(new TomatoQueueNode(row, col+1, time+1));
			}
		}
		for (int[] row: arr)
            for (int v: row)
                if (v == 1)
                    return -1;
		return time;
	}

	public static boolean isOutOfBound(int row,int col , int rows , int cols){
		return row < 0 || row > rows || col <0 || col > cols;
	}
	
}
