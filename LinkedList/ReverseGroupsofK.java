
public class ReverseGroupsofK {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(4);
		l.append(5);
		l.append(6);
		l.append(7);
		l.append(8);
		int k=3;
		l.head=reverseK(l.head,k);
		l.printList();
	}

	private static Node reverseK(Node head, int k) {
		if(head==null || head.next==null)
			return head;
		Node cur=head,pre=null,next;
		for(int i=0;i<k && cur!=null;i++)
		{
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		head.next=reverseK(cur,k);
		return pre;
	}


}
