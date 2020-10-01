package BST_BT;
import java.util.*;
import java.util.Map.Entry;

public class verticalSum {

	public static void main(String[] args) {
		BinaryTree b=new BinaryTree();
		b.root=new Node(1);
		b.root.left=new Node(2);
		b.root.right=new Node(3);
		b.root.left.left=new Node(4);
		b.root.left.right=new Node(5);
		b.root.right.left=new Node(6);
		b.root.right.right=new Node(7);
		b.root.left.left.left=new Node(8);
		b.root.left.left.right=new Node(9);
		b.root.left.right.right=new Node(10);
		
		Map<Integer,Integer> hm=new HashMap();
		
        System.out.println("Following are the values of" +  
                           " vertical sums with the positions" + 
                        " of the columns with respect to root "); 
        VerticalSum(b.root,hm,0); 
        
        Set<Entry<Integer,Integer>> e=hm.entrySet();
		Iterator<Entry<Integer,Integer>> i=e.iterator();
		while(i.hasNext())
		{
			Entry<Integer,Integer> en=i.next();
			System.out.println(en.getKey() + " : " +en.getValue()+" ");
		}
	}

	private static void VerticalSum(Node root, Map<Integer, Integer> hm , int hd) {
		if(root==null)
			return;
		Integer sum=hm.getOrDefault(hd, 0);
		 hm.put(hd, sum+root.data);
		 VerticalSum(root.left,hm,hd-1);
		 VerticalSum(root.right,hm,hd+1);
	}

}
