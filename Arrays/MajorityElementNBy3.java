

public class MajorityElementNBy3 {

	 public static void main(String args[]) 
	    { 
	        int arr[] = { 1, 2, 3, 1, 1 }; 
	        int n = arr.length; 
	        System.out.println(appearsNBy3(arr, n)); 
	    }

	private static int appearsNBy3(int[] arr, int n) {
		int maj1 = Integer.MAX_VALUE, maj2 = Integer.MAX_VALUE;
		int cnt1 = 0, cnt2 =0;
		
		for(int i=0;i<n;i++) {
			if(arr[i] == maj1) {
				cnt1++;
			}else if(arr[i] == maj2) {
				cnt2++;
			}else if(cnt1 ==0){
				maj1 = arr[i];
				cnt1++;
			}else if( cnt2 ==0) {
				maj2 = arr[i];
				cnt2++;
			} else {
				cnt1--;
				cnt2--;
			}
			
		}
		int count1 = 0; 
        int count2 = 0; 
      
        // Again traverse the array and  
        // find the actual counts. 
        for (int i = 0; i < n; i++) { 
            if (arr[i] == maj1) 
                count1++; 
      
            else if (arr[i] == maj2) 
                count2++; 
        } 
      
        if (count1 > n / 3) 
            return maj1; 
      
        if (count2 > n / 3) 
            return maj2; 
      
        return -1; 
	} 
}
