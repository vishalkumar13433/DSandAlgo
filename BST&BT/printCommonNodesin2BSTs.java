import java.util.Stack;

public class printCommonNodesin2BSTs {

	public static void main(String[] args) {
		 Node root1 = null;  
		    root1 = insert(root1, 5);  
		    root1 = insert(root1, 1);  
		    root1 = insert(root1, 10);  
		    root1 = insert(root1, 0);  
		    root1 = insert(root1, 4);  
		    root1 = insert(root1, 7);  
		    root1 = insert(root1, 9);  
		  
		    
		    Node root2 = null;  
		    root2 = insert(root2, 10);  
		    root2 = insert(root2, 7);  
		    root2 = insert(root2, 20);  
		    root2 = insert(root2, 4);  
		    root2 = insert(root2, 9);  
		  
		    
		    printCommon(root1, root2);  
		    
	}
	
	private static void printCommon(Node root1, Node root2) {
		if(root1==null || root2==null)
			return;
		Stack<Node> s1=new Stack();
		Stack<Node>	s2=new Stack();
		
		
		
		while((root1!=null && root2!=null) || (!s1.isEmpty() || !s2.isEmpty()))
		{
			while(root1!=null)
			{
				s1.push(root1);
				root1=root1.left;
			}
			while(root2!=null)
			{
				s2.push(root2);
				root2=root2.left;
			}
			Node n1=s1.peek();
			Node n2=s2.peek();
			
			if(n1.data == n2.data)
			{
				System.out.println(n1.data);
				root1=s1.pop();
				root2=s2.pop();
				root1=root1.right;
				root2=root2.right;
			}
			else if(n1.data < n2.data)
			{
				root1=s1.pop();
				root1=root1.right;
			}
			else
			{
				root2=s2.pop();
				root2=root2.right;
			}
		}
		
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
