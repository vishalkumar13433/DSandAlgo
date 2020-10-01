
public class AddTwoNumbersRepresentedAsLinkedList {

	public static void main(String[] args) {
		 // creating first linked list as number 
		LinkedList list = new LinkedList();
        list.head = new Node(7); 
        list.head.next = new Node(5); 
        list.head.next.next = new Node(9); 
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(6);
        
        // creating second linked list 
        LinkedList list2 = new LinkedList();
        list2.head = new Node(8); 
        list2.head.next = new Node(4); 
        
        Node res=AddNumbers(list.head,list2.head);
        res=reverse(res);
        while(res!=null)
        {
        	System.out.print(res.data);
        	res=res.next;
        }
	}

	private static Node reverse(Node head) {
		if(head==null || head.next==null)
			return head;
		Node cur=head,pre=null,next;
		next=cur.next;
		cur.next=pre;
		
		Node res=reverse(next);
		next.next=cur;
		return res;
	}

	private static Node AddNumbers(Node head1, Node head2) {
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		int sum,carry=0;
		Node res=null,temp=null;
		while(head1!=null && head2!=null)
		{
			sum=head1.data+head2.data+carry;
			carry=(sum>9)?1:0;
			sum=sum%10;
			
			Node n=new Node(sum);
			if(res==null)
			{
				res=n;
			}
			else
			{
				temp.next=n;
				
			}
			temp=n;
			
			head1=head1.next;
			head2=head2.next;
		}
		
		while(head1!=null)
		{
			int x=head1.data+carry;
			carry=(x>9)?1:0;
			x=x%10;
			Node n=new Node(x);
			temp.next=n;
			temp=n;
			head1=head1.next;
		}
		
		while(head2!=null)
		{
			int x=head2.data+carry;
			carry=(x>9)?1:0;
			x=x%10;
			Node n=new Node(x);
			temp.next=n;
			temp=n;
			head2=head2.next;
		}
		
		if(carry!=0)
		{
			temp.next=new Node(carry);
		}
		return res;
	}

}
