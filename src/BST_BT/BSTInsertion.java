package BST_BT;

public class BSTInsertion {

	public static void main(String[] args) {
		Node root=null;
		root=insert(root,50);
		root=insert(root,30);
		root=insert(root,20);
		root=insert(root,40);
		root=insert(root,70);
		root=insert(root,60);
		root=insert(root,80);
		root=insert(root,10);
		root=insert(root,25);
		root=insert(root,22);
		root=insert(root,27);
		inorder(root);
		root=delete(root,20);
		System.out.println("\n---------");
		inorder(root);
	}

	private static Node delete(Node root, int val) {
		if(root==null)
			return root;
		if(root.data < val)
		{
			root.right=delete(root.right,val);
		}
		else if(root.data > val)
		{
			root.left=delete(root.left,val);
		}
		else
		{
			if(root.left==null && root.right==null)
				return null;
			if(root.right==null)
			{
				return root.left;
			}
			if(root.left==null)
			{
				return root.right;
			}
			int insucc=minValue(root.right);
			root.data=insucc;
			root.right=delete(root.right,insucc);
		}
		return root;
	}

	private static int minValue(Node root) {
		if(root.left==null)
			return root.data;
		return minValue(root.left);
	}

	private static void inorder(Node root) {
		if(root==null)
				return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	private static Node insert(Node root, int val) {
		
		if(root==null)
		{
			Node n=new Node(val);
			return n;
		}
		if(root.data > val)
		{
			root.left=insert(root.left,val);
		}
		if(root.data < val)
		{
			root.right=insert(root.right,val);
		}
		return root;
	}

}
