import java.util.*;
import java.util.Map.Entry;

public class TopViewOfBT {

	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.right=new Node(4);
		root.left.right.right=new Node(5);
		root.left.right.right.right=new Node(6);
		TopView(root);
	}

	private static void TopView(Node root) {
		Map<Integer,Integer> hm=new HashMap();
		Queue<CustomQueue> q=new LinkedList();
		q.add(new CustomQueue(root,0));
		
		while(!q.isEmpty())
		{
			CustomQueue temp=q.poll();
			if(hm.get(temp.hd) == null)
			{
				hm.put(temp.hd, temp.node.data);
			}
			if(temp.node.left !=null)
				{
					q.add(new CustomQueue(temp.node.left,temp.hd-1));
				}
			if(temp.node.right !=null)
			{
				q.add(new CustomQueue(temp.node.right,temp.hd + 1));
			}
		}
		
		Set<Entry<Integer,Integer>> e=hm.entrySet();
		Iterator<Entry<Integer,Integer>> i=e.iterator();
		while(i.hasNext())
		{
			Entry<Integer,Integer> en=i.next();
			System.out.println(en.getKey() + " : " +en.getValue()+" ");
		}
		
	}

}
