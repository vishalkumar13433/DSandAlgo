package BST_BT;
public class countNodesInaGivenRange {

	public static void main(String[] args) {
		Node root = new Node(10); 
        root.left     = new Node(5); 
        root.right     = new Node(50); 
        root.left.left = new Node(1); 
        root.right.left = new Node(40); 
        root.right.right = new Node(100); 
        /* Let us constructed BST shown in above example 
          10 
        /    \ 
      5       50 
     /       /  \ 
    1       40   100   */
    int l=5; 
    int h=45; 
    System.out.println("Count of nodes between [" + l + ", "
                      + h+ "] is " + getCount(root, 
                                                  l, h)); 
	}

	private static int getCount(Node root, int l, int h) {
		if(root==null)
			return 0;
		int cnt=0;
		if(root.data >=l && root.data <=h)
			cnt=1+getCount(root.left, l, h)+getCount(root.right, l, h) ;
		else if( root.data > h)
			cnt+=getCount(root.left, l, h);
		else if(root.data < l)
			cnt+=getCount(root.right, l, h);
		return cnt;
	}

}
