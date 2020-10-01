import java.util.LinkedList;
import java.util.Queue;

public class constructCompleteBinaryTreeFromLinkedList {
	static linkedNode head=null;
	public static void push(int new_data)
	{
		
	   linkedNode new_node = new linkedNode(new_data);
	 
	    new_node.next = head;
	    head = new_node;
	}
	public static void main(String[] args) {
		push(36);
		push(30);
		push(25);
		push(15);
		push(12);
		push(10);
		Node root=constructTree();
		
		preorder(root);
	}
	private static void preorder(Node root) {
		if(root==null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
		
	}
	private static Node constructTree() {
		if(head==null)
			return null;
		Node root=new Node(head.data);
		Queue<Node> q=new LinkedList();
		q.add(root);
		head=head.next;
		while(head!=null)
		{
			Node parent=q.poll();
			
			Node left=new Node(head.data);
			parent.left=left;
			q.add(left);
			head=head.next;
			
			if(head!=null)
			{
				Node right=new Node(head.data);
				parent.right=right;
				q.add(right);
				head=head.next;
			}
		}
		return root;
	}

}
