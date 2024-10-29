package src.BST_BT;
public class sortedListToBalancedBST {
	static ListNode head;
	
	public static void main(String[] args) {
		head=null;
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		push(6);
		push(7);
		printList();
		Node root=null; 
		System.out.println("head is : "+head.data);
		int len=length();
		root=convert2BST(len);
		
		inorder(root);
	}
	
	private static Node convert2BST(int len) {
		if(len<= 0)
			return null;
		Node left=convert2BST(len/2);
		Node n=new Node(head.data);
		n.left=left;
		head=head.next;
		n.right=convert2BST(len- len/2 - 1);
		return n;
	}

	private static void inorder(Node root) {
		if(root==null)
				return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	private static int length() {
		if(head==null)
			return 0;
		ListNode h=head;
		int cnt=0;
		while(h!=null)
		{
		cnt++;
		h=h.next;
		}
		return cnt;
	}

	private static void printList() {
		if(head==null)
			return;
		ListNode h=head;
		while(h!=null)
		{
			System.out.print(h.data + " ");
			h=h.next;
		}
	}

	private static ListNode push(int data) {
		ListNode n=new ListNode(data);
		if(head!=null)
			{
				n.next=head;
				head.prev=n;
			}
			head=n;
		return head;
	}
	
}
