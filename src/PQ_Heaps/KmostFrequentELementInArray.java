package src.PQ_Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class KmostFrequentELementInArray {

	public static void main(String[] args) {
		int arr[] = {3, 1, 4, 4, 5, 2, 6, 1}; 
		int k=2;
		List<Integer> ans = topKFrequent(arr, k);
		System.out.println(ans);
	}
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			hm.put(nums[i], 1+ hm.getOrDefault(nums[i],0));
		}
		//we are calculating count first and saving it so that, we don't have to pop every time
		//from the PQ and insert with the new count
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hm.get(a) - hm.get(b));
		for(Integer n:hm.keySet()) {
			pq.add(n);
			if(pq.size() > k) {
				pq.poll();	//keep only k frequent elements in pq
			}
		}
		List<Integer> top_k = new ArrayList<>();
	    while (!pq.isEmpty())
	      top_k.add(pq.poll());
	    Collections.reverse(top_k);
	    return top_k;
		
    }

}
