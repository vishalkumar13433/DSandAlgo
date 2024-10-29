package src.BST_BT;
public class printAllAncestorsOfANode {

	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.right.left = new Node(100);
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        
        Node ancestor=findAncestor(tree.root,100);
        if(ancestor==null)
        {
        	System.out.println("Node not found");
        }
	}

	private static Node findAncestor(Node root, int val) {
		if(root==null)
			return null;
		if(root.data==val)
			return root;
		Node left=findAncestor(root.left,val);
		Node right=findAncestor(root.right,val);
		
		if(left==null && right==null)
			return null;
		if(left==null || right==null)
		{
			System.out.print(root.data+" ");
			return root;
		}
		return null;
	}

}
