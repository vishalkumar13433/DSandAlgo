package SlidingWindowTechnique;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		 int arr[] = {1,2,3,1,4,5,2,3,6}; 
	     int k = 3; 
	     printKMax(arr, arr.length, k);
	}

	private static void printKMax(int[] arr, int n, int k) {
		if(k==0) return;
		Deque<Integer> q = new LinkedList<>(); 
		int i=0;
		while(i<k) {
			while(!q.isEmpty() && arr[q.getLast()]<=arr[i]) {
				q.removeLast();
			}
			q.addLast(i);
			i++;
		}
		System.out.print(arr[q.getFirst()] + " ");
		while(i<n) {
			while(!q.isEmpty() && arr[q.getLast()]<=arr[i]) {
				q.removeLast();
			}
			while(!q.isEmpty() && i - q.getFirst() > k) {
				q.removeFirst();
			}
			q.addLast(i);
			System.out.print(arr[q.getFirst()] + " ");
			i++;
		}
	}

}
