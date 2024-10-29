package src.backtracking;

public class CanPartitionArrayInKEqualSumSubset {

    public static void main(String[] args) {
        int[] arr= new int[] {4,3,2,3,5,2,1};
        int k=4;
        System.out.println(canPartitionKSubsets(arr, k));
    }

    // O(N * N!)
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n: nums) {
            sum+=n;
        }

        if( sum%k != 0) {
            return false;
        }

        int targetSum = sum / k;
        boolean[] taken = new boolean[nums.length];
        return canPartition(nums, k,0, targetSum,targetSum, taken);
    }

//    private static boolean canPartition(int[] nums, int k, int remaining, int targetSum, boolean[] taken) {
//        if (k==1) {
//            return true;
//        }
//
//        if(targetSum < 0) {
//            return false;
//        }
//
//        if (remaining == 0) {
//            return canPartition(nums, k-1, targetSum, targetSum, taken);
//        }
//
//        for (int i=0; i<taken.length;i++) {
//            if (!taken[i]) {
//                taken[i] = true;
//                if (canPartition(nums, k, remaining - nums[i], targetSum, taken)){
//                    return true;
//                }
//                taken[i] = false;
//            }
//        }
//
//        return false;
//    }

    private static boolean canPartition(int[] nums, int k, int curIdx, int curSum, int targetSum, boolean[] taken) {
        if (k==1) {
            return true;
        }

        if(curSum > targetSum) {
            return false;
        }

        if (targetSum == curSum) {
        //  resetting cur idx to 0 as we have to starting picking idx from 0
            return canPartition(nums,  k-1, 0, 0, targetSum, taken);
        }

        // we can start from curIdx as we have to go forward from this idx
        for (int i=curIdx; i<taken.length;i++) {
            if (!taken[i]) {
                taken[i] = true;
                if (canPartition(nums, k, i+1,curSum + nums[i], targetSum, taken)){
                    return true;
                }
                taken[i] = false;
            }
        }

        return false;
    }


}
