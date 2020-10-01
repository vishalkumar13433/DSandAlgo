import java.util.*;

public class BinaryTree {

	Node root;
	
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=new Node(1);
		bt.root.left=new Node(2);
		bt.root.right=new Node(7);
		bt.root.left.right=new Node(4);
		bt.root.left.right.left=new Node(5);
		bt.root.left.right.right=new Node(6);
		bt.root.left.left=new Node(3);
		
		System.out.println("\nInorder Traversal:");
		bt.inorder(bt.root);
		System.out.println("\nIterative:");
		bt.itr_inorder(bt.root);
		System.out.println("\npreorder Traversal:");
		bt.preorder(bt.root);
		System.out.println("\nIterative:");
		bt.itr_preorder(bt.root);
		System.out.println("\npostorder Traversal:");
		bt.postorder(bt.root);
		System.out.println("\nIterative:");
		bt.itr_postorder(bt.root);
		
		System.out.println("\nLevelorder Traversal:");
		bt.lev_order(bt.root);
		System.out.println("\nIterative:");
		bt.levelOrder(bt.root);
		
	}

	private void lev_order(Node root) {
		if(root==null)
			return;
		int h=this.height(root);
		for(int i=0;i<h;i++)
		{
			printLevel(root,i);
		}
	}

	private void printLevel(Node root, int i) {
		if(root==null)
			return;
		if(i==0)
		{
			System.out.print(root.data + " ");
			return;
		}
		printLevel(root.left,i-1);
		printLevel(root.right,i-1);
	}

	private int height(Node root) {
		if(root==null)
			return 0;
		int lh=height(root.left);
		int rh=height(root.right);
		
		return 1+Math.max(lh, rh);
	}

	private void levelOrder(Node root) {
		if(root==null)
				return;
		Queue<Node> q=new LinkedList();
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			System.out.print(temp.data + " ");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}

	private void itr_postorder(Node root) {
		List<Integer> l=new ArrayList();	//Store Output
		
		//Perform reverse Iterative Preorder 
		if(root==null)
			return;
		Stack<Node> s=new Stack();
		while(!s.isEmpty() || root!=null)
		{
			if(root!=null)
			{	
				l.add(root.data);
				s.push(root.left);
				root=root.right;
			}
			else
			{
				root=s.pop();
			}
		}
		//reverse array to get desired output
		Collections.reverse(l);
		System.out.println(l);
	}

	private void itr_preorder(Node root) {
		if (root == null)
			return;
		Stack<Node> s = new Stack<>();
		while (!s.isEmpty() || root != null) {
			if (root != null) {
				System.out.print(root.data + " ");
				if (root.right != null)
					s.push(root.right);
				root = root.left;
			} else {
				root = s.pop();
			}
		}
	}

	private void itr_inorder(Node root) {
		if(root==null)
				return;
		Stack<Node> s=new Stack();
		while(!s.isEmpty() || root!=null)
		{
			if(root!=null)
			{
				s.push(root);
				root=root.left;
			}
			else
			{
				Node temp=s.pop();
				System.out.print(temp.data + " ");
				root=temp.right;
			}
		}
	}

	private void postorder(Node root) {
		if(root==null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

	private void preorder(Node root) {
		if(root==null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
		
	}

	private void inorder(Node root) {
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

}
