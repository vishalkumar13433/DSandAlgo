package src.LinkedList;

public class LinkedList {
	Node head;
	
	LinkedList()
	{
		this.head=null;
	}
	
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(3);
		l.insert(1);
		l.append(4);
		l.insertAt(2,2);
		l.insertAt(1,-1);
		l.insertAt(6,5);
		l.insertAt(5,7);
		
		l.printList();
		
		l.printMiddle();
		
		
		l.delete(7);	
		l.printList();
		l.delete(-1);	//delete head
		l.printList();
		l.delete(5);	//delete tail
		l.printList();
		l.deleteAtPos(2);
		l.printList();
	}


	private void printMiddle() {
		
		if(head==null)
		{
			System.out.println("Empty List");
			return;
		}
		System.out.print("\n\n\n Middle of the linkedlist is :");
		Node fast=head,slow=head;
		while(fast!=null && slow!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.print(slow.data+"\n\n");
	}


	public void deleteAtPos(int pos) {
		if(pos<=0 && pos > length())
		{
			System.out.println("Invalid Position !!!");
			return;
		}
		
		if(pos==1)
		{
			delete(head.data);
			return;
		}
		Node temp=head;
		for(int i=1;i<pos-1;i++)
		{
			temp=temp.next;
		}
		temp.next=temp.next.next;
	}


	public void delete(int val) {
		Node temp=head;
		if(head.data==val)
		{
			temp=head.next;
			head.next=null;
			head=temp;
			return;
		}
		
		while(temp.next!=null && temp.next.data!=val)
		{
			temp=temp.next;
		}
		temp.next=temp.next.next;
	}


	public void printList() {
		
		System.out.println("\nPrinting List :");
		if(head==null)
			{
				System.out.println("Empty List ");
				return;
			}	
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data + "->");
			temp=temp.next;
		}
	}


	public void insertAt(int pos, int val) {
		int len=this.length();
		if(pos <= 0 || pos> (len+1))
		{
			System.out.println("Invalid Position !!!");
			return;
		}
		if(pos==1)
		{
			insert(val);
			return;
		}
		if(pos==len+1)
		{
			this.append(val);
			return;
		}
		Node n=new Node(val);
		Node temp=head;
		for(int i=1;i<pos-1;i++)
		{
			temp=temp.next;
		}
		n.next=temp.next;
		temp.next=n;
	}


	public int length() {
		Node temp=this.head;
		int cnt=0;
		while(temp!=null)
		{
			cnt++;
			temp=temp.next;
		}
		return cnt;
	}


	public void append(int val) {
		if(head==null)
		{
			this.insert(val);
			return;
		}
		Node temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=new Node(val);
	}


	public void insert(int val) {
		
		Node n=new Node(val);
		
		if(head!=null)
		{
			n.next=head;
		}
		head=n;
	}


	

}
