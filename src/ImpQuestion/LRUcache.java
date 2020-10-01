package ImpQuestion;

import java.util.HashMap;

public class LRUcache {
		int capacity;
		int cnt;
		HashMap<Integer,DLLNodeForLRUcache> cache;
		DLLNodeForLRUcache head,tail;
		
		public LRUcache(int capacity) {
	        this.capacity=capacity;
	        this.cnt=0;
	        cache=new HashMap();
	       
	        //create two dummy nodes representing head and tail of the DLL
	        head=new DLLNodeForLRUcache(0,0);
	        tail=new DLLNodeForLRUcache(0,0);
	        head.next=tail;
	        tail.prev=head;
	        
	        
	    }
	    
	    public int get(int key) {
	    	//check for the mapping
	    	DLLNodeForLRUcache node=cache.get(key);
	    	
	    	//if page is not there , no mapping
	    	if(node==null)
	    			{
	    				return -1;
	    			}
	    	
	    	//move the node to recently used
	    	moveToHead(node);
	    	
	    	//return the val of the key
	    	return node.val;
	    }
	    
	    public void put(int key, int value) {
	    	DLLNodeForLRUcache node=cache.get(key);
	    	//if page is not there , no mapping
	    	if(node==null)
	    	{
	    		//1.create a new node with the key value
	    		DLLNodeForLRUcache n=new DLLNodeForLRUcache(key,value);
	    		
	    		//2.put it in hashMap
	    		cache.put(key, n);
	    		
	    		//3.add it to the DLL
	    		addNode(n);
	    		cnt++;
	    		
	    		//4.check if page replacement is required
	    		if(cnt > capacity)
	    		{
	    			DLLNodeForLRUcache tail=removeTail();
	    			cache.remove(tail.key);
	    			cnt--;
	    		}
	    	}
	    	else
	    	{
	    		//replace old value with the new one
	    		node.val=value;
	    		
	    		//as it is recent move it to head
	    		moveToHead(node);
	    	}
	    }
	
	private DLLNodeForLRUcache removeTail() {
			DLLNodeForLRUcache node= tail.prev;
			removeNode(node);
			return node;
		}

	private void moveToHead(DLLNodeForLRUcache node) {
		removeNode(node);
		addNode(node);
	}

	private void removeNode(DLLNodeForLRUcache node) {
		DLLNodeForLRUcache prev=node.prev;
		DLLNodeForLRUcache next=node.next;
		
		prev.next=next;
		next.prev=prev;
	}

	//adds a node to DLL
	private void addNode(DLLNodeForLRUcache n) {
			
			//new node will be added towards head;
			n.next=head.next;
			head.next.prev=n;
			n.prev=head;
			head.next=n;
			
		}

	public static void main(String[] args) {
		LRUcache cache = new LRUcache(2);
		
		
		System.out.println(cache.get(1));
		cache.put(1, 1);
		cache.put(2, 2);
		
		System.out.println(cache.get(1)); 
		System.out.println(cache.get(1));// returns 1
		    // evicts key 2
		
		cache.put(3, 3);
		cache.put(4, 4); 
		
		System.out.println(cache.get(2));       // returns -1 (not found)
		   // evicts key 1
		System.out.println(cache.get(1)); 
		System.out.println(cache.get(1));// returns -1 (not found)
		System.out.println(cache.get(3));  
		cache.put(1, 1); // returns 3
		System.out.println(cache.get(1));       // returns 4
	}

}
