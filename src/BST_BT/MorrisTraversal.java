package src.BST_BT;
public class MorrisTraversal {

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=new Node(1);
		bt.root.left=new Node(2);
		bt.root.right=new Node(7);
		bt.root.left.right=new Node(4);
		bt.root.left.right.left=new Node(5);
		bt.root.left.right.right=new Node(6);
		bt.root.left.left=new Node(3);
		
		MorrisInorder(bt.root);
	}

	private static void MorrisInorder(Node root) {
		if(root==null)
		{
			return;
		}
		
		while(root!=null)
		{
			Node pre=root.left;
			if(pre==null)
			{
				System.out.print(root.data+" ");
				root=root.right;
			}
			else
			{
				while(pre.right!=null && pre.right!=root)
					pre=pre.right;
				if(pre.right==null)
					{
						pre.right=root;
						root=root.left;
					}
				else if(pre.right==root)
				{
					pre.right=null;
					System.out.print(root.data+" ");
					root=root.right;
				}
			}
		}
	}

}
