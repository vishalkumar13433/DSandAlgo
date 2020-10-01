
import java.util.Arrays;

public class nextGreaterPermutation {

	public static void main(String[] args) {
		int[] nums = new int[] {5,3,4,9,7,6};
		nextGreaterPermut(nums , nums.length);
		for(int i=0; i< nums.length ; i++) {
			System.out.print(nums[i] +  " ");
		}
	}

	private static void nextGreaterPermut(int[] nums, int length) {
		if(length <= 1) {
			return;
		}
		int i=length-1;
		while(i>0 && nums[i] < nums[i-1]) {
			i--;
		}
		if(i == 0) {
			System.out.print("Not Possible \n");
			return;
		}
		int swap = i-1 , min = i;
		while(i < nums.length) {
			if(nums[i] > nums[swap] && nums[min] > nums[i]) {
				min = i;
			}
			i++;
		}
		
		int temp = nums[swap];
		nums[swap] = nums[min];
		nums[min] = temp;
		Arrays.sort(nums, swap + 1, length);
		
	}

}
