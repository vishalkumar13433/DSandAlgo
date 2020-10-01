

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashMapInternal {
	int size ;
	List<HashNode>[] h;
	HashMapInternal(int s){
		this.size = s;
		this.h = new List[this.size];
		Arrays.fill(this.h, null);
	}
	
	Integer get(String key) {
		Integer value = null;
		int hash = Math.abs(key.hashCode());
		System.out.println("HashCode: " + hash%this.size);
		List<HashNode> bucket = this.h[hash%this.size];
		if(bucket == null) return null;
		for(HashNode pair: bucket) {
			if(pair.Key.equals(key)) return pair.val;
		}
		return value;
	}
	
	void put(String key , int val) {
		int hash = Math.abs(key.hashCode());
		System.out.println("HashCode: " + hash%this.size);
		List<HashNode> bucket = this.h[hash%this.size];
		HashNode newNode = new HashNode(key, val);
		if(bucket == null) {
			bucket = new ArrayList<>();
		}
		bucket.add(newNode);
		this.h[hash%this.size] = bucket;
	}
	
	public static void main(String[] args) {
		HashMapInternal hm = new HashMapInternal(10);
		hm.put("Vishal", 1);
		hm.put("Swapnil", 2);
		hm.put("Tanuj", 3);
		hm.put("Suar", 4);
		
		System.out.println(hm.get("Vishal")); 
		System.out.println(hm.get("Swapnil")); 
		System.out.println(hm.get("Suar")); 
		System.out.println(hm.get("xD")); 
		System.out.println(hm.get("Tanuj")); 
		
	}

}
