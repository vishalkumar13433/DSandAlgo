
public class recoverBST {

	static Node first=null;
	static Node second=null;
    static Node pre=new Node(Integer.MIN_VALUE);
	
	
	public static void main(String[] args) {
		Node root = new Node(6); 
        root.left = new Node(10); 
        root.right = new Node(2); 
        root.left.left = new Node(1); 
        root.left.right = new Node(3); 
        root.right.right = new Node(12); 
        root.right.left = new Node(7); 
  
        printInorder(root); 
        
        correctBST(root); 
  
        System.out.println("\nInorder Traversal"+ 
                          " of the fixed tree"); 
        printInorder(root); 	
        
	}

	private static void correctBST(Node root) {
		findNo(root);
		System.out.println("First:"+first.data);
		System.out.println("Second:" + second.data);
		int temp=first.data;
		first.data=second.data;
		second.data=temp;
	}

	private static void findNo(Node root) {
		if(root==null)
			return;
		findNo(root.left);
		if(first==null && pre.data > root.data )
		{
			first=pre;
		}
		if(first!=null && pre.data > root.data)
		{
			second=root;
		}
		pre=root;
		findNo(root.right);
	}

	private static void printInorder(Node root) {
		if(root==null)
			return;
		printInorder(root.left);
		System.out.println(root.data + " ");
		printInorder(root.right);
	}

}
