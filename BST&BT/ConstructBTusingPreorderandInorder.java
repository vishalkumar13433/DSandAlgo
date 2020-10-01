
public class ConstructBTusingPreorderandInorder {
	static int preIndex=0;
	
	public static void main(String[] args) {
		int[] inorder= {9,3,15,20,7};
		int[] preorder= {3,9,20,15,7};
		
		Node root=constructTree(inorder,preorder,0,inorder.length-1);
		preorder(root);
	}

	private static Node constructTree(int[] inorder, int[] preorder, int inStart, int inEnd) {
		if(inStart>inEnd)
			return null;
		int pos=search(inorder,preorder[preIndex],0,inorder.length-1);
		System.out.println("Found at Pos:"+pos);
		Node root=new Node(preorder[preIndex++]);
		root.left=constructTree(inorder,preorder,inStart,pos-1);
		root.right=constructTree(inorder,preorder,pos+1,inEnd);
		return root;
	}

	private static int search(int[] inorder, int val, int start, int end) {
		
	        for(int i=0;i<inorder.length;i++)
	        {
	            if(inorder[i]==val)
	                    return i;
	        }
	        return -1;
	   
	}
	
	
	
	private static void preorder(Node root) {
		if(root==null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
		
	}
	
}
