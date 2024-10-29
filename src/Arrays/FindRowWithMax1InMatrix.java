package src.Arrays;

public class FindRowWithMax1InMatrix {

    public static void main(String[] args) {

        int mat[][] = { {0, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        System.out.print("Index of row with maximum 1s is " + rowWithMax1s(mat,4,4));
    }

    // O(M+N)
    private static int rowWithMax1s(int[][] mat, int rows, int cols) {
        int max = 0;
        int ans = 0;
        int row = 0;
        int col = cols-1;
        int cur =0;
        while(row<rows && col>=0) {
            if (mat[row][col] ==1) {
                col--;
                cur++;
                if (cur > max) {
                    max = cur;
                    ans = row;
                }
            } else {
                row++;
            }
        }
        return ans;
    }


    // Naive O(M*N)
//    private static int rowWithMax1s(int[][] mat, int rows, int cols) {
//        int max = 0;
//        int row = -1;
//        for (int i=0;i<rows;i++) {
//            int cnt = 0;
//            for (int j=0;j<cols;j++) {
//                if (mat[i][j] == 1){
//                    cnt++;
//                }
//            }
//            if (cnt > max) {
//                max = cnt;
//                row = i;
//            }
//        }
//
//        return row;
//    }


    // O(MLogN)
//    private static int rowWithMax1s(int[][] mat, int rows, int cols) {
//        int max = 0;
//        int row = -1;
//        for (int i=0; i< rows; i++) {
//            if (mat[i][cols - 1] == 1) {
//                int zeroIdx = findZeroIdx(mat, i, 0, cols-1);
//                int oneCount = cols - zeroIdx;
//                if (oneCount > max) {
//                    row = i;
//                    max = oneCount;
//                }
//            }
//        }
//
//        return row;
//    }
//
//    private static int findZeroIdx(int[][] mat, int row, int start, int end) {
//        int ans = -1;
//        while(start <= end) {
//            int mid = (start + end) / 2;
//            if (mat[row][mid] == 1) {
//                end = mid-1;
//            } else {
//                start = mid+1;
//                ans = mid;
//            }
//        }
//
//        return ans;
//    }
}
