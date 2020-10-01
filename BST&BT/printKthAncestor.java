
public class printKthAncestor {
	static int k=2;
	
		public static void main(String[] args) {
			Node root=new Node(3);
			root.left=new Node(6);
			root.right=new Node(8);
			root.left.left=new Node(2);
			root.left.right=new Node(11);
			root.left.right.left=new Node(9);
			root.left.right.right=new Node(5);
			root.right.right=new Node(13);
			root.right.right.left=new Node(7);
			
			printKthAncestor(root,5);
		}

		private static boolean printKthAncestor(Node root,int i) {
			
			if(root==null)
				return false;
			
			if((root.data==i)||(printKthAncestor(root.left,i) || printKthAncestor(root.right,i)))
			{	
				if(k>0)
					k--;
				else if(k==0)
					{
						System.out.println(root.data);
						return false;
					}
				
				return true;
			}
			return false;
		}
	
}
