package src.DP;

import java.util.*;

public class Fibonacci {
	
	public static void main(String[] args) {
		int n=9;
		System.out.println(n+" th Fibonacci :"+fib(n));
	}
	
	private static int fib(int n) {
		//Basic Recursive Approach O(2^N)
		/*if( n <= 1) return n;
		return fib(n-1) + fib(n-2);*/
		
		//we can memoize the intermediate results
		/*int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return fibUtil(n , memo);*/
		
		//Bottom Up Approach
		if( n <= 1) return n;
		/*int[] memo = new int[n+1];
		memo[0] = 0;
		memo[1] = 1;
		for(int i=2 ; i<=n ; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];*/
		
		//We dont actually need array to store intermediate 
		//results, we just need last two results that we can
		//store in an array
		
		//O(N) time , O(1) space
		int a = 0 , b =1 ;
		for(int i=2 ; i<=n ; i++ ) {
			int c = a+b;
			a= b;
			b=c;
		}
		return b;
	}

	//O(N) as each numbers fib no we are calculating once
	//and reusing it. 
	//Space O(N)
	private static int fibUtil(int n, int[] memo) {
		if(n <=1) return n;
		if(memo[n] != -1) return memo[n];
		memo[n] = fibUtil(n-1 , memo) + fibUtil(n-2, memo);
		return memo[n];
	}

}
