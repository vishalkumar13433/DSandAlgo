package LinkedList;

import java.util.HashMap;

public class linkedlistCloneWithRandomPointer {
	LinkedListNodeRandom head;
	
	linkedlistCloneWithRandomPointer(LinkedListNodeRandom head){
		this.head= head;
	}
	
	 public void push(int data) 
	    { 
		 LinkedListNodeRandom node = new LinkedListNodeRandom(data); 
	        node.next = this.head; 
	        this.head = node; 
	    } 
	
	 // Main method. 
    public static void main(String[] args) 
    { 
        // Pushing data in the linked list. 
    	linkedlistCloneWithRandomPointer list = new linkedlistCloneWithRandomPointer(new LinkedListNodeRandom(5)); 
        list.push(4); 
        list.push(3); 
        list.push(2); 
        list.push(1); 
  
        // Setting up random references. 
        list.head.random = list.head.next.next; 
        list.head.next.random = 
            list.head.next.next.next; 
        list.head.next.next.random = 
            list.head.next.next.next.next; 
        list.head.next.next.next.random = 
            list.head.next.next.next.next.next; 
        list.head.next.next.next.next.random = 
            list.head.next; 
  
        // Making a clone of the original linked list. 
        linkedlistCloneWithRandomPointer clone = list.clone(); 
  
        // Print the original and cloned linked list. 
        System.out.println("Original linked list"); 
        list.print(); 
        System.out.println("\nCloned linked list"); 
        clone.print(); 
    } 
	
    void print() 
    { 
    	LinkedListNodeRandom temp = head; 
        while (temp != null) 
        { 
        	LinkedListNodeRandom random = temp.random; 
            int randomData = (random != null)? random.val: -1; 
            System.out.println("Data = " + temp.val + 
                               ", Random data = "+ randomData); 
            temp = temp.next; 
        } 
    } 
    
    public linkedlistCloneWithRandomPointer clone() 
    { 
    	
    	LinkedListNodeRandom temp = this.head;
    	HashMap<LinkedListNodeRandom,LinkedListNodeRandom> hm = new HashMap<>();
    	while(temp != null) {
    		LinkedListNodeRandom newNode= new LinkedListNodeRandom(temp.val);
    		hm.put(temp, newNode);
    		temp = temp.next;
    	}
    	temp = this.head;
    	LinkedListNodeRandom cloneRef;
    	while(temp != null) {
    		cloneRef = hm.get(temp);
    		cloneRef.next = hm.get(temp.next);
    		cloneRef.random = hm.get(temp.random);
    		temp = temp.next;
    	}
    	return new linkedlistCloneWithRandomPointer(hm.get(this.head));
    }
    
    	
    	
}
