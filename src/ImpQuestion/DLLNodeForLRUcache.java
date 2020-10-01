package ImpQuestion;

public class DLLNodeForLRUcache {
	int key;
	int val;
	DLLNodeForLRUcache prev,next;
	DLLNodeForLRUcache(int k,int v)
	{
		this.key=k;
		this.val=v;
		this.prev=null;
		this.next=null;
	}
}
