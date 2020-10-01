

import java.util.Arrays;
import java.util.Stack;

public class MaxRectangleSubMatrixWithAll1s {

	public static void main(String[] args) {
		int R = 4; 
        int C = 4; 
  
        int A[][] = { {0, 1, 1, 0}, 
                      {1, 1, 1, 1}, 
                      {1, 1, 1, 1}, 
                      {1, 1, 0, 0}, 
                    }; 
        System.out.print("Area of maximum rectangle is " +  
                                  maxRectangle(R,C,A)); 
	}

	private static int maxRectangle(int rows, int cols, int[][] mat) {
		int[] histogram = new int[cols];
		int maxArea= 0;
		for(int i=0;i<rows;i++) {
			if(i == 0) {
				histogram = Arrays.copyOf(mat[i], cols);
			}else {
				for(int j=0;j<cols;j++) {
					if(mat[i][j] == 1) {
						histogram[j] += mat[i][j];
					}else {
						histogram[j] = 0;
					}
				}
			}
			
			int area = findMaxRectangleInAHistogram(histogram , histogram.length);
			System.out.println(area);
			maxArea = Integer.max(maxArea, area);
		}
		
		return maxArea;
	}

	private static int findMaxRectangleInAHistogram(int[] histogram, int length) {
		Stack<Integer> st = new Stack<>();
		int maxArea = 0;
		int i=0;
		while(i<length) {
			if(st.isEmpty() || histogram[i] >= histogram[st.peek()]) {
				st.push(i);
				i++;
			}else {
				int top = st.pop();
				int curArea = histogram[top] * ( st.isEmpty() ? i: i-st.peek()-1);
				maxArea = Integer.max(maxArea, curArea);
			}
		}
		
		while(!st.isEmpty()) {
			int top = st.pop();
			int curArea = histogram[top] * ( st.isEmpty() ? i: i-st.peek()-1);
			maxArea = Integer.max(maxArea, curArea);
		}
		return maxArea;
	}

}
