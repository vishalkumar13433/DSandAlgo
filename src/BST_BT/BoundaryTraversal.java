package src.BST_BT;
public class BoundaryTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        tree.root.right = new Node(22); 
        tree.root.right.left = new Node(23); 
        tree.root.right.left.right = new Node(25); 
        
        boundaryTraversal(tree.root);
	}

	private static void boundaryTraversal(Node root) {
		
		//1. print root
		System.out.print(root.data + " ");
		//2.print left side
		printLeft(root.left);
		
		//3. print Leaves
		printLeaf(root.left);
		printLeaf(root.right);
		//4. print right side bottom up
		printRightBottomUp(root.right);
	}

	private static void printRightBottomUp(Node root) {
		if(root==null || isLeaf(root))
			return;
		//Very Important Condition .. checks if right boundary consists of any left nodes
		if(root.right!=null)
			printRightBottomUp(root.right);
		else
			printRightBottomUp(root.left);
		System.out.print(root.data + " ");
	}

	private static void printLeaf(Node root) {
		if(root==null)
			return;
		if(isLeaf(root))
		{
			System.out.print(root.data + " ");
			return ;
		}
		printLeaf(root.left);
		printLeaf(root.right);
	}

	private static void printLeft(Node root) {
		if(root==null || isLeaf(root))
			return;
		
		System.out.print(root.data + " ");
		//Very Important Condition .. checks if left boundary consists of any right nodes
		if(root.left!=null)	
			printLeft(root.left);
		else
			printLeft(root.right);
	}

	private static boolean isLeaf(Node root) {
		if(root==null)
			return false;
		return root.left==null && root.right==null;
	}

}
