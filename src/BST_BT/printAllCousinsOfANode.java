package BST_BT;
public class printAllCousinsOfANode {

	public static void main(String[] args) {
		/*BinaryTree b=new BinaryTree();
		b.root=new Node(1);
		b.root.left=new Node(2);
		b.root.right=new Node(3);
		b.root.left.left=new Node(4);
		b.root.left.right=new Node(5);
		b.root.right.left=new Node(6);
		b.root.right.right=new Node(7);
		
		
		printCousins(b.root,5);
		*/
		
		 	Node root = new Node(1);  
		    root.left = new Node(2);  
		    root.right = new Node(3);  
		    root.left.left = new Node(4);  
		    root.left.right = new Node(5);  
		    root.left.right.right = new Node(15);  
		    root.right.left = new Node(6);  
		    root.right.right = new Node(7);  
		    root.right.left.right = new Node(8);  
		    
		   printCousins(root,5);
//		   printCousins(root,8);
//		   printCousins(root,15);
//		   printCousins(root,2);
	}

	private static void printCousins(Node root, int val) {
		int level=level(root,val,0);
		if(level<1)
			return;
		printLevel(root,level,val);
	}

	private static void printLevel(Node root, int level,int val) {
		if(root==null)
			return;
		if(level==1)
		{
			if((root.left!=null && root.left.data==val) || (root.right!=null && root.right.data==val)) 
			{
				return;
			}
			if(root.left!=null)
				System.out.println(root.left.data);
			if(root.right!=null) 
				System.out.println(root.right.data);
		}
		if(level>1 )
		{
			printLevel(root.left,level-1,val);
			printLevel(root.right,level-1,val);
		}
			
	}

	private static int level(Node root, int val, int level) {
		if(root==null)
			return -1;
		if(root.data==val)
			return level;
		int left=level(root.left,val,level+1);
		if(left!=-1)
			return left;
		return level(root.right,val,level+1);
	}
	
}
