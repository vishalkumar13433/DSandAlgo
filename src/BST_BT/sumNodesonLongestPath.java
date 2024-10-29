package src.BST_BT;
public class sumNodesonLongestPath {
	static int max_len=0,sum=0;
	public static void main(String[] args) {
		Node root = new Node(4);         /*        4        */
        root.left = new Node(2);         /*       / \       */
        root.right = new Node(5);        /*      2   5      */
        root.left.left = new Node(7);    /*     / \ / \     */
        root.left.right = new Node(1);   /*    7  1 2  3    */
        root.right.left = new Node(2);   /*      /          */
        root.right.right = new Node(3);  /*     6           */
        root.left.right.left = new Node(6); 
       
      System.out.println( "Sum = "+ sumOfLongRootToLeafPath(root)); 
      System.out.println("Max length:" + max_len);
	}

	private static int sumOfLongRootToLeafPath(Node root) {
		if(root==null)
				return 0;
		
		sumUtil(root,0,0);
		
		return sum;
	}

	private static void sumUtil(Node root, int s, int len) {
		if(root==null)
			return ;
		
		if(root.left==null && root.right==null)
		{
			len++;
			s=s+root.data;
			if(max_len < len)
				{
					max_len=len;
					sum=s;
				}
			else if(max_len==len && sum<s)
				sum=s;
			len--;
			s-=root.data;
			return ;
		}
		sumUtil(root.left,s+root.data,len+1);
		sumUtil(root.right,s+root.data,len+1);
		
	}

}
