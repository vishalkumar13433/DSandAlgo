package src.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKsortedListUsingMinHeap {

	public static void main(String[] args) {
		Node[] lists=new Node[3];
		LinkedList list = new LinkedList(); 
		  
        list.head = new Node(1); 
        list.head.next = new Node(4); 
        list.head.next.next = new Node(5); 
  
        // creating second linked list 
        LinkedList list2 = new LinkedList();
        list2.head = new Node(1); 
        list2.head.next = new Node(3); 
        list2.head.next.next = new Node(4); 
  
        LinkedList list3 = new LinkedList();
        list3.head = new Node(2); 
        list3.head.next = new Node(6); 
        
        
        lists[0]=list.head;
        lists[1]=list2.head;
        lists[2]=list3.head;
        
        Node res=mergeKListsHelper(lists);
        while(res!=null)
        {
        	System.out.print(res.data + " ");
        	res=res.next;
        }
	}

	private static Node mergeKListsHelper(Node[] lists) {
		
		@SuppressWarnings("unchecked")
		PriorityQueue<Node> pq=new PriorityQueue(new Comparator<Node>()
				{
					@Override
					public int compare(Node a, Node b) {
						if(a.data > b.data)
							return 1;
						if(a.data==b.data)
							return 0;
						else
							return -1;
					}
				});
		for(int i=0;i<lists.length;i++)
		{
			pq.offer(lists[i]);
		}
		Node res=null,cur=null;
		while(!pq.isEmpty())
		{
			Node temp=pq.poll();
			if(temp.next!=null)
				pq.offer(temp.next);
			if(res==null)
			{
				res=temp;
			}
			else
			{
				cur.next=temp;
			}
			cur=temp;
		}
		return res;
	}

}
