package Arrays;

public class LargestSumContigousSubArray {

	public static void main(String[] args) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        System.out.println("Maximum contiguous sum is " + 
                                       maxSubArraySum(a)); 
	}

	private static int maxSubArraySum(int[] a) {
		if(a.length == 0) return 0 ;
		
		int msf = 0 , mst = 0;
		for(int i=0;i<a.length;i++) {
			/*mst = mst + a[i];
			if(mst < 0) {
				mst = 0;
			}else {
				msf = Integer.max(msf, mst);
			}
			*/
			mst = Integer.max(mst + a[i], a[i]);
			msf= Integer.max(msf, mst);
		}
		
		
		
		return msf;
	}

}
