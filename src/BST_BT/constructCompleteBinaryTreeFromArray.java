package src.BST_BT;
public class constructCompleteBinaryTreeFromArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 }; 
		Node root=insertLevelOrder(arr,0);
		preorder(root);
	}
	private static Node insertLevelOrder(int[] arr,int ind) {
		if(ind >= arr.length)
			return null;
		Node root=new Node(arr[ind]);
		root.left=insertLevelOrder(arr,2*ind +1);
		root.right=insertLevelOrder(arr,2*ind +2);
		return root;
	}
	private static void preorder(Node root) {
		if(root==null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
		
	}
}
