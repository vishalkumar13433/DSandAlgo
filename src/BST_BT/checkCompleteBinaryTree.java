package src.BST_BT;
import java.util.LinkedList;
import java.util.Queue;

public class checkCompleteBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        // root.right.left=new Node(7);
        root.right.right = new Node(6); 
          
        if(isCompleteBT(root) == true) 
            System.out.println("Complete Binary Tree"); 
        else
            System.out.println("NOT Complete Binary Tree"); 
        //METHOD 2
        int count=countNodes(root);
        if(isCompleteBTMethod2(root,0,count) == true) 
            System.out.println("Complete Binary Tree"); 
        else
            System.out.println("NOT Complete Binary Tree"); 
        
	}

	private static int countNodes(Node root) {
		if(root==null)
			return 0;
		return 1+countNodes(root.left) + countNodes(root.right);
	}

	private static boolean isCompleteBTMethod2(Node root, int index, int count) {
		if(root==null)
				return true;
		if(index >= count)
			return false;
		return isCompleteBTMethod2(root.left,2*index +1,count) && isCompleteBTMethod2(root.right,2*index +2,count);
	}

	private static boolean isCompleteBT(Node root) {
	//EMpty tree is Complete Binary Tree
		if(root==null)
			return true;
		
		Queue<Node> q=new LinkedList();
		q.add(root);
		boolean flag=false;	//check if we have encountered any not full node
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(temp.left!=null)
			{
				if(flag==true)
					return false;
				q.add(temp.left);
			}
			else
				flag=true;
			
			if(temp.right!=null)
			{
				if(flag==true)
					return false;
				q.add(temp.right);
			}
			else
				flag=true;
		}
		return true;
	}

}
