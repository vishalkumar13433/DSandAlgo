
public class kthSmallestElementBST {

	public static void main(String[] args) {
		Node root=null;
		root=insert(root,15);
		root=insert(root,10);
		root=insert(root,20);
		root=insert(root,8);
		root=insert(root,12);
		root=insert(root,16);
		root=insert(root,25);
		inorder(root);
		int k=3;
		int num=kthSmallest(root,k);
		System.out.println("\n"+k+"th smallest number in BST is : " + num);
	}

	private static void inorder(Node root) {
		if(root==null)
				return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	private static int kthSmallest(Node root, int k) {
		
		int ans=-1;
		if(root==null)
			return ans;
		
		Node pre=root.left;
		while(root!=null)
		{
			pre=root.left;
			if(pre==null)
			{
				k--;
				if(k == 0)
				{
					ans=root.data;
					break;
				}
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
					root=root.left;
				}
				if(pre.right==root)
				{
					pre.right=null;
					k--;
					if(k == 0)
					{
						ans=root.data;
						break;
					}
					root=root.right;
				}
			}
		}
		return ans;
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
