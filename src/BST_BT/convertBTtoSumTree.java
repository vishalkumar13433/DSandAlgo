package BST_BT;
public class convertBTtoSumTree {

	public static void main(String[] args) {
		 	
			BinaryTree tree = new BinaryTree(); 
			tree.root = new Node(10); 
	        tree.root.left = new Node(-2); 
	        tree.root.right = new Node(6); 
	        tree.root.left.left = new Node(8); 
	        tree.root.left.right = new Node(-4); 
	        tree.root.right.left = new Node(7); 
	        tree.root.right.right = new Node(5); 
	   
	        toSumTree(tree.root);
	        preorder(tree.root);
	}

	private static int toSumTree(Node root) {
		if(root==null)
			return 0;
		int left=toSumTree(root.left);
		int right=toSumTree(root.right);
		int data=left+right+root.data;
		root.data=left+right;
		return data;
	}

	private static void preorder(Node root) {
		if(root==null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
		
	}
}
