package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KclosestElementToOrigin {

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;
		int[][] ans = kClosest(points, k);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i][0] + "," + ans[i][1]);
		}
	}

	public static int[][] kClosest(int[][] points, int K) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new CoordinateComparator());
		for(int i=0;i<points.length;i++) {
			pq.add(points[i]);
		}
		int[][] ans = new int[K][2];
		int i=0;
		while(i<K) {
			ans[i] = pq.poll();
			i++;
		}
		return ans;
	}
	static double calcDistanceFromOrigin(int x, int y) {
		return Math.sqrt(x*x + y*y);
	}
}

class CoordinateComparator implements Comparator<int[]>{

	@Override
	public int compare(int[] o1, int[] o2) {
		double d1 =  KclosestElementToOrigin.calcDistanceFromOrigin(o1[0], o1[1]);
		double d2 =  KclosestElementToOrigin.calcDistanceFromOrigin(o2[0], o2[1]);
		if(d1 > d2) return 1;
		else if(d1 < d2) return -1;
		else return 0;
	}
	
}
