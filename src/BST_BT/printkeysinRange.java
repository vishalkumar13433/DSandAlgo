package BST_BT;
public class printkeysinRange {

	public static void main(String[] args) {
		Node root=null;
		root=insert(root,20);
		root=insert(root,8);
		root=insert(root,22);
		root=insert(root,4);
		root=insert(root,12);
		int n1=10,n2=22;
		printKeys(root,n1,n2);
	}
	private static void printKeys(Node root, int n1, int n2) {
		if(root==null)
				return;
		if(root.data > n1)
			printKeys(root.left,n1,n2);
		if(root.data >= n1 && root.data <=n2)
				System.out.print(root.data + " ");
		if(root.data < n2)
			printKeys(root.right,n1,n2);
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
