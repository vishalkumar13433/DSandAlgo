package BST_BT;
public class noOfNodesLyingInaRange {

	public static void main(String[] args) {
		Node root=null;
		root=insert(root,20);
		root=insert(root,8);
		root=insert(root,22);
		root=insert(root,4);
		root=insert(root,12);
		int n1=10,n2=22;
		System.out.println("Num of nodes in range of "+n1 + " and "+n2 +" are :"+printNum(root,n1,n2));
	}
	private static int printNum(Node root, int n1, int n2) {
		if(root==null)
			return 0;
		int cnt=0;
		if(root.data > n1)
			cnt+=printNum(root.left,n1,n2);
		if(root.data >=n1 && root.data <=n2)
			cnt++;
		if(root.data < n2)
			cnt+=printNum(root.right,n1,n2);
		return cnt;
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
