package BST_BT;
public class check2NodesareCousins {

	public static void main(String[] args) {
		BinaryTree b=new BinaryTree();
		b.root=new Node(1);
		b.root.left=new Node(2);
		b.root.right=new Node(3);
		b.root.left.left=new Node(4);
		b.root.left.right=new Node(5);
		b.root.right.left=new Node(6);
		b.root.right.right=new Node(7);
		
		boolean flag=checkCousins(b.root,b.root.left.left,b.root.right.left);
//		boolean flag=checkCousins(b.root,b.root.left.left,b.root.left.right);
		if(flag==true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private static boolean checkCousins(Node root,Node n1, Node n2) {
		
		//cousins have same level but shouldn't be siblings
		return (level(root,n1,0)==level(root,n2,0)) && !isSibling(root,n1,n2);
	}

	private static int level(Node root, Node n, int level) {
		if(root==null)
			return -1;
		if(root==n)
			return level;
		int left=level(root.left,n,level+1);
		int right=level(root.right,n,level+1);
		if(left==-1 && right==-1)
			return -1;
		
		return (left!=-1)?left:right;
	}

	private static boolean isSibling(Node root, Node n1, Node n2) {
		if(root==null)
			return false;
		return (root.left==n1 && root.right==n2) || (root.left==n2 && root.right==n1) || isSibling(root.left,n1,n2) || isSibling(root.right,n1,n2);
	}

}
