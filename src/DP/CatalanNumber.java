package DP;

import java.util.Arrays;

public class CatalanNumber {

	public static void main(String[] args) {
		int n=9;
		int cat = findCatalan(n);
		System.out.println(cat);
		int[] catalan = new int[n+1];
		Arrays.fill(catalan, -1);
		cat = findCatalanDP(n , catalan);
		System.out.println(cat);
	}

	private static int findCatalan(int n) {
		if(n <= 1) return 1;
		int res=0;
		for(int i=0 ;i<n;i++) {
			res += findCatalan(i) * findCatalan(n-i-1);
		}
		return res;
	}

	private static int findCatalanDP(int n , int[] catalan) {
		if(n <= 1) return 1;
		if(catalan[n] != -1) return catalan[n];
		int res=0;
		for(int i=0 ;i<n;i++) {
			res += findCatalanDP(i , catalan) * findCatalanDP(n-i-1 , catalan);
		}
		catalan[n] = res;
		return res;
	}
	
}
