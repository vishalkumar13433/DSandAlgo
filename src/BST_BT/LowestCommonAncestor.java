package src.BST_BT;
public class LowestCommonAncestor {

	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        Node lca1=LCA(tree.root,5,7);
        Node lca2=LCA(tree.root,5,4);
        Node lca3=LCA(tree.root,2,1);
        System.out.println("LCA of 5,7 is :"+ ((lca1==null)?-1 : lca1.data));
        System.out.println("LCA of 5,4 is :"+ ((lca2==null)?-1 : lca2.data));
        System.out.println("LCA of 2,1 is :"+ ((lca3==null)?-1 : lca3.data));
        
	}

	private static Node LCA(Node root, int val1, int val2) {
		if(root==null)
			return null;
		if(root.data==val1 || root.data==val2)
			return root;
		Node left=LCA(root.left,val1,val2);
		Node right=LCA(root.right,val1,val2);
		
		if(left==null && right==null)
			return null;
		if(left!=null && right!=null)
			return root;
		return (left!=null) ? left :right;
	}

}
