package src.BST_BT;
public class DiameterOfBT {
	
	static int diam=0;
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.left.left = new Node(8);
        tree.root.left.right = new Node(5); 
        tree.root.left.right.left = new Node(6);
        tree.root.left.right.right = new Node(7); 
        
        System.out.println("Diameter of Tree is  :" + diamter(tree.root));
        
        //we are calculating diameter while calculating height
        diamterAlt(tree.root);
        System.out.println("Diameter of Tree is  :" + diam);
	}

	private static int diamterAlt(Node root) {
		// O(N)
		
		//IDEA : diameter is the max value of  1+ld+rd among all the nodes
		if(root==null) 
			return 0;
		
		int ld=diamterAlt(root.left);
		int rd=diamterAlt(root.right);
		
		diam=Integer.max(diam,1+ld+rd);
		
		return 1+Integer.max(ld, rd);
	}

	private static int diamter(Node root) {
		
		//O(n^2)
		if(root==null)
			return 0;
		
		int lh=height(root.left);
		int rh=height(root.right);
		
		int ld=diamter(root.left);
		int rd=diamter(root.right);
		
		return Integer.max(Integer.max(ld,rd),1+lh+rh);
	}

	private static int height(Node root) {
		if(root==null)
			return 0;
		int lh=height(root.left);
		int rh=height(root.right);
		
		return 1+Integer.max(lh, rh);
	}

}
