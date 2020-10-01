
public class subtreeTreeOfAnotherTree {
	
	public static void main(String[] args) {
		Node root1=new Node(3);
		root1.left=new Node(4);
		root1.right=new Node(5);
		root1.left.left=new Node(1);
		root1.left.right=new Node(2);
		//root1.left.right.left=new Node(5);
		
		Node root2=new Node(4);
		root2.left=new Node(1);
		root2.right=new Node(2);
		
		
		if(isSubTree(root1,root2))
			System.out.println("Subtree!!");
		else
			System.out.println("not a Subtree");
	}

	private static boolean isSubTree(Node root1, Node root2) {
		if(root1==null && root2==null)
			return true;
		if(root1==null)
			return  false;
		if(root2==null)
			return true;
		
		return isIdentical(root1,root2) || isSubTree(root1.left,root2) || isSubTree(root1.right,root2);
	}

	private static boolean isIdentical(Node root1, Node root2) {
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null )
			return false;
		
		return (root1.data == root2.data) && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
	}

}
