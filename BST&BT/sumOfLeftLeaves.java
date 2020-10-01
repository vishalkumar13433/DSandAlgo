
public class sumOfLeftLeaves {

	public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(20); 
        tree.root.left = new Node(9); 
        tree.root.right = new Node(49); 
        tree.root.left.right = new Node(12); 
        tree.root.left.left = new Node(5); 
        tree.root.right.left = new Node(23); 
        tree.root.right.right = new Node(52); 
        tree.root.left.right.right = new Node(12); 
        tree.root.right.right.left = new Node(50); 
   
        System.out.println("The sum of leaves is " +  
                                       leftLeavesSum(tree.root)); 
	}

	private static int leftLeavesSum(Node root) {
		if(root==null)
			return 0;	
		if(isLeaf(root.left))
		{
			return root.left.data+ leftLeavesSum(root.right);
		}
		return leftLeavesSum(root.left)+leftLeavesSum(root.right);
	}

	private static boolean isLeaf(Node root) {
		if(root==null)
			return false;
		if(root.left==null && root.right==null)
			return true;
		return false;
	}

}
