package src.LinkedList;

public class mergeKsortedLists {

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
        
        Node res=mergeKListsHelper(lists,0,2);
        while(res!=null)
        {
        	System.out.print(res.data + " ");
        	res=res.next;
        }
        
        //USING DIVIDE AND CONQUER
        //USING Min-HEAP
       
	}

	
	static Node mergeKListsHelper(Node[] lists, int start, int end)
    {
		 //USING DIVIDE AND CONQUER
        if(start==end)
            return lists[start];
        if(start < end)
        {
            int mid=(start+end)/2;
            Node left= mergeKListsHelper(lists,start,mid);
            Node right= mergeKListsHelper(lists,mid+1,end);
            return mergeTwoLists(left,right);
        }
        return null;
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
