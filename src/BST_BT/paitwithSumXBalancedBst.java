package BST_BT;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;



public class paitwithSumXBalancedBst {

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
		if(pairSumX(root,sum))
			System.out.println("\nYes");
		else
			System.out.println("\nNO");
	}
	private static boolean pairSumX(Node root, int sum) {
		if(root==null)
			return false;
		ArrayList<Integer> a=new ArrayList();
		storeInorder(root,a);
		
		//converted to two elemts in array having sum = X
		int start=0,end=a.size()-1;
		while(start < end)
		{
			int x=a.get(start);
			int y=a.get(end);
			if(x+y== sum)
			{
				
				System.out.print("first:" + x + "\nSecond:"+(y));
				return true;
			}
			if(x+y > sum)
				end--;
			else
				start++;
		}
		return false; 
	}
	private static void storeInorder(Node root, ArrayList<Integer> a) {
		if(root==null)
			return;
		storeInorder(root.left,a);
		a.add(root.data);
		storeInorder(root.right,a);
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
