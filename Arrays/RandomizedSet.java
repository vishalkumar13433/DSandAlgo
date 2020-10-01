

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
	HashMap<Integer,Integer> hm;
	List<Integer> l;
	Random rand;
	public RandomizedSet() {
		hm = new HashMap<>();
		l = new ArrayList<Integer>();
		rand = new Random();
	}

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		System.out.println(obj.insert(1));
		System.out.println(obj.remove(2));
		System.out.println(obj.insert(2));
		System.out.println(obj.getRandom());
		System.out.println(obj.remove(1));
		System.out.println(obj.insert(2));
		System.out.println(obj.getRandom());
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if(hm.containsKey(val)) {
			return false;
		}
		hm.put(val, l.size());
		l.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if(!hm.containsKey(val)) {
			return false;
		}
		int ind = hm.get(val);
		int lastElement = l.get(l.size()-1);
		l.set(ind, lastElement);
		hm.put(lastElement , ind);
		l.remove(l.size() - 1);
		hm.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int r = rand.nextInt(l.size());
		return l.get(r);
	}

}
