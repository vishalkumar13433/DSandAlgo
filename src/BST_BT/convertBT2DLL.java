package BST_BT;
public class convertBT2DLL {
	
	static Node head=null;
	
	public static void main(String[] args) {
		 BinaryTree tree = new BinaryTree(); 
	        tree.root = new Node(5); 
	        tree.root.left = new Node(3); 
	        tree.root.right = new Node(6); 
	        tree.root.left.right = new Node(4); 
	        tree.root.left.left = new Node(1); 
	        tree.root.right.right = new Node(8); 
	        tree.root.left.left.right = new Node(2); 
	        tree.root.left.left.left = new Node(0); 
	        tree.root.right.right.left = new Node(7); 
	        tree.root.right.right.right = new Node(9); 
	        
	        BToDLL(tree.root);
	        printList(head);
	}

	private static void printList(Node head) {
		if(head==null)
			return;
		while(head!=null)
		{
			System.out.print(head.data + " ");
			head=head.right;
		}
	}

	private static void BToDLL(Node root) {
		if(root==null)
			return;
		
		BToDLL(root.right);
		if(head!=null)
		{
			head.left=root;
		}
		root.right=head;
		head=root;
		BToDLL(root.left);
	}

}
