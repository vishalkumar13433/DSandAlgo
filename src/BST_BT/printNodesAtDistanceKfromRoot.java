package src.BST_BT;
public class printNodesAtDistanceKfromRoot {

	public static void main(String[] args) {
		 BinaryTree tree = new BinaryTree(); 
         
	        /* Constructed binary tree is 
	                1 
	              /   \ 
	             2     3 
	            /  \   / 
	           4    5 8  
	        */
	        tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	        tree.root.right.left = new Node(8); 
	   
	        printKDistant(tree.root, 2); 
	}

	private static void printKDistant(Node root, int k) {
		if(root==null)
			return;
		if(k==0)
			{
				System.out.println(root.data);
				return;
			}
		
		printKDistant(root.left,k-1);
		printKDistant(root.right,k-1);
	}

}
