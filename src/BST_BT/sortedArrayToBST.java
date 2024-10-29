package src.BST_BT;
public class sortedArrayToBST {

	public static void main(String[] args) {
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7}; 
        int n = arr.length; 
        Node root = sortedArrayToBST(arr, 0, n - 1); 
        inorder(root);
	}

	private static Node sortedArrayToBST(int[] arr, int start, int end) {
		
		if(start > end)
			return null;
		
		int mid=(start+end)/2;
		Node root=new Node(arr[mid]);
		root.left=sortedArrayToBST(arr,start,mid-1);
		root.right=sortedArrayToBST(arr,mid+1,end);
		return root;
	}

	
	private static void inorder(Node root) {
		if(root==null)
				return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}
