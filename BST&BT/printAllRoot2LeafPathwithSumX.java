import java.util.ArrayList;
import java.util.List;

public class printAllRoot2LeafPathwithSumX {

	public static void main(String[] args) {
//	      5
//	      / \
//	     4   8
//	    /   / \
//	   11  13  4
//	  /  \    / \
//	 7    2  5   1
		
			int sum=22;
		
		  Node root=new Node(5);
	      root.left=new Node(4);
	      root.right=new Node(8);
	      root.left.left=new Node(11);
	      root.left.left.left=new Node(7);
	      root.left.left.right=new Node(2);
	      root.right.left=new Node(13);
	      root.right.right=new Node(4);
	      root.right.right.left=new Node(5);
	      root.right.right.right=new Node(1);
	      List<Integer> a=new ArrayList();
	      printAllPathSum(root,sum,a);
	      
	}

	private static void printAllPathSum(Node root, int sum, List<Integer> a) {
		if(root==null)
			return;
		a.add(root.data);
		if(root.left==null && root.right==null && root.data==sum)
		{
			System.out.println(a.toString());
			a.remove(a.size()-1);
			return;
		}
		printAllPathSum(root.left,sum-root.data,a);
		printAllPathSum(root.right,sum-root.data,a);
		a.remove(a.size()-1);
	}

}
