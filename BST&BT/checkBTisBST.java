
public class checkBTisBST {

	public static void main(String[] args) {
		 Node root = new Node(3); 
	        root.left = new Node(2); 
	        root.right = new Node(5); 
	        root.left.left = new Node(1); 
	       root.left.right = new Node(4); 
	       int min=Integer.MIN_VALUE;
	       int max=Integer.MAX_VALUE;
	        if (isBST(root,min,max)) 
	            System.out.println("IS BST"); 
	        else
	            System.out.println("Not a BST"); 
	        
	        if (isBST2(root,null,null)) 
	            System.out.println("IS BST"); 
	        else
	            System.out.println("Not a BST"); 
	}

	private static boolean isBST2(Node root, Node  left, Node right) {
		if(root==null)
				return true;
		if(left!=null && root.data < left.data)
			return false;
		if(right!=null && root.data > right.data)
			return false;
		return isBST2(root.left,left,root) && isBST2(root.right,root,right);
	}

	private static boolean isBST(Node root, int min, int max) {
		if(root==null)
			return true;
		return (root.data > min && root.data < max) && isBST(root.left,min,root.data) && isBST(root.right,root.data,max);
	}

}
