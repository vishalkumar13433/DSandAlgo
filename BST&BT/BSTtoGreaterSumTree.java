
public class BSTtoGreaterSumTree {
	static int sum=0;
	public static void main(String[] args) {
		Node root=null;
		root=insert(root,11);
		root=insert(root,2);
		root=insert(root,29);
		root=insert(root,1);
		root=insert(root,7);
		root=insert(root,15);
		root=insert(root,40);
		root=insert(root,35);
		
		inorder(root);
		convertGreat(root);
		System.out.println("After converting every node's value to sum of nodes greater than it ");
		inorder(root);
	}
	private static void convertGreat(Node root) {
		if(root==null)
			return;
		convertGreat(root.right);
		int temp=root.data;
		root.data=sum;
		sum+=temp;
		convertGreat(root.left);
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
			root=new Node(val);
			return root;
		}
		if(root.data > val)
		{
			root.left=insert(root.left,val);
		}
		else if(root.data <val)
		{
			root.right=insert(root.right,val);
		}
		return root;
	}
}
