
public class reverseLinkedList {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(4);
		l.append(5);
		
		l.head=reverseLinkedListIterative(l.head);
		l.printList();
		l.head=reverseLinkedListRec(l.head);
		l.printList();
	}

	private static Node reverseLinkedListIterative(Node head) {
		if(head==null || head.next==null)
			return head;
		Node pre=null,cur=head,next;
		while(cur!=null)
		{
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		return pre;
	}

	private static Node reverseLinkedListRec(Node head) {
		if(head==null || head.next==null)
			return head;
		Node pre=null,cur=head,next;
		next=cur.next;
		cur.next=pre;
		Node ans=reverseLinkedListRec(next);
		next.next=cur;	//this will attach the last node in reversed linkedlist to the prev node
		return ans;
	}
	

}
