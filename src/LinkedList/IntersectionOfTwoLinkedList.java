package src.LinkedList;

public class IntersectionOfTwoLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(); 
		  
        // creating first linked list 
        list.head = new Node(3); 
        list.head.next = new Node(6); 
        list.head.next.next = new Node(15); 
        list.head.next.next.next = new Node(15); 
        list.head.next.next.next.next = new Node(30); 
  
        // creating second linked list 
        LinkedList list2 = new LinkedList();
        list2.head = new Node(10); 
        list2.head.next = new Node(15); 
        list2.head.next.next = new Node(30); 
  
        System.out.println("The node of intersection is " + getNode(list.head,list2.head)); 
	}

	private static int getNode(Node head, Node head2) {
		int len1=length(head);
		int len2=length(head2);
		
		int d=len1-len2;
		System.out.println("D is : "+d);
		if(d > 0)
		{
			while(d>0)
				{
					head=head.next;
					d--;
				}
		}
		else
		{
			while(d<0)
			{
				head2=head2.next;
				d++;
			}
		}
		System.out.println("head1 is :" + head.data);
		System.out.println("head2 is : "+head2.data);
		
		while(head!=null && head2!=null)
		{
			if(head.data==head2.data)
			{
				return head.data;
			}
			head=head.next;
			head2=head2.next;
		}
		System.out.println("No Intersection!!");
		return Integer.MIN_VALUE;
		
	}

	private static int length(Node head) {
		int cnt=0;
		Node temp=head;
		while(temp!=null)
		{
			temp=temp.next;
			cnt++;
		}
		return cnt;
	}

}
