package src.Arrays;

import java.util.Arrays;

public class numberOfPlatforms {

	public static void main(String[] args) {
		 int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		    int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		    int n = arr.length; 
		    System.out.println("Minimum Number of Platforms Required = "
		                        + findPlatform(arr, dep, n));
		System.out.println("Minimum Number of Platforms Required = "
				+ findPlatform2(arr, dep, n));
	}

	private static int findPlatform(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int cnt=0,max_cnt=0;;
		int i=0,j=0;
		while(i<n && j<n)
		{
			if(arr[i] <= dep[j])
			{
				cnt++;
				i++;
				
				if(cnt > max_cnt)
					max_cnt=cnt;
			}
			else
			{
				cnt--;
				j++;
			}
		}
		return max_cnt;
	}

	private static int findPlatform2(int[] arr, int[] dep, int n) {
		int min = 1;
		int cur = 1;
		int i = 1;
		int j=0;
		while(i < n) {
			if (arr[i] > dep[j]) {
				cur--;
				j++;
			} else {
				cur++;
				min = Math.max(min, cur);
				i++;
			}
		}


		return min;
	}

}
