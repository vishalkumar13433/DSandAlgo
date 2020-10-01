
public class MergeTwoLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1); 
        list.head.next = new Node(2); 
        list.head.next.next = new Node(4); 
  
        // creating second linked list 
        LinkedList list2 = new LinkedList();
        list2.head = new Node(1); 
        list2.head.next = new Node(3); 
        list2.head.next.next = new Node(4); 
        
        Node res=merge(list.head,list2.head);
        while(res!=null)
        {
        	System.out.print(res.data + " ");
        	res=res.next;
        }
	}

	private static Node merge(Node  l1, Node l2) {
		//ITERATIVE
	      if(l1==null)
	            return l2;
	      if(l2==null)
	            return l1;
	      Node res,temp;
	      if(l1.data <= l2.data)
	      {
	            res=l1;
	            temp=l1;
	            l1=l1.next;
	      }
	      else
	      {
	            res=l2;
	            temp=l2;
	            l2=l2.next;
	      }
	      while(l1!=null && l2!=null)
	      {
	        if(l1.data <= l2.data)
	          {
	                temp.next=l1;
	                temp=l1;
	                l1=l1.next;
	          }
	        else
	           {
	                temp.next=l2;
	                temp=l2;
	                l2=l2.next;
	           }
	        }
	        
	        if(l1!=null)
	        {
	            temp.next=l1;
	        }
	        if(l2!=null)
	        {
	            temp.next=l2;
	        }
	        
	        return res;
	     
	        //Recursive
	        /*
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
	         */
	        
	}

}
