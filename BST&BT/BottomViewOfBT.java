import java.util.*;
import java.util.Map.Entry;

public class BottomViewOfBT {
	
	public static void main(String[] args) {
		Node root=new Node(20);
		root.left=new Node(8);
		root.right=new Node(22);
		root.left.left=new Node(4);
		root.left.right=new Node(12);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(14);
		Map<Integer,Integer> a=new TreeMap<Integer,Integer>();
		bottomview(root,0,a);
		System.out.println("Bottom View Of Tree is:");
		Set<Entry<Integer,Integer>> s=a.entrySet();
		Iterator<Entry<Integer,Integer>> it=s.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
	}


	private static void bottomview(Node root,int hd,Map<Integer, Integer> a) {
		if(root==null)
				return;
		bottomview(root.left,hd-1,a);
		a.put(hd, root.data);
		bottomview(root.right,hd+1,a);
	}
	
}
