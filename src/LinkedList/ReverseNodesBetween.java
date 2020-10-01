package LinkedList;

public class ReverseNodesBetween {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(4);
		l.append(5);
		int m=2,n=4;
		Node res=reverseBetween(l.head,m,n);
		printList(res);
	}
	
	public static Node reverseBetween(Node head, int m, int n) {
        Node start=head,end=head,prev=null;
        for(int i=1;i<m;i++)
        {   
            prev=start;
            start=start.next;
        }
        for(int i=1;i<n;i++)
        {
            end=end.next;
        }
        //seperating list
        if(prev!=null)
            prev.next=null;
        
        Node next=end.next;
        end.next=null;
        
        System.out.println("Printing segregating List");
        printList(start);
        System.out.println("\n--------");
        Node rev=reverse(start);
        //restoring list
        if(prev!=null)
            prev.next=rev;
        else
            head=rev;
        start.next=next;
        
        return head;
    }

	private static void printList(Node res) {
		while(res!=null)
		{
			System.out.print(res.data+" ");
			res=res.next;
		}
	}

	private static Node reverse(Node head) {
		if(head==null || head.next==null)
            return head;
       Node prev=null,cur=head,next;
        next=cur.next;
        cur.next=prev;
        
       Node ans=reverse(next);
        next.next=cur;
        return ans;
	}
	
}
