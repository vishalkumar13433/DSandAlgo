package BST_BT;
public class SortedDLLtoBST {
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
		ListNode root=null; 
		System.out.println("head is : "+head.data);
		root=convertDlltoBST(root);
		
		inorder(root);
	}

	private static void inorder(ListNode root) {
		if(root==null)
				return;
		inorder(root.prev);
		System.out.print(root.data);
		inorder(root.next);
	}

	private static ListNode convertDlltoBST(ListNode root) {
			if(head==null)
				return root;
			int len=length();
			System.out.println("length is : "+len);
			return convert(root,len);
	}

	private static ListNode convert(ListNode root, int len) {
		if(len<=0)
			return null;
		ListNode left=convert(root,len/2);
		root=head;
		root.prev=left;
		head=head.next;
		root.next=convert(root,len-1-len/2);
		
		return root;
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
