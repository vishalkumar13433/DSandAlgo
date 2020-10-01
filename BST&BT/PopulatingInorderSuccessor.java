
public class PopulatingInorderSuccessor {
	TBTNode root;
	public static void main(String[] args) {
		PopulatingInorderSuccessor tree = new PopulatingInorderSuccessor(); 
	        tree.root = new TBTNode(10); 
	        tree.root.left = new TBTNode(8); 
	        tree.root.right = new TBTNode(12); 
	        tree.root.left.left = new TBTNode(3); 
	        tree.root.left.right = new TBTNode(4); 
	        tree.root.left.right.left = new TBTNode(5);
	        tree.root.left.right.right = new TBTNode(7);
	        
	        populateInSucc(tree.root);
	        printInSucc(tree.root);
	}
	private static void printInSucc(TBTNode root) {
		if(root==null)
			return;
		printInSucc(root.left);
		
		if(root.next!=null)
			System.out.println("for node: "+root.data +" ,Inorder Successor is  -> " +root.next.data + " ");
		printInSucc(root.right);
	}
	private static void populateInSucc(TBTNode root) {
		if(root==null)
			return;
		while(root!=null)
		{
			TBTNode pre=root.left;
			if(pre==null)
			{
				root=root.right;
			}
			else
			{
				while(pre.right!=null && pre.right!=root)
				{
					pre=pre.right;
				}
				if(pre.right==null)
				{
					pre.right=root;
					pre.next=root;
					root=root.left;
				}
				if(pre.right==root)
				{
					pre.right=null;
					root.next=root.right;
					root=root.right;
				}
			}
		}
	}

}
