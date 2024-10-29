package src.BST_BT;
public class maxNobw2Num {

	public static void main(String[] args) {
		Node root=null;
		root=insert(root,18);
		root=insert(root,36);
		root=insert(root,9);
		root=insert(root,6);
		root=insert(root,12);
		root=insert(root,10);
		root=insert(root,1);
		root=insert(root,8);
		System.out.println("Max no between 1 and 10 = "+maX(root,1,9));
	}

	private static int maX(Node root, int num1, int num2) {
			if(root==null)
					return -1;
			if(num1==num2)
					return num1;
			int res=Integer.MIN_VALUE;
			while(root!=null)
			{
				if(num1<root.data && num2 <root.data)
					root=root.right;
				else
				{
					while(root.right!=null && root.right.data!=num1 && root.right.data!=num2)
					{
						
						root=root.right;
					}
					res=root.data;
					break;
				}
			}
			return res;
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
