package BST_BT;
public class ReverseLevelOrder {

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=new Node(1);
		bt.root.left=new Node(2);
		bt.root.right=new Node(7);
		bt.root.left.right=new Node(4);
		bt.root.left.right.left=new Node(5);
		bt.root.left.right.right=new Node(6);
		bt.root.left.left=new Node(3);
		
		
		System.out.println("\nReverse Level order Traversal:");
		rev_lev_order(bt.root);
	}

	private static void rev_lev_order(Node root) {
		int h=height(root);
		for(int i=h;i>0;i--)
		{
			printLevel(root,i);
		}
	}
	private static void printLevel(Node root, int i) {
		if(root==null)
			return;
		if(i==1)
		{
			System.out.print(root.data + " ");
			return;
		}
		printLevel(root.left,i-1);
		printLevel(root.right,i-1);
	}

	private static int height(Node root) {
		if(root==null)
			return 0;
		int lh=height(root.left);
		int rh=height(root.right);
		
		return 1+Math.max(lh, rh);
	}
	
}
