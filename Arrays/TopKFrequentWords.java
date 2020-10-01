

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public static void main(String[] args) {
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k = 4;
		List<String> ans = topKFrequent(words , k);
		System.out.println(ans);
	}

	 public static List<String> topKFrequent(String[] words, int k) {
		 List<String> ans = new ArrayList<String>();
	     if(words.length == 0 || k ==0) return ans;
	     HashMap<String,Integer> hm = new HashMap<>();
	     for(String s:words) {
	    	hm.put(s, 1 + hm.getOrDefault(s, 0));
	     }
	     PriorityQueue<String> pq = new PriorityQueue<>((s1,s2) -> hm.get(s1).equals(hm.get(s2)) ? s2.compareTo(s1) : hm.get(s1) - hm.get(s2));
	     for(String s:hm.keySet()) {
	    	 pq.offer(s);
	    	 if(pq.size() > k) {
	    		 pq.poll();
	    	 }
	     }
	     System.out.println(pq);
	     while(k-- > 0) {
	    	 String s = pq.poll();
	    	 ans.add(s);
	     }
	     Collections.reverse(ans);
	     return ans;
	 }
	
}
