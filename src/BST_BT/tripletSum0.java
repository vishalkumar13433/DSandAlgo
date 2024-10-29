package src.BST_BT;


public class tripletSum0 {
	static Node head,tail;
	public static void main(String[] args) {
		Node root=null;
		root=insert(root,6);
		root=insert(root,-13);
		root=insert(root,14);
		root=insert(root,-8);
		root=insert(root,15);
		root=insert(root,13);
		root=insert(root,7);
		if(tripletsum0(root))
			System.out.println("Yes");
		else
			System.out.println("NO");
	}
	private static boolean tripletsum0(Node root) {
		if(root==null)
			return false;
		convert2Dll(root);
		
		while(head.right!=tail && head.data<0)
		{
			if(presentDll(-1*head.data))
					{
							System.out.println("1st : "+head.data);
							return true;
					}
			head=head.right;
		}
		return false;
	}
	private static boolean presentDll(int val) {
		Node start=head.right,end=tail;
		while(start !=end)
		{
			int x=start.data;
			int y=end.data;
			if(x+y ==val)
					{
				System.out.println("2nd : "+x);
				System.out.println("3rd : "+y);
						return true;
					}
			if(x+y > val)
					end=end.left;
			else
					start=start.right;
		}
		return false;
	}
	private static void convert2Dll(Node root) {
		if(root==null)
			return ;
		convert2Dll(root.right);
		root.right=head;
		if(head!=null)
				head.left=root;
		head=root;
		if(tail==null)
			tail=root;
		convert2Dll(root.left);
	}
	private static void printList() {
		if(head==null)
			return;
		Node h=head;
		while(h!=null)
		{
			System.out.print(h.data + " ");
			h=h.right;
		}
	}
	private static Node insert(Node root, int val) {
		if(root==null)
		{
			root=new Node(val);
			return root;
		}
		if(root.data > val)
		{
			root.left=insert(root.left,val);
		}
		else if(root.data <val)
		{
			root.right=insert(root.right,val);
		}
		return root;
	}
}
