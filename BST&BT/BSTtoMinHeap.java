import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSTtoMinHeap {
	static Node head=null;
	public static void main(String[] args) {
		Node root=null;
		root=insert(root,8);
		root=insert(root,4);
		root=insert(root,12);
		root=insert(root,2);
		root=insert(root,6);
		root=insert(root,10);
		root=insert(root,14);
		inorder(root);
		
		root=convertBSTtoMinHeap(root);
		inorder(root);
	}
	private static Node convertBSTtoMinHeap(Node root) {
		if(root==null)
			return null;
		//1.convert BST to sortedLL	
		System.out.println("Converting to LL");
		convertBSTtoSLL(root);
		System.out.println("printing LL");
		printLL();
		System.out.println("\nConverting to Heap");
		root=null;
		root=convertSLLtoHeap(root);
		return root;
	}
	private static Node convertSLLtoHeap(Node root) {
		if(head==null)
			return null;
		
		root=head;
		head=head.right;
		root.right=null;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(head!=null)
		{
			Node parent=q.poll();
			System.out.println("\n parent:"+parent.data);
			//preparing left child
			Node left=head;
			head=head.right;
			left.right=null;
			parent.left=left;
			q.add(left);
			
			//preparing right child
			if(head!=null)
			{
				Node right=head;
				head=head.right;
				right.right=null;
				parent.right=right;
				
				q.add(right);
			}
		}
		return root;
	}
	private static void printLL() {
		
		if(head==null)
			return ;
		Node temp=head;
		while(temp!=null)
			{
				System.out.print(temp.data + " ");
				temp=temp.right;
			}
	}
	private static void convertBSTtoSLL(Node root) {
		if(root==null)
			return;
		//we went right first as in the last head will be tracked.
		convertBSTtoSLL(root.right);
		root.right=head;	
		if(head!=null)
			head.left=null;
		head=root;
			
		convertBSTtoSLL(root.left);
		
	}
	private static void inorder(Node root) {
		
		if(root==null)
				return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
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
