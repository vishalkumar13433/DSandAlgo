package Arrays;

import java.util.*;
public class MajorityElement {

	public static void main(String[] args) {
		int arr[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		System.out.print("Majority Element:\n");
		 findMajority(arr, arr.length); 
	}

	private static void findMajority(int[] arr, int n) {
		//Method 1 : Time Complexity = O(n^2)
/*		
 * 		if(n==1)
 * 			System.out.print(arr[i]);
 * 		for(int i=0;i<n;i++)
		{
			int cnt=1;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]==arr[i])
					cnt++;
				if(cnt > n/2)
					System.out.print(arr[i]);
			}
		}
	
*/	
		//Method 2 :Time Complexity = O(n) and O(n) space
		/*	Map<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			int x=(hm.get(arr[i]) == null)?1:hm.get(arr[i])+1;
			if(x > n/2)
				{
					System.out.print(arr[i]);
					return;
				}
			hm.put(arr[i], x);
		}
		*/
		
		//Method 3 : Moore�s Voting Algorithm
		//Time Complexity = O(n) and O(1) space
		int x=findCandidate(arr,n);
		if(checkMajority(arr,x,n))
			System.out.println(x);
		else
			System.out.println("No Majority Element");
	}

	private static boolean checkMajority(int[] arr,int x,int n) {
		int cnt=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]==x)
				cnt++;
		}
		if(cnt>n/2)
			return true;
		return false;
	}

	private static int findCandidate(int[] arr, int n) {
		int maj_ind=0,i=0,cnt=0;
		while(i<n)
		{
			
			if(arr[i]==arr[maj_ind])
				cnt++;
			else
				cnt--;
			if(cnt==0)
			{
				maj_ind=i;
				cnt=1;
			}
			i++;
		}
		return arr[maj_ind];
	}		
}
