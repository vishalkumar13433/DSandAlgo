package DP;

import java.util.Arrays;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {2,3,0,1,4};
//		int[] nums = {3,2,1,0,4};
		
		System.out.println(canJump(nums));
		System.out.println(optimizedCanJump(nums));
		
		int numJumps = jumpCount(nums);
		System.out.println(numJumps);
	}

	
	private static int jumpCount(int[] nums) {
		 if(nums.length <= 1) return 0;
	     int[] memo = new int[nums.length];
	     Arrays.fill(memo, -1);
	     memo[nums.length-1] = 0;
	     jumpCountFromPos(nums , 0 , memo);
	     return memo[0];
	}


	private static int jumpCountFromPos(int[] nums, int pos, int[] memo) {
		if(memo[pos] != -1)
			return memo[pos];
		
		int maxJumpFromCur = Integer.min(nums.length-1, pos + nums[pos]);
		int minJumps = Integer.MAX_VALUE;
		for(int i=pos+1;i<=maxJumpFromCur;i++) {
			minJumps = Integer.min(minJumps, jumpCountFromPos(nums,i,memo));
		}
		if(minJumps != Integer.MAX_VALUE) {
			memo[pos] = 1 + minJumps;
			return 1 + minJumps;
		}
		//if we do 1 + Integer.MAX ,  it becomes Integer.MIN
		return minJumps;
	}


	/*Iterating right-to-left, for each position we check 
	if there is a potential jump that reaches a GOOD index 
	(currPosition + nums[currPosition] >= leftmostGoodIndex). 
	If we can reach a GOOD index, then our position is itself GOOD. */
	private static boolean optimizedCanJump(int[] nums) {
		if(nums.length <= 1) return true;
		int lastIndexToReachEnd = nums.length-1;
		for(int i = nums.length-2 ; i>=0 ;i--) {
			if(nums[i] + i >= lastIndexToReachEnd) {
				lastIndexToReachEnd = i;
			}
		}
		return (lastIndexToReachEnd == 0);
	}

	//O(N)
	public static boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        boolean[] memo = new boolean[nums.length];
        memo[nums.length-1] = true;
        return canJumpFromPos(nums , 0 , memo);
    }
	// o(n^2)
	private static boolean canJumpFromPos(int[] nums, int pos , boolean[] memo) {

		if(memo[pos]) return true;
		int maxJumpFromCur = Integer.min(nums.length-1, pos + nums[pos]);
		for(int i=pos+1;i<=maxJumpFromCur;i++) {
			if(canJumpFromPos(nums,i, memo)) {
				memo[pos] = true;
				return true;
			}
		}
		memo[pos] = false;
		return false;
	}
	
	
}
