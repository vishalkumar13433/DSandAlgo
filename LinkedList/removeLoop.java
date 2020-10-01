
public class removeLoop {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(4);
		l.append(5);
		
		//1->2->3->4->5
		
		//adding a cycle 
		l.head.next.next.next.next.next=l.head.next;
		detectAndRemoveLoop(l.head);
		l.printList();
	}

	private static void detectAndRemoveLoop(Node head) {
		if(head==null)
			return;
		Node slow=head,fast=head;
		while(slow!=null && fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
			{
				System.out.println("Loop Exists!! \nRemoving Loop now->\n");
				removeLoop(head,slow);
			}
		}
	}

	private static void removeLoop(Node head, Node slow) {
		Node temp=head;
		while(temp!=slow)
		{
			slow=slow.next;
			temp=temp.next;
		}
		while(slow.next!=temp)
		{
			slow=slow.next;
		}
		slow.next=null;
		
	}

}
