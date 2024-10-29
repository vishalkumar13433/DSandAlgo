package src.BST_BT;
import java.util.*;

public class SpiralPrinting {

	static int height(Node root)
	{
		if(root==null)
				return 0;
		int lh=height(root.left);
		int rh=height(root.right);
		
		return (lh>rh)?(1+lh):(1+rh);
	
	}
	public static void main(String[] args)
	{
		BinaryTree b=new BinaryTree();
		b.root=new Node(1);
		b.root.left=new Node(2);
		b.root.right=new Node(3);
		b.root.left.left=new Node(4);
		b.root.left.right=new Node(5);
		b.root.right.left=new Node(6);
		b.root.right.right=new Node(7);
		b.root.left.left.left=new Node(8);
		b.root.left.left.right=new Node(9);
		b.root.left.right.right=new Node(10);
		int height=height(b.root);
		//reverseLevelOrder(b.root);
		//levelOrder(b.root);
		printSpiral(b.root,height);
//		List<List<Integer>> a=new ArrayList<List<Integer>>();
//		a=zigzagLevelOrder(b.root);
//		System.out.println(a.toString());


	}
	
	 public static List<List<Integer>> zigzagLevelOrder(Node root) {
	        int h=height(root);
	        ArrayList<List<Integer>> a=new ArrayList<List<Integer>>();
	        boolean ltr=true;
	        for(int i=1;i<=h;i++)
	        {
	            a.add(returnLevel(root,i,ltr));
	            ltr=!ltr;
	        }
	        return a;
	    }
	 
	 
	private static List<Integer> returnLevel(Node root, int level, boolean ltr) {
		if (root==null)
			return null;
		List<Integer> l=new ArrayList<Integer>();
		if(level==1)
		{
			l.add(root.data);
			return l;
		}
		else if(level>1)
		{
			if(!ltr)
			{
				if(root.right!=null)
					l.addAll(returnLevel(root.right,level-1,ltr));
				if(root.left!=null)
					l.addAll(returnLevel(root.left,level-1,ltr));
			}
			else
			{
				if(root.left!=null)
					l.addAll(returnLevel(root.left,level-1,ltr));
				if(root.right!=null)
					l.addAll(returnLevel(root.right,level-1,ltr));
			}
		}
		
	return l;
	}
	private static void printSpiral(Node root, int height) {
		
		if(root==null)
				return;
		boolean ltr=true;
		for(int i=0;i<height;i++)
		{
			printLevel(root,i,ltr);
			System.out.print("\n");
			ltr=!ltr;
		}
	}
	private static void printLevel(Node root, int level, boolean ltr) {
		if(root==null)
				return;
		if(level==0)
		{
			System.out.print(root.data + " ");
			return;
		}
		if(ltr)
		{
			if(root.left!=null)
				printLevel(root.left,level-1,ltr);
			if(root.right!=null)
				printLevel(root.right,level-1,ltr);
		}
		else
		{
			if(root.right!=null)
				printLevel(root.right,level-1,ltr);
			if(root.left!=null)
				printLevel(root.left,level-1,ltr);
		}
		
	}
	private static void reverseLevelOrder(Node root) {
		Queue<Node>q=new LinkedList<Node>();
		Stack<Integer> s=new Stack<Integer>();
		if(root==null)
				return;
		q.add(root);
		while(q.size()>0)
		{
			root=q.poll();
			s.push(root.data);
			if(root.left !=null)
				q.add(root.left);
			if(root.right!=null)
				q.add(root.right);
		}
		while(!s.isEmpty())
			System.out.println(s.pop());
	}	
	
	static void levelOrder(Node root)
	{
		
		int h=height(root);
		for (int i=h;i>=1;i--)
		{
			printReverseLevelOrder(root,i);
		}
	}
	
	static void printReverseLevelOrder(Node root,int level)
	{
		if(root==null)
			return;
		
		if(level==1)
			{
				System.out.print(root.data+" ");
				return;
			}
		if(level>1)
		{
			if(root.left !=null)
				printReverseLevelOrder(root.left,level-1);
			if(root.right !=null)
				printReverseLevelOrder(root.right,level-1);
		}	
		
	}
}


