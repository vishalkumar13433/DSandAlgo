
public class medianBST {

	public static void main(String[] args) {
		Node root=null;
		root=insert(root,18);
		root=insert(root,36);
		root=insert(root,9);
		root=insert(root,6);
		root=insert(root,12);
		root=insert(root,10);
		root=insert(root,1);
		root=insert(root,8);
		System.out.println("Median of this BST is :"+median(root));
	}
	private static int median(Node root) {
		if(root==null)
			return 0;
		
		int cnt=count(root);
		int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,c=0;
		Node pre=null;
		boolean flag=false;
		if(cnt%2==0)
				flag=true;
		while(root!=null)
		{
			
			if(root.left==null)
			{
				c++;
				if(flag==true)
				{
					if(c==cnt/2)
						first=root.data;
					else if(c==cnt/2 +1)
						{
							second=root.data;
							return (first+second)/2;
						}
				}
				else if(flag==false && c==(cnt+1)/2)
				{
					
					return root.data;
				}
				root=root.right;
			}
			else
			{
				pre=root.left;
				while(pre.right!=null && pre.right!=root)
					pre=pre.right;
				if(pre.right==null)
					{
						pre.right=root;
						root=root.left;
					}
				else if(pre.right==root)
					{
						pre.right=null;
						c++;
						if(flag==true)
						{
							if(c==cnt/2)
								{
									first=root.data;
								}
							else if(c==cnt/2 +1)
							{
								second=root.data;
								return (first+second)/2;
							}
						}
						else if(flag==false && c==(cnt+1)/2)
						{
							
							return root.data;
						}
						
						root=root.right;
					}
			}
		}
		return -1;
	}
	
	private static int count(Node root) 
	{
		if(root==null)	
			return 0;
		int cnt=0;
		Node pre=null;
		while(root!=null)
		{
			if(root.left==null)
			{
				cnt++;
				root=root.right;
			}
			else
			{
				pre=root.left;
				while(pre.right!=null && pre.right!=root)
					pre=pre.right;
				if(pre.right==null)
						{
							pre.right=root;
							root=root.left;
						}
				else if(pre.right==root)
				{
					pre.right=null;
					cnt++;
					root=root.right;
				}
			}
		}
		return cnt;
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
