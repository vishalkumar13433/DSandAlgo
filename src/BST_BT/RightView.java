package BST_BT;
import java.util.*;
import java.util.Map.Entry;

public class RightView {

	public static void main(String[] args) {
		Node root=new Node(20);
		root.left=new Node(8);
		root.right=new Node(22);
		root.left.left=new Node(4);
		root.left.right=new Node(12);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(14);
		TreeMap h=new TreeMap<Integer,Integer>();
		int vd=0;
		RightView(root,h,vd);
		Set<Entry<Integer,Integer>> e=h.entrySet();
		Iterator<Entry<Integer,Integer>> i=e.iterator();
		while(i.hasNext())
		{
			Entry<Integer,Integer> en=i.next();
			System.out.print(en.getValue()+" ");
		}
	}

	private static void RightView(Node root, TreeMap h, int vd) {
		if(root==null)
				return;
		
		if(!h.containsKey(vd))
		{
			h.put(vd,root.data);
		}
		RightView(root.right,h,vd+1);
		RightView(root.left,h,vd+1);
		
		
		//for Left View 
		//traverse to left subtree first 
	}

}