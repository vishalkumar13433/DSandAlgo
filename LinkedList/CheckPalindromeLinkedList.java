
public class CheckPalindromeLinkedList {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.append(1);
		l.append(2);
		l.append(3);
		l.append(4);
		l.append(3);
		l.append(2);
		l.append(1);
		
		
		LinkedList l3=new LinkedList();
		l3.append(1);
		l3.append(2);
		l3.append(2);
		l3.append(1);
		
		
		System.out.println("L1 is Palindrome = " + checkPalindrome(l.head));
		System.out.println("L3 is Palindrome = " + checkPalindrome(l3.head));
	}

	private static boolean checkPalindrome(Node head) {
		if(head==null || head.next==null)
			return true;
		Node slow=head,fast=head,pre=null;
		while(slow!=null && fast!=null && fast.next!=null)
		{
			pre=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		//Slow is mid of LL ,pre is previous to mid
		pre.next=null;
		
		//if Linkedlist is of even length , then fast pointer becomes null
		Node second;
		if(fast==null)
			{
				second=slow;
			}
		else
			{
				second=slow.next;
				slow.next=null;
			}
		
		
		Node rev=reverse(second);
		boolean ans=sameLL(head,rev);
		second=reverse(rev);
		if(fast!=null)
			slow.next=second;
		pre.next=slow;
		return ans;
	}

	private static boolean sameLL(Node first, Node sec) {
		if(first==null && sec==null)
			return true;
		if(first==null || sec==null)
			return false;
		return (first.data == sec.data)&&sameLL(first.next,sec.next);
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
