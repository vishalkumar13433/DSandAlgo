package BST_BT;
public class root2LeafSumEqualtoX {

	public static void main(String[] args) {
		 int sum = 21; 
         
	        /* Constructed binary tree is 
	              10 
	             /  \ 
	           8     2 
	          / \   / 
	         3   5 2 
	        */
	        BinaryTree tree = new BinaryTree(); 
	        tree.root = new Node(10); 
	        tree.root.left = new Node(8); 
	        tree.root.right = new Node(2); 
	        tree.root.left.left = new Node(3); 
	        tree.root.left.right = new Node(5); 
	        tree.root.right.left = new Node(2); 
	   
	        if (haspathSum(tree.root, sum)) 
	            System.out.println("There is a root to leaf path with sum " + sum); 
	        else
	            System.out.println("There is no root to leaf path with sum " + sum); 
	    }

	private static boolean haspathSum(Node root, int sum) {
		if(root==null)
			return false;
		
		return (isLeaf(root) && root.data==sum)||haspathSum(root.left,sum-root.data) || haspathSum(root.right,sum-root.data);
	}

	private static boolean isLeaf(Node root) {
		if(root==null)
            return false;
		if(root.left==null && root.right==null)
            return true;
		return false;
	} 
	

}
