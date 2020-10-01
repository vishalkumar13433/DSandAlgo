package BST_BT;
import java.util.TreeSet;

public class paitWithSumXBST {

	public static void main(String[] args) {
		Node root=null;
		root=insert(root,15);
		root=insert(root,10);
		root=insert(root,20);
		root=insert(root,8);
		root=insert(root,12);
		root=insert(root,16);
		root=insert(root,25);
		int sum=28;
		TreeSet<Integer> h=new TreeSet();
		if(pairSumX(root,sum,h))
			System.out.println("Yes");
		else
			System.out.println("NO");
	}
	private static boolean pairSumX(Node root, int sum,TreeSet h) {
		if(root==null)
			return false;
		if(h.contains(sum-root.data))
				{
					System.out.println("First:" + root.data + " and second is :"+ (sum -root.data));
					return true;
				}
		h.add(root.data);
		return pairSumX(root.left,sum,h) || pairSumX(root.right,sum,h);
	}
	private static Node insert(Node root, int val) {
		if(root==null)
		{
			root=new Node(val);
			return root;
		}
		if(root.data > val)
		{
			root.left=insert(root.left,val);
		}
		else if(root.data <val)
		{
			root.right=insert(root.right,val);
		}
		return root;
	}
}
