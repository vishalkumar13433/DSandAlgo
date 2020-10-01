package LinkedList;

public class mergeSortOnLinkedList {

	public static void main(String[] args) {
		// creating first linked list 
		LinkedList list = new LinkedList();
        list.head = new Node(4); 
        list.head.next = new Node(2); 
        list.head.next.next = new Node(6); 
        list.head.next.next.next = new Node(1); 
        list.head.next.next.next.next = new Node(5); 
        list.head.next.next.next.next.next = new Node(3); 
        
        Node res=mergeSort(list.head);
        while(res!=null)
        {
        	System.out.print(res.data + " ");
        	res=res.next;
        }

	}

	private static Node mergeSort(Node head) {
		if(head==null || head.next==null)
			return head;
		
		//split linkedList into two by mid
		Node mid=getPartition(head);
		System.out.println("Middle :" +mid.data);
		Node next=mid.next;
		mid.next=null;
		
		//performing divide and Conquer
		Node l1=mergeSort(head);
		Node l2=mergeSort(next);
		
		//merging in sorted way
		return mergeTwoLists(l1,l2);
	}

	private static Node getPartition(Node head) {
		
		if(head==null)
			return head;
		Node slow=head,fast=head,pre=head;
		while(slow!=null && fast!=null && fast.next!=null)
		{
			pre=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		return pre;
	}

	static Node mergeTwoLists(Node l1, Node l2)
    {
            if(l1==null)
            	return l2;
        	if(l2==null)
            	return l1;
        	Node res;
        	if(l1.data <= l2.data)
        	{
            	res=l1;
            	res.next=mergeTwoLists(l1.next,l2);
        	}
        	else
        	{
            	res=l2;
            	res.next=mergeTwoLists(l1,l2.next);
        	}
        return res;
    }
	
}
