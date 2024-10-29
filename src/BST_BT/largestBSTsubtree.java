package src.BST_BT;
public class largestBSTsubtree {

	public static void main(String[] args) {
		Node root=null;
		root=insert(root,50);
		root=insert(root,30);
		root=insert(root,60);
		root=insert(root,5);
		root=insert(root,20);
		root=insert(root,55);
		root=insert(root,70);
		root=insert(root,80);
		root=insert(root,45);
		root=insert(root,65);
		
		int size=largestBST(root);
		
	}
	private static int largestBST(Node root) {
		return largeBSTutil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private static int largeBSTutil(Node root, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		return 0;
	}
	/*private static int largeBSTutil(Node root, int minValue, int maxValue) {
		if(root==null)
			return 0;
		int ls=largeBSTutil(root.left,minValue,root.data);
		int rs=largeBSTutil(root.right,root.data,maxValue);
		if(root.data < minValue || root.data > maxValue)
				return 0;
		
	}
	*/
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
