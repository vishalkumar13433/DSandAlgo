package src.BST_BT;
public class distFromAtoB {
	public static void main(String[] args)
	{
		Node root=new Node(3);
		root.left=new Node(6);
		root.right=new Node(8);
		root.left.left=new Node(2);
		root.left.right=new Node(11);
		root.left.right.left=new Node(9);
		root.left.right.right=new Node(5);
		root.right.right=new Node(13);
		root.right.right.left=new Node(7);
		int x=dist(root,9,7);
		if(x!=1)
			System.out.println(x);
		else
			System.out.println("Not possible");
	}
	
	private static int dist(Node root, int val1, int val2) {
		if(root==null)
			return -1;
		//1.find LCA
		Node lca=LCA(root,val1,val2);
		System.out.println("\nLCA is :"+lca.data +"\n");
		//2.dist from LCA to left
		//3.dist from LCA to right
		//4.add both and return
		return distHelper(lca,val1,0)+distHelper(lca,val2,0) ;
	}
	
	private static int distHelper(Node root, int val1, int level) {
		if(root==null)
			return -1;
		int x=-1;
		if(root.data==val1)
			return level;
		x=distHelper(root.left,val1,level+1);
		if(x==-1)
			return distHelper(root.right,val1,level+1);
		return x;
	}
	private static Node LCA(Node root, int val1,int val2) {
		if(root==null)
			return null;
		if(root.data==val1 || root.data==val2)
			return root;
		Node x1=LCA(root.left,val1,val2);
		Node x2=LCA(root.right,val1,val2);
		if(x1!=null && x2!=null)
				return root;
		if(x1!=null && x2==null)
				return x1;
		if(x1==null && x2!=null)
				return x2;
		return null;
	}
}
