package BST_BT;
public class printNodesAtDistKfromAnyNode {

	public static void main(String[] args) {
		 BinaryTree tree = new BinaryTree();
		tree.root = new Node(3); 
        tree.root.left = new Node(5); 
        tree.root.right = new Node(1); 
        tree.root.left.left = new Node(6); 
        tree.root.left.right = new Node(2); 
        tree.root.left.right.left = new Node(7); 
        tree.root.left.right.right = new Node(4); 
        tree.root.right.left = new Node(0); 
        tree.root.right.right = new Node(8); 
        
        Node target = tree.root.left; 
        printkdistanceNode(tree.root, target, 2); 
	}

	private static int printkdistanceNode(Node root, Node target, int k) {
		if(root==null)
			return -1;
		//1. if target is root , print nodes at dist k from root
		if(target==root)
		{
			printDownK(root,k);
			return 0;
		}
		
		//2. check whether target is in left subtree 
		//If so, check what nodes to print in right subtree of parent

		int left=printkdistanceNode(root.left, target, k);
		if(left!=-1)
		{
			if(1+left == k)//root is at distance k from target
			{
				System.out.println(root.data);
				
			}
			else
				printDownK(root.right, k-left-2);
			return 1+left;	//returning distance from the target
		}
		//do the same if target is in right subtree
		int right=printkdistanceNode(root.right, target, k);
		if(right!=-1)
		{
			if(1+right == k)
			{
				System.out.println(root.data);
				
			}
			else
				printDownK(root.left, k-right-2);
			return 1+right;
		}
		return -1;	//node not found
	}

	private static void printDownK(Node root, int k) {
		if(root==null)
			return;
		if(k==0)
		{
			System.out.println(root.data+ " ");
			return;
		}
		printDownK(root.left,k-1);
		printDownK(root.right,k-1);
	}

}
