package ImpQuestion;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		CustomHashMap<Integer,Integer> hm=new CustomHashMap<Integer, Integer>(10);
		hm.put(1, 2);
		hm.put(2, 3);
		hm.put(3, 3);
		hm.put(3, 4);
		hm.put(3, 5);
		System.out.println(hm.get(1));
		System.out.println(hm.get(2));
		System.out.println(hm.get(3));
		hm.remove(3);
		System.out.println(hm.get(3));
		System.out.println(hm.isEmpty());
		System.out.println(hm.containsKey(7));
		
		System.out.println("\nOutput in Java Hashmap: ");
		HashMap<Integer,Integer> h=new HashMap();
		h.put(1, 2);
		h.put(1,3);
		h.put(2, 2);
		h.put(3, 3);
		h.put(3, 4);
		h.put(3, 5);
		System.out.println(h.get(1));
		System.out.println(h.get(2));
		System.out.println(h.get(3));
		System.out.println(h.remove(3,5));
		System.out.println(h.get(3));
		
	}

}
